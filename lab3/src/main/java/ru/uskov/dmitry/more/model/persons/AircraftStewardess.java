package ru.uskov.dmitry.more.model.persons;

import ru.uskov.dmitry.more.model.common.AircraftComposite;
import ru.uskov.dmitry.more.model.common.AircraftItemType;

/**
 * Created by Dmitry on 23.04.2016.
 */
public class AircraftStewardess extends AircraftWorker {

    public static final AircraftItemType type = AircraftItemType.stewardess;

    public static final String description = "Стюардесса";

    public AircraftStewardess() {
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
