package controller;

public class Product {
    private String name;
    private String description;
    private String company;
    private String stock;
    private String price;

    public Product(String name, String description,String company,String stock, String price) {
        this.name = name;
        this.description = description;
        this.company = company;
        this.stock = stock;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }



    public String getComapany() {
        return this.company;
    }
    public String getStock()
    {
        return this.stock;
    }
    public String getPrice()
    {
        return this.price;
    }

    public boolean equals(String name) {
        if (this.name.equals(name))
            return true;
        else return false;

    }
}
