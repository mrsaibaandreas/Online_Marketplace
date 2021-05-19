package controller;

public class Product {
    public String name;
    public String description;
    public String delivery_Date;
    public User company;

    public Product(String name, String description, String delivery_Date, User company) {
        this.name = name;
        this.delivery_Date = delivery_Date;
        this.description = description;
        this.company = company;
    }

    public boolean equals(String name) {
        if (this.name.equals(name))
            return true;
        else return false;

    }
}
