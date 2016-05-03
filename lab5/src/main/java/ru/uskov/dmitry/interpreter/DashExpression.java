package ru.uskov.dmitry.interpreter;

/**
 * Created by Dmitry on 26.04.2016.
 */
public class DashExpression implements Expression {


    private static final char HYPHEN = '-';
    private static final char DASH = '—';

    @Override
    public void interpert(InterpreterContext context) {
        char[] input = context.getInput().trim().toCharArray();
        StringBuilder output = new StringBuilder(input.length);
        boolean hyphen = false;
        for(int i=0; i<input.length; i++){
            if(input[i]==HYPHEN){
                if(hyphen){
                    output.append(DASH);
                    hyphen = false;
                }
                else {
                    hyphen = true;
                }
            }
            else{
                if(hyphen){
                    output.append(HYPHEN);
                }
                hyphen = false;
                output.append(input[i]);
            }
        }
        context.setOutput(output.toString());
    }
}
