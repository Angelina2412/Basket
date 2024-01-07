package ru.project.example.products.supermarket;

import ru.project.example.products.Product;

public class Goods {

    private final Product product;

    private int amount;
    private final double price;

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public Goods(Product product, int amount, double price) {
        this.product = product;
        this.amount = amount;
        this.price = price;
    }

    public void add(Goods goods) {
    }

    public void remove(Goods goods) {
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "{" + product + amount +
                '}';
    }
}
