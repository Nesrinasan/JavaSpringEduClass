package com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.polimorfizm.personarchitect;

public class CalculateSalaryService {

    public void calculateSalary(Employee employee){
        employee.setTotalWorkingYears(4);
        int salary = employee.calculateEmployeeSalary();
        System.out.println("manager salary" + salary);
    }


}
