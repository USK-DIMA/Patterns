package ru.uskov.dmitry.exercise.model.persons;

import ru.uskov.dmitry.exercise.model.common.AircraftItemType;

public class AircraftPilot extends AircraftWorker {

    public static final AircraftItemType type = AircraftItemType.pilot;

    public static final String description = "Пилот";

    public AircraftPilot() {
        super(type, description);
    }

    @Override
    public boolean isReadyToStart() {
        return true;
    }
}
