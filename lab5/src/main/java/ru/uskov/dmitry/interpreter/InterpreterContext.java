package ru.uskov.dmitry.interpreter;

/**
 * Created by Dmitry on 26.04.2016.
 */
public class InterpreterContext {

    private String input;

    private String output;

    public InterpreterContext(String input) {
        this.input = input;
        output="";
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
