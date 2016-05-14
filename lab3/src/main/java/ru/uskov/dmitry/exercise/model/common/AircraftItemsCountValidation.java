package ru.uskov.dmitry.exercise.model.common;


/**
 * Класс содержит информацию о количестве дочерних объектов определённого типа
 */
public class AircraftItemsCountValidation {
    private int maxCount;
    private int minCount;

    public AircraftItemsCountValidation(int minCount, int maxCount) {
        this.maxCount = maxCount;
        this.minCount = minCount;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getMinCount() {
        return minCount;
    }

    public void setMinCount(int minCount) {
        this.minCount = minCount;
    }

    public boolean valid(Integer count) {
        if(count==null){ count = new Integer(0);}
        if(count>=minCount && count<=maxCount){
            return true;
        }

        return false;
    }
}
