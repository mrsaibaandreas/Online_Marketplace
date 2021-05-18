package services;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathClass {

    private static final String APPLICATION_FOLDER = "ajutor cu andy";
    private static final String USER_FOLDER = System.getProperty("user.dir");
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER);

    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get("", path));
    }
    public static String Main1(String... path)
    {
        return (System.getProperty("user.dir").toString()+ convertStringArrayToString(path,","));
    }

    private static String convertStringArrayToString(String[] strArr, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr)
            sb.append(str).append(delimiter);
        return sb.substring(0, sb.length() - 1);
    }
}
