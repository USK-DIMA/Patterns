package ru.uskov.dmitry;

import ru.uskov.dmitry.interpreter.Expression;
import ru.uskov.dmitry.interpreter.InterpreterContext;
import ru.uskov.dmitry.interpreter.ParagraphExpression;

import java.io.*;

/**
 * Created by Dmitry on 16.05.2016.
 */
public class Client {

    Expression baseExpression = new ParagraphExpression();

    public void startDemonstration() throws FileNotFoundException {
        try {
            String inputText = readFile("input.txt");
            System.out.println("Входящий текст");
            System.out.println(inputText);
            System.out.println("======================================================================");
            System.out.println("Исходящий текст");
            InterpreterContext context = new InterpreterContext(inputText);
            baseExpression.interpert(context);
            System.out.println(context.getOutput());
        } catch (IOException e) {
            System.out.println("Cannot read or write file");
        }
    }

    private  String readFile(String file) throws IOException {
        try(InputStreamReader reader = new InputStreamReader(new FileInputStream("input.txt"), "UTF-8")) {
            StringBuilder  stringBuilder = new StringBuilder();
            char[] buf = new char[256];
            int countChar = buf.length;
            while(countChar==buf.length) {
                countChar = reader.read(buf);
                stringBuilder.append(buf, 0, countChar);
            }
            return stringBuilder.toString();
        }
    }

}
