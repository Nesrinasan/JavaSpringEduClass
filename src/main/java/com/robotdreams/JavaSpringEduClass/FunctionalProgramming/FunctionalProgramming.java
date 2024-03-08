package com.robotdreams.JavaSpringEduClass.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class FunctionalProgramming {

    public static void main(String[] args) {
        String sentence = "Bu bir test cümlesi ve bazı kelimeler silinecek";
        List<String> wordsToRemove = Arrays.asList("bir", "ve", "bazı");
     //   removeWordsNonfunc(sentence, wordsToRemove);
      //  removeWords(sentence, wordsToRemove);

        int sum = sum();
        System.out.println(sum);

        sumFunc();
    }

    public static void removeWordsNonfunc(String sentence, List<String> wordsToRemove){

        String newSentence = "";
        List<String> words = Arrays.asList(sentence.split("\\s+"));
        for (String word : words) {
            if(!wordsToRemove.contains(word)){
                newSentence += word + " ";
            }
        }
        System.out.printf(newSentence);

    }

    public static String removeWords(String sentence, List<String> wordsToRemove) {
        List<String> words = Arrays.asList(sentence.split("\\s+"));
        return words.stream()
                .filter(word -> !wordsToRemove.contains(word))
                .collect(Collectors.joining(" ")); //joining birleştirme işlemi.
    }

    public static int sum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    public static int sumFunc(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numberList = numbers.stream().map(num -> num + num).collect(Collectors.toList());

        Integer reduce = numbers.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        return 0;

    }

}
