package services;

import controller.Product;
import controller.User;

import java.nio.file.Path;
import java.util.ArrayList;

public class SearchService {


    public static String _path = PathClass.Main1("/src/main/resources/products.json");
    public static Path _path1 = PathClass.getPathToFile("src/main/resources/", "prducts.json");

    public static ArrayList<Product> Search(String input)
    {
        ArrayList<Product> result = new ArrayList<Product>();
        int check = 0;
        for(Product product : ProductsService.products)
        {
            if(product.equals(input))
            {
                result.add(product);
                check++;
            }
        };
        if(check == 0)
        {
            result = null;
            return null;
        }
        return result;



    }
}