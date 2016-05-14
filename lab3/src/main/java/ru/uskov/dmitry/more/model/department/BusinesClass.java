package ru.uskov.dmitry.more.model.department;

import ru.uskov.dmitry.more.model.common.AircraftComposite;
import ru.uskov.dmitry.more.model.common.AircraftItemType;

public class BusinesClass extends AircraftDepartment {

    public static final AircraftItemType type = AircraftItemType.businesClassDepartment;

    public static final int FREE_BAGGAGE = 35;

    public static final String description = "Бизнес класс";

    private static final int MAX_PASSANGER = 20;

    public BusinesClass() {
        super(type, description, FREE_BAGGAGE, MAX_PASSANGER);
    }

    @Override
    protected boolean isReadySpecial() {
        return true;
    }


    @Override
    protected void initChildValidationDepartament() { }

    @Override
    protected boolean isValidChildSpecialDepartament(AircraftComposite o) {
        return true;
    }
}
