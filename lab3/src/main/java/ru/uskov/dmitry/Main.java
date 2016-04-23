package ru.uskov.dmitry;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        CompositeObject compositeObject = new CompositeObject.Builder().object(new String("test")).build();
        compositeObject.addChild(new String("test"), "test1");
        compositeObject.addChild(new String("test"), "test2");
        compositeObject.addChild(new String("test"), "test3");
        Iterator iterator = compositeObject.getChild();
        while (iterator.hasNext()){
            ((CompositeObject)iterator.next()).addChild(new String("test"), "XxxX");
        }
        compositeObject.printClassTree(System.out);
    }
}
