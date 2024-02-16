package com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.polimorfizm.personarchitect;


import com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.polimorfizm.personarchitect.multiInheritance.BenefitCompany;

public abstract class Employee {

    private int tckn;
    private String name;
    private final int CONSTANT = 500;

    protected int totalWorkingYears;

    public void workStyle(){
        System.out.println("Employee have been working");
    }

    public int calculateEmployeeSalary(){
        int salary = totalWorkingYears * CONSTANT;
        return salary;
    }

    public int getTotalWorkingYears() {
        return totalWorkingYears;
    }

    public void setTotalWorkingYears(int totalWorkingYears) {
        this.totalWorkingYears = totalWorkingYears;
    }

    public int getTckn() {
        return tckn;
    }

    public void setTckn(int tckn) {
        this.tckn = tckn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
