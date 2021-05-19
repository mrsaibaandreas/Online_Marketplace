package services;

import controller.User;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class userService {
    private static ArrayList<User> users = new ArrayList<User>();

    public static String _path = PathClass.Main1("/src/main/resources/users.json");
    public static Path _path1 = PathClass.getPathToFile("src/main/resources/", "users.json");


    public static void loadUsersFromFile() throws IOException, ParseException {
        File f = new File(_path);

        if (!f.exists() && !f.isDirectory()) {
            if (f.createNewFile()) {
                User adm = new User("admin", "admin", "admin");//create a default admin
                userService.addNewUser(adm);
                System.out.println("File has been created");
            }

        } else {
            JSONParser parser = new JSONParser();

            try (FileReader reader = new FileReader("src/main/resources/users.json")) {
                //Read JSON file
                Object obj = parser.parse(reader);

                JSONArray user_list = (JSONArray) obj;
                System.out.println(user_list);

                //Iterate over employee array


                user_list.forEach(emp -> {
                    System.out.println(emp);

                    users.add(parseJSONObj((JSONObject) emp));
                });


            } catch (org.json.simple.parser.ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static User parseJSONObj(JSONObject user) {
        return new User(user.get("user_name").toString(), user.get("password").toString(), user.get("f_type").toString());

    }


    public static boolean addNewUser(User user) throws IOException {
        if (checkUserExistence(user.user_name))
            users.add(user);
        else {
            System.out.println("User already exists");
            return false;
        }
        JSONArray user_list = new JSONArray();
        users.forEach(ex_user -> {
                    JSONObject obj_user = new JSONObject();

                    obj_user.put("user_name", ex_user.user_name);
                    ex_user.password = encodePassword(ex_user.user_name, ex_user.password);
                    obj_user.put("password", ex_user.password);
                    obj_user.put("f_type", "user");


                    user_list.add(obj_user);
                }
        );
        try (FileWriter file = new FileWriter("src/main/resources/users.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(user_list.toJSONString());
            file.flush();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean checkUserExistence(String username) {
        for (User user : users)
            if (user.user_name.equals(username)) {
                return false;
            }
        return true;
    }

    public static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

    private static boolean checkPass(User user, String user_name, String pass) {

        pass = encodePassword(user_name, pass);
        System.out.println(user.password);
        if (pass.equals(user.password)) {
            System.out.println();
            System.out.println("yee");
            return true;
        }

        return false;
    }

    public static boolean Login(String user_name, String password) {
        if (checkUserExistence(user_name)) {
            System.out.println("User does not exists");
            return false;
        }
        for (User user : users) {
            if (user.user_name.equals(user_name)) {
                if (checkPass(user, user_name, password)) {
                    System.out.println("Log user");
                    return true;
                } else {
                    System.out.println("Wrong password!");
                    return false;
                }
            }
        }
        return false;

    }

    public static boolean createSupplier(String user_name, String user_name_adm, String password) throws IOException {

        if (Login(user_name_adm, password)) {
            for (User user : users) {
                if (user_name_adm.equals(user.user_name)) {
                    if (user.getRole().equals("admin")) {
                        addNewUser(new User(user_name, user_name, "user"));
                        return true;
                    } else return false;

                } else return false;
            }

        }

        return false;

    }
}
