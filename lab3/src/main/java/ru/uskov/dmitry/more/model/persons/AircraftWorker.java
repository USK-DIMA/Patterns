package ru.uskov.dmitry.more.model.persons;

import ru.uskov.dmitry.more.model.common.AircraftItemType;

/**
 * Created by Dmitry on 23.04.2016.
 */
abstract public class AircraftWorker extends AircraftPerson {
    public AircraftWorker(AircraftItemType type, String description) {
        super(type, description);
    }
}
