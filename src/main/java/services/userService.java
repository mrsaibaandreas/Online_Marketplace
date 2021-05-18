package services;

import controller.User;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

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


            }
        }
    }

    public static User parseJSONObj(JSONObject user) {
        return new User(user.get("user_name").toString(), user.get("password").toString(), user.get("f_type").toString());

    }


    public static void addNewUser(User user) throws IOException {
        if (!checkUserExistence(user.user_name))
            users.add(user);

        JSONArray user_list = new JSONArray();
        users.forEach(ex_user -> {
                    JSONObject obj_user = new JSONObject();

                    obj_user.put("user_name", ex_user.user_name);
                    obj_user.put("password", ex_user.password);
                    obj_user.put("f_type", "user");


                    user_list.add(obj_user);
                }
        );
        try (FileWriter file = new FileWriter("src/main/resources/users.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(user_list.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkUserExistence(String username) {
        for (User user : users)
            if (!user.user_name.equals(username))
                return false;
        return true;
    }
    public static
}
