package ru.uskov.dmitry.model.persons;


import ru.uskov.dmitry.model.common.AircraftComposite;
import ru.uskov.dmitry.model.common.AircraftItemType;

abstract public class AircraftPerson extends AircraftComposite {

    public AircraftPerson(AircraftItemType type, String description) {
        super(type, description);
    }
}
