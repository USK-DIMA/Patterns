package ru.uskov.dmitry.interpreter;


public class SentenceExpression implements  Expression{

    Expression spaceExpression;
    Expression dashExpression;
    Expression spaceAfterBeforePunctuationMark;
    Expression quotesExpression;

    public SentenceExpression() {
        this.spaceExpression = new SpaceExpression();
        this.spaceAfterBeforePunctuationMark = new SpaceAfterBeforePunctuationMark();
        this.quotesExpression = new QuotesExpression();
        this.dashExpression = new DashExpression();
    }

    @Override
    public void interpert(InterpreterContext context) {
        spaceExpression.interpert(context);
        context.setInput(context.getOutput());
        dashExpression.interpert(context);
        context.setInput(context.getOutput());
        quotesExpression.interpert(context);
        context.setInput(context.getOutput());
        spaceAfterBeforePunctuationMark.interpert(context);
    }
}
