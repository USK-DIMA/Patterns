package ru.uskov.dmitry.exercise;

import ru.uskov.dmitry.exercise.model.Aircraft;
import ru.uskov.dmitry.exercise.model.department.BusinesClass;
import ru.uskov.dmitry.exercise.model.department.EconomClass;
import ru.uskov.dmitry.exercise.model.department.FirstClass;
import ru.uskov.dmitry.exercise.model.persons.AircraftPassenger;
import ru.uskov.dmitry.exercise.model.persons.AircraftPilot;
import ru.uskov.dmitry.exercise.model.persons.AircraftStewardess;

public class Main {

    public static void main(String[] args) {

        System.out.println("Создаём самолёт");
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

        System.out.println("Заполнили самолёт пассажирами");
        System.out.println("Aircraft isReadyToStart: "+aircraft.isReadyToStart());
        System.out.println("Добавляем пилотов и стюардесс");
        for(int i=0; i< aircraft.PILOT_COUNT; i++){
            aircraft.addChild(new AircraftPilot());
        }
        for(int i=0; i< aircraft.STEWARDESS_COUNT; i++){
            aircraft.addChild(new AircraftStewardess());
        }
        System.out.println("Aircraft isReadyToStart: "+aircraft.isReadyToStart());
        System.out.println("\nСтруктура самолёта:");
        aircraft.printDescriptionTree(System.out);
        System.out.print("Заполнение багажа: ");
        aircraft.printBaggage(System.out);
    }
}
