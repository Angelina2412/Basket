package ru.project.example.products.supermarket;

import java.util.List;

public class Discount {

    private final List<Goods> goods;
    private final double discountConstants;

    public Discount(List<Goods> goods, double discountConstants) {
        this.goods = goods;
        this.discountConstants = discountConstants;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public double getDiscountConstant() {
        return discountConstants;
    }
}
