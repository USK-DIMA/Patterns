package ru.uskov.dmitry;

import ru.uskov.dmitry.model.Aircraft;
import ru.uskov.dmitry.model.department.BusinesClass;
import ru.uskov.dmitry.model.department.EconomClass;
import ru.uskov.dmitry.model.department.FirstClass;
import ru.uskov.dmitry.model.persons.AircraftPassenger;
import ru.uskov.dmitry.model.persons.AircraftPilot;
import ru.uskov.dmitry.model.persons.AircraftStewardess;

public class Main {

    public static void main(String[] args) {

        Aircraft aircraft = new Aircraft();
        BusinesClass business = new BusinesClass();
        business.addChild(new AircraftPassenger(20));
        business.addChild(new AircraftPassenger(10));
        business.addChild(new AircraftPassenger(32));
        aircraft.addChild(business);

        FirstClass first = new FirstClass();

        first.addChild(new AircraftPassenger(20));
        first.addChild(new AircraftPassenger(10));
        first.addChild(new AircraftPassenger(32));
        aircraft.addChild(first);

        EconomClass econom = new EconomClass();
        econom.addChild(new AircraftPassenger(20));
        econom.addChild(new AircraftPassenger(10));
        econom.addChild(new AircraftPassenger(32));
        aircraft.addChild(econom);

        for(int i=0; i< aircraft.PILOT_COUNT; i++){
            aircraft.addChild(new AircraftPilot());
        }
        for(int i=0; i< aircraft.STEWARDESS_COUNT; i++){
            aircraft.addChild(new AircraftStewardess());
        }

        aircraft.printDescriptionTree(System.out);
        aircraft.printBaggage(System.out);
        System.out.println("isReady: "+aircraft.isReady());
        System.out.println("isReadyToStart: "+aircraft.isReadyToStart());
    }
}
