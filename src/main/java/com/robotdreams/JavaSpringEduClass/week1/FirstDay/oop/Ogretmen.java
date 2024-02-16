package com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop;

public class Ogretmen {

    private String name;
    private int yasi;



    /**
     * method adı: okulaGit
     * method return type: void
     */
    public void okulaGit(){
        System.out.println("Öğretmen saat 9 da okula gider.");
    }

    public String getAdi() {
        return name;
    }

    public void setAdi(String adi) {
        this.name = adi;
    }

    public void setYasi(int yasi) {
        if(yasi < 0){
            System.out.println("yaş depperi negatif olamaz");
        }else {
            this.yasi = yasi;
        }
    }
}
