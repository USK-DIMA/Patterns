package ru.uskov.dmitry.model.common;

import java.io.PrintStream;
import java.util.*;


/**
 * Основной класс для создания структуры самолёта
 */
abstract public class AircraftComposite {

    public static final String prefix = "-";

    protected AircraftItemType type;

    protected String description;

    protected int lvl;

    /**
     * Содержит информацию о том, сколько необходимо предков и какого типа
     */
    protected Map<AircraftItemType, AircraftItemsCountValidation> validCountOfTypeMap = new HashMap<>();

    protected Collection<AircraftComposite> childs = new ArrayList<>();

    public AircraftComposite(AircraftItemType type, String description) {
        this.lvl = 0;
        this.type= type;
        this.description = description;
        initChildValidation();
    }

    /**
     * В данном методе должны задаваться разрешения на типы дочерних элементов
     */
    protected abstract void initChildValidation();

    /**
     * Проверяет готов ли к сам объект и дочерние элементы объектра
     * @return
     */
    public boolean isReadyToStart(){
        if(!isReady()){
            return false;
        }
        for(AircraftComposite o: childs){
            if(!o.isReadyToStart()){ return false;}
        }
        return true;
    }

    public ArrayList<AircraftComposite> getChildByType(AircraftItemType type){
        ArrayList<AircraftComposite> childForType = new ArrayList<>();
        for(AircraftComposite o : childs){
            if(o.getType().equals(type)){
                childForType.add(o);
            }
        }
        return childForType;
    }



    public ArrayList<AircraftComposite> getAllChildByType(AircraftItemType type){
        ArrayList list = getChildByType(type);
        for(AircraftComposite o: childs){
            ArrayList childList = o.getAllChildByType(type);
            list.addAll(childList);
        }
        return list;
    }

    /**
     * Проверяет готовность только элемента к полёту (без проверки дочерних).
     * Может включать в себя либо просто налицие дочерних элементов либо наличие дочерхних элементов и какие-то ещё дополнительные проверки.
     * @return
     */
    final public boolean isReady(){
        Map<AircraftItemType, Integer> map = new HashMap<>();
        for(AircraftComposite o: childs){
            Increment(map, o.getType());
        }
        if(!testValid(map)){ return false;}

        return isReadySpecial();
    }

    /**
     * В методе можно определить какие-то допольнительый проверки объекта
     * @return
     */
    abstract protected boolean isReadySpecial();

    public Iterator getChild(){
        return childs.iterator();
    }

    public int getChildCount(){
        return childs.size();
    }

    public boolean addChild(AircraftComposite o){
        if(isValidChild(o)) {
            o.setlvl(lvl + 1);
            childs.add(o);
            return true;
        }
        return false;
    }


    public int addChilds(Collection<AircraftComposite> collection){
        int count = 0;
        for(AircraftComposite o: collection){
            if(addChild(o)){ count++;}
        }
        return count;
    }

    /**
     * Проверяем, добавлять ли ещё одного предка или нет
     * @param o
     * @return
     */
    final protected boolean isValidChild(AircraftComposite o) {
        AircraftItemType type = o.getType();
        int count = getChildByType(type).size();
        if(count<validCountOfTypeMap.get(type).getMaxCount()){
            return isValidChildSpecial(o);
        }
        return false;
    }

    protected abstract boolean isValidChildSpecial(AircraftComposite o);

    protected void setlvl(int lvl){
        this.lvl=lvl;
    }

    public void printTypeTree(PrintStream out){
        printTypeTree(out, 0);
    }

    public void printDescriptionTree(PrintStream out){
        printDescriptionTree(out, 0);
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

    public void deletChildsByTag(){
        //TODO
    }

    public void deletAllChildsByTag(){
        //TODO
    }

    public Collection<AircraftComposite> getAllObjects(){
        //TODO
        return null;
    }

    protected void printTypeTree(PrintStream out, int indent){
        for(int i=0; i<indent; i++){
            out.print(" ");
        }
        out.println(prefix+type);
        if(childs.size()!=0){
            for(AircraftComposite o :childs ){
                o.printTypeTree(out, indent+type.toString().length());
            }
        }
    }

    protected void printDescriptionTree(PrintStream out, int indent){
        for(int i=0; i<indent; i++){
            out.print(" ");
        }
        out.println(prefix+description);
        if(childs.size()!=0){
            for(AircraftComposite o :childs ){
                o.printDescriptionTree(out, indent+description.toString().length());
            }
        }
    }

    /**
     * Проверка кол-ва дочерних элементов.
     * @param map Кол-во дочерних элементов определённого типа
     * @return true, если кол-во валидно
     */
    private boolean testValid(Map<AircraftItemType, Integer> map) {
        Set<AircraftItemType> allType = validCountOfTypeMap.keySet();
        for(AircraftItemType type : allType){
            AircraftItemsCountValidation validation = validCountOfTypeMap.get(type);
            Integer count = map.get(type);
            if(!validation.valid(count)) { return false;}
        }
        return true;
    }


    private void Increment(Map<AircraftItemType, Integer> map, AircraftItemType type) {
        Integer count = map.get(type);
        if(count==null){
            map.put(type, new Integer(1));
        }
        else {
            map.put(type, count+1);
        }
    }

}
