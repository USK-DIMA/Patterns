package ru.uskov.dmitry.interpreter;


public class SpaceExpression  implements Expression{

    public static final char SPACE = ' ';

    @Override
    public void interpert(InterpreterContext context) {
        char[] input = context.getInput().trim().toCharArray();
        StringBuilder output = new StringBuilder(input.length);
        boolean space = false;
        for(int i=0; i<input.length; i++){
            if(input[i]==SPACE){
                if(space){
                    continue;
                }
                space = true;
            }
            else {
                space = false;
            }
            output.append(input[i]);
        }
        context.setOutput(output.toString());
    }
}
