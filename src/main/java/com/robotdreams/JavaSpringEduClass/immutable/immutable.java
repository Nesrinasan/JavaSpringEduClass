package com.robotdreams.JavaSpringEduClass.immutable;

public class immutable  {

    public static void main(String[] args) {

        String s = "nesrin";
        String c = s;
        s += "burak";

        System.out.printf(c+" \n");
        System.out.printf(s+" \n");
        System.out.println("******************");

        StringBuilder stringBuilder = new StringBuilder("nesrin");
        StringBuilder stringBuilder1 = stringBuilder;
        stringBuilder.append("burak");

        System.out.println(stringBuilder1);
        System.out.println(stringBuilder1);



    }
}
