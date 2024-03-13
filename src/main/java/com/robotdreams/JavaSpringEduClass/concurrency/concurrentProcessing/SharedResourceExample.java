package com.robotdreams.JavaSpringEduClass.concurrency.concurrentProcessing;

public class SharedResourceExample {

    // Statik değişken, tüm thread'ler tarafından paylaşılır

    public static void main(String[] args) {
        // Thread nesneleri oluşturuluyor
        Thread thread1 = new Thread(new Worker());
        Thread thread2 = new Thread(new Worker());
        Thread thread3 = new Thread(new Worker());
        Thread thread4 = new Thread(new Worker());
        Thread thread8 = new Thread(new Worker());


        // Thread'ler başlatılıyor
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread8.start();

    }


}
