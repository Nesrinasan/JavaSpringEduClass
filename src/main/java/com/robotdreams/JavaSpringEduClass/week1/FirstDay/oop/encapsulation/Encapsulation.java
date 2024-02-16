package com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.encapsulation;


public class Encapsulation {

    public void printInfos(){

        Ogrenci o = new Ogrenci();
        String adi = o.getAdi();


    }
    /**
     * Sarmallama olarakta bilinir.
     * . Java Encapsulation aslında java sınıfı içerisinde tanımladığımız değişkenlerimizi
     * korumak veya saklamak anlamanına gelmektedir. Tanımladığımız bir sınıf içerisindeki
     * değişkenin direk olarak değiştirilememesi,
     * bunun yerine bizim izin verdiğimiz ölçüde, metotlar aracılığıyla değiştirilmesi gerekmektedir
     * Verilerimizi dış dünyaya karşı istediğimiz şekilde işleyebilmemize olanak sağlayan yapıdır.
     *
     * Yani sınıflar dışarıya hizmet verirken iç hizmetinin saklı kalmasını sağlar.
     * @param args
     */
   // public static void main(String[] args) {
     //   Ogrenci ogrenci = new Ogrenci();
       // String adi = ogrenci.getAdi();
       // ogrenci.setYas(25);

    //}
    /**
     * Örnek: Ogrenci classı içerisinde bulunan ve 100 adet classta kullanılan bir değişkene direkt ulaşım var.
     * Ve değişkenin adını değiştirmek istiyorum.
     *
     */

    /**
     * Bir öğrenci tanımlarken yaşını negatif girememelisin
     */

    /**
     * get/set methodları encapsulation yapmamıza yarayan özel methodlardır.
     * Kullanımına dikkat etmek gerekir.
     * Daha çok API taraflarında kullanmak daha uygundur.
     */
    public static void main(String[] args) {
        Kitap kitap = new Kitap();
        kitap.adi = "sfsdf";
        kitap.setAdi("dafesf");

        kitap.setAdi("Karıncanın Su İçtiği");
        kitap.setSayfaSayisi(700);
        kitap.printBookInfo();

        printInfo(kitap);
    }

    public static void printInfo(Kitap kitap){
        //hizmet ilişkisi yoktur. Bilgi alışverişi vardır sadece.
        String adi = kitap.getAdi();
        int sayfaSayisi = kitap.getSayfaSayisi();
        System.out.println("Kitap adı:" + adi + "sayfa sayısı:" + sayfaSayisi);

    }

}
