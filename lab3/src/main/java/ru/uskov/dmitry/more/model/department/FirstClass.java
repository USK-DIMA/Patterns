package ru.uskov.dmitry.more.model.department;

import ru.uskov.dmitry.more.model.common.AircraftComposite;
import ru.uskov.dmitry.more.model.common.AircraftItemType;

public class FirstClass extends AircraftDepartment {

    public static final AircraftItemType type = AircraftItemType.firstClassDepartment;

    public static final String description = "Первый класс";

    public static final int FREE_BAGGAGE = Integer.MAX_VALUE;

    private static final int MAX_PASSANGER = 10;

    public FirstClass() {
        super(type, description, FREE_BAGGAGE, MAX_PASSANGER);
    }


    @Override
    protected void initChildValidationDepartament() { }

    @Override
    protected boolean isReadySpecial() {
        return true;
    }

    @Override
    protected boolean isValidChildSpecialDepartament(AircraftComposite o) {
        return true;
    }
}
