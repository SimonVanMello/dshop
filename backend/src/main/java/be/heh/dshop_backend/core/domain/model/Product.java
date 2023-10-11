package be.heh.dshop_backend.core.domain.model;

import lombok.Getter;
import lombok.Setter;

public class Product {
    @Getter
    @Setter
    private int id = -1;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private double price;
    @Getter
    @Setter
    private byte[] img;
    @Getter
    @Setter
    private int quantity;

    public Product(int id, String name, double price, byte[] img, int quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.quantity = quantity;
    }

    public Product(String name, double price, byte[] img, int quantity){
        this.name = name;
        this.price = price;
        this.img = img;
        this.quantity = quantity;
    }
}