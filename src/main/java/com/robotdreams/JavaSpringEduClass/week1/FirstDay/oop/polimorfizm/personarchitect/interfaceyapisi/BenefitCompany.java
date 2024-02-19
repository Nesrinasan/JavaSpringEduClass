package com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.polimorfizm.personarchitect.interfaceyapisi;

public interface BenefitCompany {

    int sayi = 4;
    void transferringEmployees();

    void foodService();

    default void prepare() {
        System.out.println("BT destek hazırlıkları yapılıyor.");
        callPrepare();
    }

    static void callPrepare() {
        System.out.println("BT destek hazırlıkları yapılıyor.");
    }

}
