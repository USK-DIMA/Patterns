package ru.uskov.dmitry.exercise.model.common;


abstract public class AircraftPrimitive extends AircraftComponent {

    public AircraftPrimitive(AircraftItemType type, String description) {
        super(type, description);
    }

    @Override
    abstract public boolean isReadyToStart();
}
