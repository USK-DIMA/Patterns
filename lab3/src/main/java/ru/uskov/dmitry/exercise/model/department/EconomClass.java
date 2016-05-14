package ru.uskov.dmitry.exercise.model.department;

import ru.uskov.dmitry.exercise.model.common.AircraftComponent;
import ru.uskov.dmitry.exercise.model.common.AircraftItemType;

public class EconomClass extends AircraftDepartment {

    public static final AircraftItemType type = AircraftItemType.economClassDepartment;

    public static final String description = "Эконом класс";

    public static final int FREE_BAGGAGE = 20;

    private static final int MAX_PASSANGER = 150;

    public EconomClass() {
        super(type, description, FREE_BAGGAGE, MAX_PASSANGER);
    }

    @Override
    protected boolean isValidChildSpecialDepartament(AircraftComponent o) {
        return true;
    }

    @Override
    protected boolean isReady() {
        return true;
    }
}
