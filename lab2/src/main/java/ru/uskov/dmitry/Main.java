package ru.uskov.dmitry;


import ru.uskov.dmitry.ComplexObject;

/**
 *Реализация использования шаблона Паттерна Builder
 */
public class Main {

    public static void main(String[] args) {

        ComplexObject complexObject = new ComplexObject.Builder().buildFiled1("f1").buildFiled2("f2").buildFiled3("f3").buildFiled4("f4").build();
    }
}
