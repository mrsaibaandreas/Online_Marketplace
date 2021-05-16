package services;

public class PathClass {

    public static String Main(String... path)
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
