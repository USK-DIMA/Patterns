package ru.uskov.dmitry.exercise.model.department;

import ru.uskov.dmitry.exercise.model.common.AircraftComponent;
import ru.uskov.dmitry.exercise.model.common.AircraftItemType;

public class FirstClass extends AircraftDepartment {

    public static final AircraftItemType type = AircraftItemType.firstClassDepartment;

    public static final String description = "Первый класс";

    public static final int FREE_BAGGAGE = Integer.MAX_VALUE;

    private static final int MAX_PASSANGER = 10;

    public FirstClass() {
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
