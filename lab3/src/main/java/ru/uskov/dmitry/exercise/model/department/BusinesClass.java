package ru.uskov.dmitry.exercise.model.department;

import ru.uskov.dmitry.exercise.model.common.AircraftComponent;
import ru.uskov.dmitry.exercise.model.common.AircraftItemType;

public class BusinesClass extends AircraftDepartment {

    public static final AircraftItemType type = AircraftItemType.businesClassDepartment;

    public static final int FREE_BAGGAGE = 35;

    public static final String description = "Бизнес класс";

    private static final int MAX_PASSANGER = 20;

    public BusinesClass() {
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
