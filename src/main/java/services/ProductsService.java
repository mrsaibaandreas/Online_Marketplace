package services;

import controller.Product;
import controller.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;

public class ProductsService {
    public static ArrayList<Product> products = new ArrayList<Product>();

    public static String _path = PathClass.Main1("/src/main/resources/products.json");
    public static Path _path1 = PathClass.getPathToFile("src/main/resources/", "products.json");


    public static void loadProductsFromFile() throws IOException, ParseException {
        File f = new File(_path);

        if (!f.exists() && !f.isDirectory()) {
            if (f.createNewFile()) {
                System.out.println("File has been created");
            }

        } else {
            JSONParser parser = new JSONParser();

            try (FileReader reader = new FileReader("src/main/resources/products.json")) {
                //Read JSON file
                Object obj = parser.parse(reader);

                JSONArray user_list = (JSONArray) obj;
                System.out.println(user_list);

                //Iterate over employee array


                user_list.forEach(prod -> {
                    System.out.println(prod);

                    products.add(parseJSONObj((JSONObject) prod));
                });


            } catch (org.json.simple.parser.ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static Product parseJSONObj(JSONObject product) {
        return new Product(product.get("name").toString(), product.get("description").toString(), product.get("delivery_date").toString(), (User) userService.parseJSONObj((JSONObject) product.get("company")));

    }

}

