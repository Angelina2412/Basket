package ru.project.example.products.supermarket;

import ru.project.example.Basket;
import ru.project.example.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    private final String shopName;
    private final List<Goods> goods;
    private final Discount discount;
    private final PromoCode promoCode;

    public Shop(String shopName, List<Goods> goods, Discount discount, PromoCode promoCode) {
        this.shopName = shopName;
        this.goods = goods;
        this.discount = discount;
        this.promoCode = promoCode;
    }

    public String getShopName() {
        return shopName;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public Discount getDiscount() {
        return discount;
    }

    public PromoCode getPromocode() {
        return promoCode;
    }


    public Goods addProductToBasket(Basket basket) {
        Goods good;
        Scanner scanner = new Scanner(System.in);
        String answer;
        do {
            good = getGoodsByName();
            try {
                checkAvailability(basket, good);
            } catch (RuntimeException e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
            System.out.println("Добавить еще товар? (Да/нет)");
            answer = scanner.next();
        } while (!answer.equalsIgnoreCase("нет"));
        return good;
    }

    private Goods getGoodsByName() {
        System.out.print("Введите название продукта: ");
        Scanner scanner = new Scanner(System.in);
        String searchQuery = scanner.nextLine();

        List<Goods> matchingProducts = new ArrayList<>();

        for (Goods goods : goods) {
            if (goods.getProduct().getName().contains(searchQuery)) {
                matchingProducts.add(goods);
            }
        }

        switch (matchingProducts.size()) {
            case 0:
                throw new IllegalArgumentException("Продукт не найден в магазине");
            case 1:
                return matchingProducts.get(0);
            default:
                System.out.println("Найдены похожие товары, выберите из списка:");
                for (int i = 0; i < matchingProducts.size(); i++) {
                    System.out.println((i + 1) + ". " + matchingProducts.get(i).getProduct().getName());
                }

                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= matchingProducts.size()) {
                    return matchingProducts.get(choice - 1);
                } else {
                    throw new IllegalArgumentException("Неверный выбор товара");
                }
        }
    }

    private void checkAvailability(Basket basket, Goods good) {
        System.out.print("Введите количество товара: ");
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        scanner.nextLine();

        if (checkProductQuantity(good.getProduct(), quantity)) {
            basket.addGood(good, quantity);
            basket.displayAllGoods();
        } else {
            throw new RuntimeException("Товара нет в магазине");
        }
        reduceProductQuantity(good, quantity);

    } //либо обрабатываешь try-cath (логика) либо запись в лог с последующей логикой


    public boolean checkProductQuantity(Product product, int requiredQuantity) {
        int availableQuantity = 0;

        for (Goods goods : goods) {
            if (goods.getProduct().equals(product)) {
                availableQuantity += goods.getAmount();
            }
        }
        if (availableQuantity >= requiredQuantity) {
            System.out.println("Продукт доступен в нужном количестве");
            return true;
        } else {
            System.out.println("Продукта нет в нужном количестве");
            return false;
        }
    }

    public void reduceProductQuantity(Goods goodsItem, int quantity) {
        for (Goods good : goods) {
            if (good.getProduct().equals(goodsItem.getProduct())) {
                int currentQuantity = good.getAmount();
                good.setAmount(currentQuantity - quantity);
                return;
            }
        }
        throw new RuntimeException("Товар " + goodsItem.getProduct().getName() + " не найден в магазине");
    }

    public void printProductNamesAndAmounts(List<Goods> goodsList) {
        for (Goods goods : goodsList) {
            Product product = goods.getProduct();
            String productName = product.getName();
            int productAmount = goods.getAmount();
            System.out.println("Наличие в магазине " + productName + " - " + productAmount);
        }
    }

}

