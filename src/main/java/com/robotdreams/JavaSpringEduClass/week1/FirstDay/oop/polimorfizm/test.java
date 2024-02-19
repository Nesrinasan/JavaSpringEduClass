package com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.polimorfizm;

import com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.polimorfizm.personarchitect.*;

public class test {

    public static void main(String[] args) {
        CalculateSalaryService maasHesaplamaService = new CalculateSalaryService();

//        Engineer engineer = new Engineer();
//        engineer.setName("Ahmet");
//        maasHesaplamaService.calculateSalary(engineer);
//
//        Manager manager = new Manager();
//        manager.setName("Ayşe");
//        maasHesaplamaService.calculateSalary(manager);

        Employee employee = new Engineer();
        maasHesaplamaService.calculateSalary(employee);

        Employee manager = new Manager();
        maasHesaplamaService.calculateSalary(manager);




    }
}
