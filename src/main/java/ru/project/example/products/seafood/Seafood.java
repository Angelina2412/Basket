package ru.project.example.products.seafood;

import ru.project.example.products.Product;

public abstract class Seafood implements Product {

    protected int amount;
    protected double price;
    protected String name;

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public String  getName() {
        return name;
    }

    @Override
    public void setPrice(double price) {
        this.price = (int) price;
    }

    @Override
    public String toString() {
        return "Seafood{название='" + getName() + "'}";
    }
}
