package ru.uskov.dmitry.interpreter;

public class SpaceAfterBeforePunctuationMark implements Expression {

    /**
     * фигуры, до которых убрать пробел
     */
    private final char[] figA = {')' , '.' , ',' };

    /**
     * фигуры, посоле которых убрать пробел
     */
    private final char[] figB = {'('};

    @Override
    public void interpert(InterpreterContext context) {
        context.setOutput(context.getInput());
        String text = context.getInput();
        for(char f : figA){
            int i=0;
            while (i>-1){
                i = text.indexOf(f, i+1);
                if(i>0 && text.charAt(i-1)==' '){
                    text = removeCharByIndex(text, i-1);
                }
            }
        }

        for(char f : figB){
            int i=0;
            while (i>-1){
                i = text.indexOf(f, i+1);
                if(i<text.length()-1 && text.charAt(i+1)==' '){
                    text = removeCharByIndex(text, i+1);
                }
            }
        }

        context.setOutput(text);
    }

    private String removeCharByIndex(String text, int i) {
        return text.substring(0, i)+text.substring(i+1, text.length());
    }
}
