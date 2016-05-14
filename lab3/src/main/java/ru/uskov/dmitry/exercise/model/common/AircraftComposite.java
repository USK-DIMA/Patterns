package ru.uskov.dmitry.exercise.model.common;

import java.util.*;

abstract public class AircraftComposite extends AircraftComponent {

    public AircraftComposite(AircraftItemType type, String description) {
        super(type, description);
        initChildValidation();
    }

    /**
     * Содержит информацию о том, сколько необходимо предков и какого типа
     */
    protected Map<AircraftItemType, AircraftItemsCountValidation> validCountOfTypeMap = new HashMap<>();

    protected Collection<AircraftComponent> childs = new ArrayList<>();


    /**
     * Сложный объект готов тогда, когда готовы все дочерние объекты и он сам
     * @return
     */
    public boolean isReadyToStart(){
        if(!testValid() || !isReady()){
            return false;
        }
        for(AircraftComponent o: childs){
            if(!o.isReadyToStart()){ return false;}
        }
        return true;
    }

    /**
     * Проверка готовности самого элемента
     * @return
     */
    abstract protected boolean isReady();

    public ArrayList<AircraftComponent> getChildByType(AircraftItemType type){
        ArrayList<AircraftComponent> childForType = new ArrayList<>();
        for(AircraftComponent o : childs){
            if(o.getType().equals(type)){
                childForType.add(o);
            }
        }
        return childForType;
    }

    public ArrayList<AircraftComponent> getAllChildByType(AircraftItemType type){
        ArrayList list = getChildByType(type);
        for(AircraftComponent o: childs){
            if(o instanceof AircraftComposite) {
                ArrayList childList = ((AircraftComposite)o).getAllChildByType(type);
                list.addAll(childList);
            }
        }
        return list;
    }


    public Iterator getChild(){
        return childs.iterator();
    }

    public int getChildCount(){
        return childs.size();
    }

    public boolean addChild(AircraftComponent o){
        if(isValidChild(o)) {
            o.setlvl(lvl + 1);
            childs.add(o);
            return true;
        }
        return false;
    }


    public int addChilds(Collection<AircraftComponent> collection){
        int count = 0;
        for(AircraftComponent o: collection){
            if(addChild(o)){ count++;}
        }
        return count;
    }

    /**
     * Проверяем, добавлять ли ещё одного предка или нет
     * @param o
     * @return
     */
    final protected boolean isValidChild(AircraftComponent o) {
        AircraftItemType type = o.getType();
        int count = getChildByType(type).size();
        if(count<validCountOfTypeMap.get(type).getMaxCount()){
            return isValidChildSpecial(o);
        }
        return false;
    }

    protected abstract boolean isValidChildSpecial(AircraftComponent o);


    /**
     * Проверка кол-ва дочерних элементов.
     * @param map Кол-во дочерних объектов определённого типа, уже входящих в состав сложного объекта
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

    /**
     * Проверка, содержит ли сложный объект достаточное кол-во дочерних объектов нужного типа
     * @return
     */
    private boolean testValid(){
        Map<AircraftItemType, Integer> map = new HashMap<>();
        for(AircraftComponent o: childs){
            Increment(map, o.getType());
        }
        return testValid(map);
    }

    /**
     * В данном методе должны задаваться разрешения на типы дочерних элементов
     */
    protected abstract void initChildValidation();

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
