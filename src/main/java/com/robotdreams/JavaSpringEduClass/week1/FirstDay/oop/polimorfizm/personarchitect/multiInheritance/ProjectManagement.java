package com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.polimorfizm.personarchitect.multiInheritance;

public interface ProjectManagement {
    void manageProject();
    default void prepare() {
        System.out.println("Proje yönetimi hazırlıkları yapılıyor.");
    }
}
