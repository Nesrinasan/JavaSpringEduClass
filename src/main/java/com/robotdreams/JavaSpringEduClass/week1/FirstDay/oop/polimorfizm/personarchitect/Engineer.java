package com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.polimorfizm.personarchitect;

import com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.Ogretmen;

public class Engineer extends Employee {

    public void infoDepartmentAndLocation(String info){
        System.out.println(info);
    }

    @Override
    public int calculateEmployeeSalary() {
        int salary = super.calculateEmployeeSalary();
        salary = salary + (salary * 30) / 100 ;
        return salary;
    }

}
