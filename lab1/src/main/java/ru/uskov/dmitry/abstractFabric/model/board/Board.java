package ru.uskov.dmitry.abstractFabric.model.board;

import com.sun.istack.internal.NotNull;
import ru.uskov.dmitry.abstractFabric.exception.IncorrectDriverException;
import ru.uskov.dmitry.abstractFabric.model.common.Passenger;
import ru.uskov.dmitry.abstractFabric.model.driver.Driver;

import java.util.ArrayList;


abstract public class Board {

    protected Driver driver;

    private Class clazz = Board.class;

    private int maxPassangerCount;

    private ArrayList<Passenger> passengers;

    public void setDriver(Driver driver) throws IncorrectDriverException {
        if(clazz.isAssignableFrom(driver.getClass())){
            this.driver = driver;
        }
        else{
            throw new IncorrectDriverException();
        }
    }

    public Board(@NotNull Class clazz, @NotNull int passengerCount){
        this.clazz = clazz;
        this.maxPassangerCount = passengerCount;
        passengers = new ArrayList<>(passengerCount);
    }

    public boolean isEmpty(){
        if(passengers.size()==0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean driverIsHere(){
        if(driver!=null){
            return true;
        }
        else{
            return false;
        }
    }

    public int addPassengers(Passenger[] newPassengers){
        int addedPassangerCount = 0;
        for(int i=0; i<newPassengers.length; i++){
            if(passengers.size() == maxPassangerCount){break;}
            passengers.add(newPassengers[i]);
            addedPassangerCount++;
        }
        return addedPassangerCount;
    }

    public int addPassengers(ArrayList<Passenger> passengers){
        return addPassengers((Passenger[]) passengers.toArray());
    }

    public boolean addOnePassenger(Passenger passenger){
        int count = addPassengers(new Passenger[]{passenger});
        if (count == 1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean readyToRun(){
        return  (!isEmpty()&&driverIsHere());
    }
}
