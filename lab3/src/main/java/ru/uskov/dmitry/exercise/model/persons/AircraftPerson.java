package ru.uskov.dmitry.exercise.model.persons;

import ru.uskov.dmitry.exercise.model.common.AircraftItemType;
import ru.uskov.dmitry.exercise.model.common.AircraftPrimitive;

abstract public class AircraftPerson extends AircraftPrimitive {

    public AircraftPerson(AircraftItemType type, String description) {
        super(type, description);
    }
}
