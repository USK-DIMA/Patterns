package ru.uskov.dmitry.example;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/**
 * Шаблон для реализации древовидной структуры
 */
public class CompositeObject<T> {

    public static final String prefix = "-";

    private String tag;

    private String description;

    private int lvl;

    private Class objectClass;

    private T object;

    private Collection<CompositeObject> childs = new ArrayList<>();//пока конкретная реализация. Потом надо предоставить выбор пользователю

    public boolean isLeaf(){
        if (childs.size()==0) {
            return true;
        }
        else {
            return false;
        }
    }

    public Iterator getChild(){
        return childs.iterator();
    }

    public int getChildCount(){
        return childs.size();
    }

    public void addChild(Object o, String tag){
        addChild(o, tag, null);
    }

    public void addChild(Object o, String tag, String description){
        childs.add(new CompositeObject(lvl+1, o.getClass(), o, tag, description));
    }

    public void printTagTree(PrintStream out){
        printTagTree(out, 0);
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLvl() {
        return lvl;
    }

    public Class getObjectClass() {
        return objectClass;
    }

    public T getObject() {
        return object;
    }

    public void deletChildsByTag(){
        //TODO
    }

    public void deletAllChildsByTag(){
        //TODO
    }

    public Collection<CompositeObject> getAllObjects(){
        // TODO: 23.04.2016
        return null;
    }


    private void printTagTree(PrintStream out, int indent){
        for(int i=0; i<indent; i++){
            out.print(" ");
        }
        out.println(prefix+tag);
        if(childs.size()!=0){
            for(CompositeObject o :childs ){
                o.printTagTree(out, indent+tag.length());
            }
        }
    }

    public void printClassTree(PrintStream out){
        printClassTree(out, 0);
    }

    private void printClassTree(PrintStream out, int indent){
        for(int i=0; i<indent; i++){
            out.print(" ");
        }
        out.println(prefix+objectClass);
        if(childs.size()!=0){
            for(CompositeObject o :childs ){
                o.printClassTree(out, indent+objectClass.toString().length());
            }
        }
    }

    private CompositeObject(int lvl, Class objectClass, T object, String tag, String description) {
        this.lvl = lvl;
        this.objectClass = objectClass;
        this.object = object;
        this.tag=tag;
        this.description = description;
    }

    public static class Builder<T>{

        private T object;

        private String tag;

        private String description;

        public Builder object(T object) {
            this.object = object;
            return this;
        }

        public Builder tag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder descrition(String description) {
            this.description = description;
            return this;
        }

        public CompositeObject build(){
            if(tag==null){
                tag="indefined";
            }
            return new CompositeObject(0, object.getClass(), object, tag, description);
        }
    }

}
