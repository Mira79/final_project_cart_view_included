package com.example.recyclerview;

public class Product {
    private String name;
    private String price;
    private String url;

    public Product(String name, String price, String url) {
        this.name = name;
        this.price = price;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }
}
