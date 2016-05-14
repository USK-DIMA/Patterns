package ru.uskov.dmitry.exercise.model.persons;

import ru.uskov.dmitry.exercise.model.common.AircraftItemType;

public class AircraftStewardess extends AircraftWorker {

    public static final AircraftItemType type = AircraftItemType.stewardess;

    public static final String description = "Стюардесса";

    public AircraftStewardess() {
        super(type, description);
    }

    @Override
    public boolean isReadyToStart() {
        return true;
    }
}
