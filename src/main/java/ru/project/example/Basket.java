package ru.project.example;

import ru.project.example.products.supermarket.Goods;
import ru.project.example.products.supermarket.Shop;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Goods> goods;

    public Basket() {
        goods = new ArrayList<>();
    }

    public void addGood(Goods goods, int quantity) {
        Goods good = new Goods(goods.getProduct(), quantity, goods.getPrice());
        this.goods.add(good);
    }

    public void addGood(Goods goods) {
        this.goods.add(goods);
    }

    public void removeGood(Goods goods) {
        goods.remove(goods);
    }

    public double sum() {
        double sum = 0;
        for (Goods goods : goods) {
            sum = sum + goods.getAmount() * goods.getPrice();
        }
        return sum;
    }

    public void displayAllGoods() {
        for (Goods goods : goods) {
            System.out.println(goods.getProduct() + " - " + goods.getAmount() + " - " + goods.getPrice());
        }
    }

    public int size() {
        return goods.size();
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void clearBasket() {
        goods.clear();
    }
//    public void apply(Shop shop, Basket basket) {
//        for (Goods goods : basket.getGoods()) {
//            int quantity = goods.getAmount();
//            if (shop.checkProductQuantity(goods.getProduct(), quantity)) {
//                shop.reduceProductQuantity(goods, quantity);
//            } else {
//                throw new RuntimeException("Товара " + goods.getProduct().getName() + " недостаточно в магазине");
//            }
//        }
//        basket.clearBasket();
//    }
}

