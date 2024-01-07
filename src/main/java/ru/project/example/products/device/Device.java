package ru.project.example.products.device;

import ru.project.example.products.Product;

public abstract class Device implements Product {
    protected int amount;
    protected double price;
    protected String name;
    protected String color;

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setPrice(double price) {
        this.price = (int) price;
    }

    public String getColor() {
        return color;
    }
}
