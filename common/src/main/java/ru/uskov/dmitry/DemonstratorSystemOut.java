package ru.uskov.dmitry;

/**
 * Общий класс демонстрации лабораторной работы.
 * TODO реализовать сообщения о начале/окончании демонстрации через АОП
 */
abstract public class DemonstratorSystemOut {

    /**
     * Название демонстрации
     */
    String name;

    //TODO Вынести все сообщения в отдельный файл ресурсов
    String prefixStartDemonstration = "Start demonstration: ";

    String prefixEndDemonstration = "End demonstration: ";

    public DemonstratorSystemOut(String name) {
        this.name = name;
    }

    protected abstract void run();

    public void start(){
        onStart();
        run();
        onEnd();
    }

    private void onStart(){
        System.out.println("============================================================================");
        System.out.println(prefixStartDemonstration + name);
    }

    private void onEnd(){
        System.out.println(prefixEndDemonstration + name);
        System.out.println("============================================================================");
    }
}
