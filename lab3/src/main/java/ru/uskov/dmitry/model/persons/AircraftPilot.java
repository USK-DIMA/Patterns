package ru.uskov.dmitry.model.persons;

import ru.uskov.dmitry.model.common.AircraftComposite;
import ru.uskov.dmitry.model.common.AircraftItemType;

public class AircraftPilot extends AircraftWorker {

    public static final AircraftItemType type = AircraftItemType.pilot;

    public static final String description = "Пилот";

    public AircraftPilot() {
        super(type, description);
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
}
