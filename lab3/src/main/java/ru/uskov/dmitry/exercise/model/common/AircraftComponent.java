package ru.uskov.dmitry.exercise.model.common;

import java.io.PrintStream;
import java.util.*;


/**
 * Основной класс для создания структуры самолёта
 */
abstract public class AircraftComponent {

    public static final String prefix = "-";

    protected AircraftItemType type;

    protected String description;

    protected int lvl;


    public AircraftComponent(AircraftItemType type, String description) {
        this.lvl = 0;
        this.type= type;
        this.description = description;
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

    public AircraftItemType getType() {
        return type;
    }

    /**
     * Проверяет готовность объекта
     * @return
     */
    abstract public boolean isReadyToStart();

    /**
     * Устанавливает глубину объекта в дереве
     * @param lvl
     */
    protected void setlvl(int lvl){
        this.lvl=lvl;
    }

    /**
     * Выводит в поток дерево объектов (выводиться тип объектов)
     * @param out поток для вывода
     */
    public void printTypeTree(PrintStream out){
        printTypeTree(out, 0);
    }

    /**
     * Выводит в поток дерево объектов (выводиться описание объектов)
     * @param out поток для вывода
     */
    public void printDescriptionTree(PrintStream out){
        printDescriptionTree(out, 0);
    }

    protected void printTypeTree(PrintStream out, int indent){
        for(int i=0; i<indent; i++){
            out.print(" ");
        }
        out.println(prefix+type);
        if(this instanceof AircraftComposite) {
            if (((AircraftComposite)this).childs.size() != 0) {
                for (AircraftComponent o : ((AircraftComposite)this).childs) {
                    o.printTypeTree(out, indent + type.toString().length());
                }
            }
        }
    }

    protected void printDescriptionTree(PrintStream out, int indent){
        for(int i=0; i<indent; i++){
            out.print(" ");
        }
        out.println(prefix+description);
        if(this instanceof AircraftComposite) {
            if (((AircraftComposite) this).childs.size() != 0) {
                for (AircraftComponent o : ((AircraftComposite) this).childs) {
                    o.printDescriptionTree(out, indent + description.toString().length());
                }
            }
        }
    }

}
