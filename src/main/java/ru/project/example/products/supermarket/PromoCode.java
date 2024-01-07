package ru.project.example.products.supermarket;

import ru.project.example.constants.PromoType;

public class PromoCode{
    private String code;

    public PromoCode(PromoType code) {
        this.code = String.valueOf(code);
    } //почему так?

    public double calculateDiscount() {
        if (code.equals("FIRST")) {
            return 0.2;
        } else if (code.equals("SECOND")) {
            return 0.1;
        } else {
            return 0.0;
        }
    }

    public String getCode() {
        return code;
    }
}
