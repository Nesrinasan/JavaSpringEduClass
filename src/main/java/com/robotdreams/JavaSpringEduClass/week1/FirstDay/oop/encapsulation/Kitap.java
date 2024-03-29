package com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.encapsulation;

public class Kitap {

    private int sayfaSayisi;
    public String adi;
    public Kitap(){
        System.out.println("Kitap nesnesi oluşuyor.");
    }

    /**
     * instance init.
     * conts.dan önce çalışır. değişkenlerin yüklenmesi gibi.
     */
    {
        System.out.println("Kitaaap objesi oluşuyor.");
    }

    public int getSayfaSayisi() {
        return sayfaSayisi;
    }

    public void setSayfaSayisi(int sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        if(!adi.contains("cocuk")){
            return;
        }
        this.adi = adi;
    }

    public void printBookInfo() {
        System.out.println("Kitap adı:" + adi + "sayfa sayısı:" + sayfaSayisi);
    }


}
