package services;
import controller.User;

import java.io.File;
import java.io.FileReader;
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
    public static Path _path1 = PathClass.getPathToFile("src/main/resources/","users.json");


    public static void loadUsersFromFile() throws IOException, ParseException {
        File f = new File(_path);

        if (!f.exists() && !f.isDirectory()) {
            if (f.createNewFile()) {
                User adm = new User("admin", "admin", "admin");//create a default admin
                users.add(adm);
                System.out.println("File has been created");
            }

        } else {
            JSONParser parser = new JSONParser();

            FileReader read = new FileReader(_path);

            Object obj = parser.parse(read);
            JSONArray user_list = (JSONArray) obj;

            user_list.forEach(emp ->
                    users.add(parseJSONObj((JSONObject) emp)));


        }
    }

    public static User parseJSONObj(JSONObject user) {
        JSONObject employeeObject = (JSONObject) user.get("user");
        System.out.println(employeeObject.get("user_name").toString()+ employeeObject.get("password").toString()+ employeeObject.get("f_type").toString());
        User test = new User(employeeObject.get("user_name").toString(), employeeObject.get("password").toString(), employeeObject.get("f_type").toString());
        System.out.println(test);
        return new User(employeeObject.get("user_name").toString(), employeeObject.get("password").toString(), employeeObject.get("f_type").toString());

    }


    public static void addNewUser(User user) throws IOException {
        if(checkUserExistence(user.user_name))
            users.add(user);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(_path1.toFile(), users);
    }
    public static boolean checkUserExistence(String username) {
        for (User user : users)
            if (!user.user_name.equals(username))
                return false;
        return true;
    }
}
