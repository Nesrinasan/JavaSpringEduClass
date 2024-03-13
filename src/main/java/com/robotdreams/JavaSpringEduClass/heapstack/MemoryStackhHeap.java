package com.robotdreams.JavaSpringEduClass.heapstack;



import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class MemoryStackhHeap {
    public static void main(String[] args) {
        /**
         * Method değişkenleri stackte tutulur. Object değişkenleri heapte tutulur.
         */

        Product ogrenci = new Product();
        ogrenci.setName("Nesrin");
//
//        /**
//         * ilkel veri tipleri veriye sahiptir.
//         * Referans veri tipleri ise veriyi gösterir.
        //Java pass by ref, pass by value
//         *
//         */
//        int a = 3;
//        int b = a;
//        a = 4;
//        System.out.println("a nın değeri" + a);
//        System.out.println("b nin değeri" + b);
////
//        String str1 = new String("a");
//        String str2 = new String("b");
//        String temp = str1; //a
//        str1 = str2; //b
//        str2 = temp;
////
//        System.out.println("str1 nin değeri: " + str1);
//        System.out.println("str2 nin değeri: " + str2);
//        System.out.println("temp nin değeri: " + temp);


//         Ogrenci ogrenci = new Ogrenci();
//         ogrenci = null; // kayıp onject olarak hafızada kalır.memory leak oluşabilir, GC bunu halleder.

        /**
         * örnek: heap memory hatası
         */


        /**
         * Stack memory hatası
         */
        //stackOverFlowExp(1);

        /**
         * Heap memory hatası
         */
        heapMemory();

    }

    public static void stackOverFlowExp(int num) {
        System.out.println("Number: " + num);
        if (num == 0)
            return;
        else
            stackOverFlowExp(num += 10000000);
    }


    public static void heapMemory() {
        int i = 0;
        //-Xmx20M
        List<String> list = new ArrayList<>();


        String s = "";
        while (true) {

            String isim = new String("Nesrin");
             s = s + isim;
            System.out.println(isim + "." + i);
            System.out.println(s );
            list.add(s + "." + i);
            i++;
        }


    }

    /**
     * Heap GC tarafından temizlenir.
     * objenin referansı boşa çıkınca toplamaya başlar.
     * Heapte yer kapladığı halde kendisini referans eden bir veri yoksa silinir.
     */

}
