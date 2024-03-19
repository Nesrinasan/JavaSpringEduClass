package com.robotdreams.JavaSpringEduClass.exceptions;

import java.io.*;

public class CheckedExceptions {

    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("C:\\test\\a.txt");
            FileWriter writer = new FileWriter("C:\\test\\b.txt");
            writer.write("Merhaba, bu bir test metnidir.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
