package ru.uskov.dmitry.interpreter;

/**
 * Created by Dmitry on 16.05.2016.
 */
public class ParagraphExpression implements Expression{

    public static final String TAB = "\t";

    Expression sentenceExpression = new SentenceExpression();

    @Override
    public void interpert(InterpreterContext context) {
        String input = context.getInput();
        String[] paragraph = input.split("\n"); //Разбивает текст на абзацы.
        for(int i=0; i<paragraph.length; i++){ //В каждом абзаце удаляем переносы строк и ставим в начало табуляцию.
            if(paragraph[i].equals("") || paragraph[i].equals("\r")){
                continue;
            }
            String goodParagraph = paragraph[i].trim().replace("\t", "");
            InterpreterContext interpreterContext = new InterpreterContext(goodParagraph);
            sentenceExpression.interpert(interpreterContext);
            context.addOutput(TAB+interpreterContext.getOutput()+"\n");
        }
    }
}
