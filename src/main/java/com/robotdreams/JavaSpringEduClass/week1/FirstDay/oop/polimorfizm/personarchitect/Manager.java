package com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.polimorfizm.personarchitect;

import com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.polimorfizm.personarchitect.interfaceyapisi.BenefitCompany;

public class Manager extends Employee {

    int floorNumber;
    private final int salaryMultiplier = 1500;

    @Override
    public void workStyle() {
        super.workStyle();
        System.out.println("Manager manages the projects");
    }
    @Override
    public int calculateEmployeeSalary() {
        return salaryMultiplier * totalWorkingYears;

    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }


    @Override
    public void transferringEmployees() {

    }

    @Override
    public void foodService() {

    }
}
