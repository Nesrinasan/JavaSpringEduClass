package com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.constructur;

import java.util.List;

public class MusteriService {

    private String employeeType;
    private String companyName;


    public MusteriService(String calisanType){
        this();
        this.employeeType = calisanType;
    }

    public MusteriService(String calisanType, String companyName){
        this(calisanType);
        this.companyName = companyName;

    }
    public MusteriService(){
        System.out.println("Musteri servisi çağrıldı.");
    }

    public List<String> getMusteriListesi(){

        MusteriRepo musteriRepo = new MusteriRepo();
        if(employeeType.equals("admin")){
            return musteriRepo.getMusteriNameListShowAdmin();

        }else{
            return  musteriRepo.getMusteriNameList();

        }
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
}
