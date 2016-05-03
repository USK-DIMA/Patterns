package ru.uskov.dmitry.exercise.model.board;

import com.sun.istack.internal.NotNull;
import ru.uskov.dmitry.exercise.model.common.Passenger;
import ru.uskov.dmitry.exercise.model.driver.Driver;

import java.util.ArrayList;


abstract public class Board {

    private Class driverClass = Driver.class;

    private int maxPassangerCount;

    private ArrayList<Passenger> passengers;

    public Board(@NotNull Class driverClass, @NotNull int passengerCount){
        this.driverClass = driverClass;
        this.maxPassangerCount = passengerCount;
        passengers = new ArrayList<>(passengerCount);
    }

    public Class getDriverClass() {
        return driverClass;
    }

    public int getMaxPassangerCount() {
        return maxPassangerCount;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
