package ru.uskov.dmitry.more.model.persons;


import ru.uskov.dmitry.more.model.common.AircraftComposite;
import ru.uskov.dmitry.more.model.common.AircraftItemType;

abstract public class AircraftPerson extends AircraftComposite {

    public AircraftPerson(AircraftItemType type, String description) {
        super(type, description);
    }
}
