package ru.uskov.dmitry.interpreter;

public class QuotesExpression implements Expression {

    private final String[] goodQoutes = {"«", "»"};

    @Override
    public void interpert(InterpreterContext context) {
        String text = context.getInput();
        int iterat = 0;
        while (text.indexOf("\"")!=-1){
            text=text.replaceFirst("\"",goodQoutes[iterat%2]);
            iterat++;
        }
        context.setOutput(text);
    }

}

