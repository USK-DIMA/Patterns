package ru.uskov.dmitry.more.model.persons;

import ru.uskov.dmitry.more.model.common.AircraftComposite;
import ru.uskov.dmitry.more.model.common.AircraftItemType;

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

    @Override
    protected void initChildValidation() {

    }

    @Override
    protected boolean isReadySpecial() {
        return true;
    }

    @Override
    protected boolean isValidChildSpecial(AircraftComposite o) {
        return false;
    }

    public void setBaggageByAccec(int freeBaggage) {
        if(baggage>freeBaggage){
            cleaningBaggage = baggage-freeBaggage;
            baggage = freeBaggage;
            setDescription(getDescription()+"/("+cleaningBaggage+")");
        }
    }
}
