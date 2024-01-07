package ru.project.example;

import ru.project.example.products.supermarket.Goods;
import ru.project.example.products.supermarket.Shop;

import java.util.List;
import java.util.Scanner;


public class Order {

    private Basket basket;
    private final Shop shop;
//    private final List<Goods> goods;
    private double discount = 0;


    public Order(Basket basket, Shop shop) {
        this.basket = basket;
        this.shop = shop;
    }

    public void setDiscountedTotal(double discountedTotal) {
        this.discount = discountedTotal;
    }
    public void checkPromoCodeAndSum() {
        Scanner scanner = new Scanner(System.in);
        String answer;
        boolean hasPromoCode = false;

        System.out.println("У вас есть промокод? (Да/нет)");
        answer = scanner.next();

        if (answer.equalsIgnoreCase("Да")) {
            while (!hasPromoCode) {
                System.out.println("Введите промокод: ");
                String userPromoCode = scanner.next();

                if (userPromoCode.equals(shop.getPromocode().getCode())) {
                    System.out.println("Промокод введен верно");
                    hasPromoCode = true;
                    setDiscountedTotal(0.01);
                    calculateDiscountedTotal();
                } else {
                    System.out.println("Вы ввели неверный промокод");
                    System.out.println("Хотите ввести промокод еще раз? (Да/нет)");
                    answer = scanner.next();
                    if (!answer.equalsIgnoreCase("Да")) {
                        break;
                    }
                }
            }
        } else if (answer.equalsIgnoreCase("Нет")) {
            System.out.println("Хорошо, без промокода");
            calculateSumWithoutPromoCode();
        }
    }

    public void calculateDiscountedTotal() {
        double total = basket.sum();
        double discountedTotal = total * discount;
        double finalSum = total - discountedTotal;
        System.out.println("Сумма к оплате с учетом промокода " + finalSum + " p");
    }

//    public void reduceProductQuantity(Goods goodsItem) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите количество товара для покупки: ");
//        int quantity = scanner.nextInt();
//
//        for (Goods good : goods) {
//            if (good.getProduct().equals(goodsItem.getProduct())) {
//                int currentQuantity = good.getAmount();
//                good.setAmount(currentQuantity - quantity);
//                return;
//            }
//        }
//        throw new RuntimeException("Товар " + goodsItem.getProduct().getName() + " не найден в магазине");
//    }

        public void calculateSumWithoutPromoCode() {
        System.out.println("Сумма к оплате " + basket.sum() + " p");
    }
}

//    public void writeTheDeliveryTime() {
//        System.out.print("Время доставки - ");
//        if (basket.sum() > 1000 && (shop == ShopName.PEREKRESTOK || shop == ShopName.PYATEROCHKA || shop == ShopName.DIKSI)) {
//            System.out.println("В течении 30 минут");
//        } else if (basket.sum() < 1000 && (shop == ShopName.PEREKRESTOK || shop == ShopName.PYATEROCHKA || shop == ShopName.DIKSI)) {
//            System.out.println("120 минут");
//        } else if (basket.sum() > 1000 && (shop == ShopName.VKUSVILL || shop == ShopName.MAGNOLIYA)) {
//            System.out.println("60 минут");
//        } else if (basket.sum() < 1000 && (shop == ShopName.VKUSVILL || shop == ShopName.MAGNOLIYA)) {
//            System.out.println("На следующий день");
//        }
//    }
//}
//    public void applyPromoCode(PromoCode promoCode) {
//        this.promoCode = promoCode;
//    }
//    public double calculateTotalAmountWithoutPromoCode() {
//        return basket.sum();
//        double totalAmount = basket.sum();
//        totalAmount += 100;
//        return totalAmount;
//    }

//    public double calculateTotalAmountWithPromoCode() {
//        double totalAmount = calculateTotalAmountWithoutPromoCode();
//        if (promoCode != null) {
//            double discount = promoCode.calculateDiscount();
//            totalAmount -= totalAmount * discount;
//        }
//        return totalAmount;
//    }

//    public void checkAndGiveThePresent() {
//        if (basket != null) {
//            int itemCount = basket.size();
//            if (itemCount >= 1) {
//                Cakes cakes = new Cakes("Тирамису в подарок");
//                basket.addGood(cakes);
//                System.out.println("Добавлен подарок: " + cakes.getName());
//            } else {
//                System.out.println("Без подарка");
//            }
//
//        }
//    }
