package services;

import controller.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;

public class ProductsService {
    public static ObservableList<Product> products = FXCollections.observableArrayList(
            new Product("Demo", "Demo", "Demo", "1", "1")
    );

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
        return new Product(product.get("name").toString(), product.get("description").toString(), product.get("company").toString(),
                product.get("stock").toString(), product.get("price").toString());

    }

    public static boolean addItem(Product product) {

        JSONArray user_list = new JSONArray();
        products.add(product);
        products.forEach(ex_prod -> {
                    JSONObject obj_prod = new JSONObject();

                    obj_prod.put("name", ex_prod.getName());
                    obj_prod.put("description", ex_prod.getDescription());
                    obj_prod.put("price", ex_prod.getPrice());
                    obj_prod.put("stock", ex_prod.getStock());
                    obj_prod.put("company", ex_prod.getComapany());


                    user_list.add(obj_prod);
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
}

