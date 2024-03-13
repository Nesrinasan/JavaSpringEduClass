package com.robotdreams.JavaSpringEduClass.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParalelStreamAPI {

    public static void main(String[] args) {


        sequentialProcessing();

        parallelProcessing();

    }

    public static void sequentialProcessing() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            numbers.add(new Random().nextInt(100));
        }

        // Zaman ölçümüne başlıyoruz
        long startTime = System.currentTimeMillis();
        numbers.stream()
                .map(n -> n * n)
                .forEach(square -> {
                });

        long endTime = System.currentTimeMillis();

        System.out.println("Sıralı işlem süresi: " + (endTime - startTime) + " ms");

    }

    public static void parallelProcessing() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            numbers.add(new Random().nextInt(100));
        }

        // Zaman ölçümüne başlıyoruz
        long startTime = System.currentTimeMillis();

        // Paralel işlem
        numbers.parallelStream()
                .map(n -> n * n)
                .forEach(square -> {
                });

        long endTime = System.currentTimeMillis();

        System.out.println("Paralel işlem süresi: " + (endTime - startTime) + " ms");

    }

}
