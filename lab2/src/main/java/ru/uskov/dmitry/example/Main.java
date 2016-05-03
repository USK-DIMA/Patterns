package ru.uskov.dmitry.example;


/**
 *Реализация использования шаблона Паттерна Builder
 */
public class Main {

    public static void main(String[] args) {

        ComplexObject complexObject = new ComplexObject.Builder().field1("f1").field2("f2").field3("f3").field4("f4").build();
    }
}
