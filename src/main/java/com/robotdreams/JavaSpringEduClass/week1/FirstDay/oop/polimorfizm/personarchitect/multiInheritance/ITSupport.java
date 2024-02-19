package com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.polimorfizm.personarchitect.multiInheritance;

public interface ITSupport {

    void solveProblem();
    default void prepare() {
        System.out.println("BT destek hazırlıkları yapılıyor.");
    }


}
