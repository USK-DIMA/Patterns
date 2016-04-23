package ru.uskov.dmitry.model.department;

import ru.uskov.dmitry.model.common.AircraftComposite;
import ru.uskov.dmitry.model.common.AircraftItemType;

public class EconomClass extends AircraftDepartment {

    public static final AircraftItemType type = AircraftItemType.economClassDepartment;

    public static final String description = "Эконом класс";

    public static final int FREE_BAGGAGE = 20;

    private static final int MAX_PASSANGER = 150;

    public EconomClass() {
        super(type, description, FREE_BAGGAGE, MAX_PASSANGER);
    }


    @Override
    protected boolean isReadySpecial() {
        return true;
    }

    @Override
    protected void initChildValidationDepartament() {

    }

    @Override
    protected boolean isValidChildSpecialDepartament(AircraftComposite o) {
        return true;
    }
}
