package ru.uskov.dmitry;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {
            new Client().startDemonstration();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
