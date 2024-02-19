package com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.constructur;

import java.util.ArrayList;
import java.util.List;

public class MusteriRepo {
    List<String> musteriNameList = new ArrayList<>();
    List<String> musteriNameListShowAdmin = new ArrayList<>();

    {
        musteriNameList.add("Nesrin");
        musteriNameList.add("Burak");
    }


    {
        musteriNameListShowAdmin.add("Doruk");
        musteriNameListShowAdmin.add("Ayşe");
    }
    public List<String> getMusteriNameList() {
        return musteriNameList;
    }

    public void setMusteriNameList(List<String> musteriNameList) {
        this.musteriNameList = musteriNameList;
    }

    public List<String> getMusteriNameListShowAdmin() {
        return musteriNameListShowAdmin;
    }

    public void setMusteriNameListShowAdmin(List<String> musteriNameListShowAdmin) {
        this.musteriNameListShowAdmin = musteriNameListShowAdmin;
    }
}
