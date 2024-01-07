package ru.project.example.products.fruits;

import ru.project.example.constants.DiscountConstants;
import ru.project.example.products.Product;
import static ru.project.example.constants.Region.THAILAND;

public abstract class Fruits implements Product  {

    protected int amount;
    protected double price;
    protected String name;
    protected String region;

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

    @Override
    public double getPrice() {
        if (name.equals(DiscountConstants.RED_APPLE)) {
            return price - price * 0.5;
        } else if (name.equals(DiscountConstants.GREEN_APPLE)) {
            return price - price * 0.05;
        }
         else if (region.equals(THAILAND)) {
            return price / 2;
        }
        return price;
    }

    @Override
    public String toString() {
        return "Fruits{название='" + getName() + "'}";
    }
}
