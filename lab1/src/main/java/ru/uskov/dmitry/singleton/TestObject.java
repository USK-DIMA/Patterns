package ru.uskov.dmitry.singleton;

/**
 * Created by Dmitry on 16.04.2016.
 */

/**
 * Демонстрация паттерна singleton (одиночка)
 * Корректен для > JVM 1.5
 */
public class TestObject {

    //TODO fields

    /**
     * Экземпляр класса.
     * Можно его инициализировать заранее и убрать инициализачию из метода getInstance(),
     * но в общем случае вдруг придётся принимать какие-то параметры, влияющие на инициализацию
     */
    private volatile TestObject instance = null;


    /**
     * Улучшенная версия метода.
     * @return
     */
    public TestObject getInstance() {
        if(instance==null){
            synchronized (TestObject.class){
                if(instance == null){
                    instance = new TestObject();
                }
            }
        }
        return instance;
    }

    /**
     * Старая версия метода. бОльшие затраты на synchronized
     */
/*    synchronized public TestObject getInstance() {
        if(instance==null){
            instance = new TestObject();
        }
        return instance;
    }*/

    private TestObject(){
        //TODO constructor
    }
}
