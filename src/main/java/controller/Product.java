package controller;

public class Product {
    private String name;
    private String description;
    private User company;
    private int stock;
    private Double price;

    public Product(String name, String description,User company,int stock, Double price) {
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
        return this.company.user_name;
    }
    public int getStock()
    {
        return this.stock;
    }
    public Double getPrice()
    {
        return this.price;
    }

    public boolean equals(String name) {
        if (this.name.equals(name))
            return true;
        else return false;

    }
}
