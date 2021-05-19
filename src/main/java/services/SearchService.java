package services;

import controller.Product;
import controller.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;

public class SearchService {


    public static String _path = PathClass.Main1("/src/main/resources/products.json");
    public static Path _path1 = PathClass.getPathToFile("src/main/resources/", "prducts.json");
    public static ObservableList<Product> products = FXCollections.observableArrayList();

    public static ObservableList<Product> Search(String input) throws IOException, ParseException {
        ProductsService.loadProductsFromFile();
        products = ProductsService.products;
        ObservableList<Product> result = FXCollections.observableArrayList();
        int check = 0;
        for (Product product : ProductsService.products) {
            if (product.getName().equals(input)) {
                result.add(product);
                check++;
            }
        }
        ;
        if (check == 0) {
            result = null;
            return null;
        }
        products = result;
        return result;


    }
}