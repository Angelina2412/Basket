package ru.project.example.constants;

public enum  PromoType {

    OCTOBER(0.1),
    NEW(0.2),
    SECOND(0.15);

    private final double value;

    PromoType(double value) {this.value = value;}

    public double getValue() {return value;}

}
