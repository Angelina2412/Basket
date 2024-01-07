package ru.project.example.products.sweets;

import ru.project.example.products.Product;

public abstract class Sweets implements Product {

    protected int amount;
    protected double price;
    protected boolean isHealthy;
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
    public String getName() {
        return name;
    }

    @Override
    public void setPrice(double price) {
        this.price = (int) price;
    }

    public boolean isVegetarian() {
        return isHealthy;
    }

    @Override
    public String toString() {
        return "Sweets{name='" + getName() + "'}";
    }

}
