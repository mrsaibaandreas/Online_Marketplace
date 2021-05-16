package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import controller.User;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

public class userService {
    private static List<User> users;

    public static String _path = PathClass.Main("/src/main/resources/users.json");


    public static void loadUsersFromFile() throws IOException {
        File f = new File(_path);
        if (!f.exists() && !f.isDirectory()) {
            if (f.createNewFile()) {
                System.out.println("File has been created");
            }

        } else {
            System.out.println("File already exists");
        }
    }

   public static void checkUserExistence(String username)
   {

   }
}
