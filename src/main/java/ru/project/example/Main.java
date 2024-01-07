package ru.project.example;

import ru.project.example.constants.PromoType;
import ru.project.example.constants.ShopName;
import ru.project.example.products.Product;
import ru.project.example.products.fruits.Apple;
import ru.project.example.products.fruits.Pineapple;
import ru.project.example.products.seafood.Fish;
import ru.project.example.products.snacks.Chips;
import ru.project.example.products.supermarket.Discount;
import ru.project.example.products.supermarket.Goods;
import ru.project.example.products.supermarket.PromoCode;
import ru.project.example.products.supermarket.Shop;
import ru.project.example.products.sweets.Cookies;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        Pineapple pineapple = new Pineapple("Ананас");
        products.add(pineapple);

        Apple redApple = new Apple("Красные яблоки");
        products.add(redApple);

        Apple redApple1 = new Apple("Красные яблоки");
        products.add(redApple1);

        Apple greenApple = new Apple("Зеленые яблоки");
        products.add(greenApple);

        Fish fish = new Fish("Щука");
        products.add(fish);

        Cookies cookies = new Cookies("Oreo");
        products.add(cookies);

        Chips chips = new Chips("Nachos");
        products.add(chips);

        Chips suhariki = new Chips("Lays");
        products.add(suhariki);

        Chips nahoc = new Chips("7 корочек");
        products.add(nahoc);

        PromoCode promoCode = new PromoCode(PromoType.OCTOBER);
        List<Goods> goods = new ArrayList<>();

        Discount discount = new Discount(goods, 0.1);

        Goods goods1 = new Goods(pineapple, 600, 10);
        goods.add(goods1);

        Goods goods2 = new Goods(redApple, 500, 5);
        goods.add(goods2);

        Goods goods3 = new Goods(greenApple, 1000, 1);
        goods.add(goods3);

        Goods goods4 = new Goods(fish, 300, 100);
        goods.add(goods4);

        Goods goods5 = new Goods(cookies, 400, 22);
        goods.add(goods5);

        Goods goods6 = new Goods(chips, 4000, 20);
        goods.add(goods6);

        Goods goods7 = new Goods(suhariki, 400, 2);
        goods.add(goods7);

        Goods goods8 = new Goods(nahoc, 750, 45);
        goods.add(goods8);

        Goods goods9 = new Goods(redApple1, 750, 45);
        goods.add(goods9);

        Shop perekrestok = new Shop(ShopName.PEREKRESTOK.name(), goods, discount, promoCode);

        System.out.println("Shop Name: " + perekrestok.getShopName());
        System.out.println("Products: " + perekrestok.getGoods());
        System.out.println("Discount: " + perekrestok.getDiscount().getDiscountConstant());
        System.out.println("Promo Code: " + perekrestok.getPromocode().getCode());

        Basket basket = new Basket();
        perekrestok.addProductToBasket(basket); //можно убрать связь магазин - корзина, разделить check и add
        Order order = new Order(basket, perekrestok);
        order.checkPromoCodeAndSum();
        perekrestok.printProductNamesAndAmounts(goods);
    }


    // Добавить цикличность добавления товаров, чтобы был не 1 - сделала
    // Добавить вопрос "Есть ли у вас промокод?" - сделала
    // Подсчет суммы (со скидкой и без) - сделала
    // Итоговый вывод продуктов в магазине - сделала
    // добавить артикул

}




/*
Discount discount = new Discount(goods, 0.1);
PromoCode promoCode = new PromoCode(PromoType.OCTOBER);
Shop perekrestok = new Shop(ShopName.PEREKRESTOK.name());
perekrestok.addItems(items.json);
perekrestok.showItems();
Basket basket = new Basket();
Goods good = perekrestok.addProductToBasket(basket);
Order order = new Order(basket, perekrestok);
perekrestok.showItems();
 */





























//TODO: класс скидки на определенные продукты (любые) например, на яблоки во вкусвилле скидка 50%
// добавить другой интерфейс с техникой и соответствующие классы
// применение промокода (класс промокодов) которые применяют скидку на всю корзину
// вывод общей суммы без промокода и с учетом промокода (доп задание сумма без всех скидок и сумма со всеми скидками)
// условие подарка: при покупке определенного кол-ва чего-то в корзину добавляется что-то
// при выводе в корзине уточнять, что это подарочная позиция

//TODO: 1. Избавляемся от логики в моделях (продуктах)
// 2. Переписываем Discount на класс, принимающий продукт и размер скидки. Эти параметры ты будешь задавать уже в Main
// 3. Переписываем Promo на Enum со значениями промо (например, PROMO FIRST = 0.2...)
// 4. Добавляем сущность магазин. Наполняем магазин продуктами уже в Main


//TODO(ПОСЛЕДНЕЕ):
// Переопределение ToString СДЕЛАЛА
// Выносим всю логику из классов-моделей (фрукты, сифуды) СДЕЛАЛА
// Структура проекта, навести порядок ПЕРЕД СДАЧЕЙ ПРОЕКТА ЕЩЕ РАЗ ПОСМОТРЕТЬ
// Создать объекты класса Goods в Main (СДЕЛАЛА)
// Переписать в некоторых классах Products на Goods (СДЕЛАЛА)
// Реализовать метод apply() в классе Order
// Проверить, что товара стало меньше