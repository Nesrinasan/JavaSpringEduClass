package com.robotdreams.JavaSpringEduClass.concurrency.Async;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AsyncExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {

                TimeUnit.SECONDS.sleep(2);
                return "İşlem tamamlandı!";
            } catch (InterruptedException e) {
                return "Hata oluştu!";
            }
        });


        System.out.println("Asenkron işlem devam ederken ben başka işler yapabilirim.");


        String result = future.get();

        System.out.println(result);



    }

}
