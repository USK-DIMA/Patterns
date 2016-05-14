package ru.uskov.dmitry.exercise.model.persons;

import ru.uskov.dmitry.exercise.model.common.AircraftItemType;

public class AircraftPassenger extends AircraftPerson {

    public static final AircraftItemType type = AircraftItemType.passenger;

    public static final String description = "Пассажир: фИО ";

    private int baggage;

    private int cleaningBaggage;

    public AircraftPassenger(int baggage) {
        super(type, description+" ("+baggage+")");
        this.baggage = baggage;
        this.cleaningBaggage = 0;
    }

    public int getBaggage() {
        return baggage;
    }

    public void setBaggageByAccec(int freeBaggage) {
        if(baggage>freeBaggage){
            cleaningBaggage = baggage-freeBaggage;
            baggage = freeBaggage;
            setDescription(getDescription()+"/("+cleaningBaggage+")");
        }
    }

    @Override
    public boolean isReadyToStart() {
        return true;
    }
}
