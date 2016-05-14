package ru.uskov.dmitry.exercise.model.persons;

import ru.uskov.dmitry.exercise.model.common.AircraftItemType;

abstract public class AircraftWorker extends AircraftPerson {
    public AircraftWorker(AircraftItemType type, String description) {
        super(type, description);
    }
}
