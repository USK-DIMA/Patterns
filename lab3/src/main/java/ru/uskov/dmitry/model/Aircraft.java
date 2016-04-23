package ru.uskov.dmitry.model;

import ru.uskov.dmitry.model.common.AircraftComposite;
import ru.uskov.dmitry.model.common.AircraftItemType;
import ru.uskov.dmitry.model.common.AircraftItemsCountValidation;
import ru.uskov.dmitry.model.persons.AircraftPassenger;


import java.io.PrintStream;
import java.util.*;


public class Aircraft extends AircraftComposite {

    public static final AircraftItemType type = AircraftItemType.aircraft;

    public static final String description = "Самолёт";

    public static final int PILOT_COUNT=2;

    public static final int STEWARDESS_COUNT=6;

    public static final int MAX_BAGGAGE=1000;


    public Aircraft() {
        super(type, description);
    }

    @Override
    protected void initChildValidation() {
        //Компоненты каких типов могут быть дочерними у Aircraft
        validCountOfTypeMap.put(AircraftItemType.economClassDepartment, new AircraftItemsCountValidation(1, 1));
        validCountOfTypeMap.put(AircraftItemType.businesClassDepartment, new AircraftItemsCountValidation(1, 1));
        validCountOfTypeMap.put(AircraftItemType.firstClassDepartment, new AircraftItemsCountValidation(1, 1));

        validCountOfTypeMap.put(AircraftItemType.pilot, new AircraftItemsCountValidation(PILOT_COUNT, PILOT_COUNT));
        validCountOfTypeMap.put(AircraftItemType.stewardess, new AircraftItemsCountValidation(STEWARDESS_COUNT, STEWARDESS_COUNT));
    }


    @Override
    protected boolean isReadySpecial() {
        int baggage=getBaggage();
        if(baggage<=MAX_BAGGAGE){
            return true;
        }
        return false;
    }

    public int getBaggage(){
        ArrayList<AircraftComposite> passangers = getAllChildByType(AircraftItemType.passenger);
        int baggage=0;
        for(Object p : passangers){
            AircraftPassenger pas = (AircraftPassenger)p;
            baggage+=((AircraftPassenger)p).getBaggage();
        }
        return baggage;
    }



    @Override
    protected boolean isValidChildSpecial(AircraftComposite o) {
        return true;
    }


    public void printBaggage(PrintStream out) {
        out.println(getBaggage()+"/"+MAX_BAGGAGE);
    }
}
