package ru.uskov.dmitry.model.department;

import ru.uskov.dmitry.model.common.AircraftComposite;
import ru.uskov.dmitry.model.common.AircraftItemType;
import ru.uskov.dmitry.model.common.AircraftItemsCountValidation;
import ru.uskov.dmitry.model.persons.AircraftPassenger;

abstract public class AircraftDepartment extends AircraftComposite{

    private int freeBaggage;

    private int maxPassanger;

    public AircraftDepartment(AircraftItemType type, String description, int freeBaggage, int maxPassanger) {
        super(type, description);
        this.freeBaggage = freeBaggage;
        this.maxPassanger = maxPassanger;
        initChildValidation();
    }


    @Override
    protected boolean isValidChildSpecial(AircraftComposite o) {
        if(o instanceof AircraftPassenger){
            ((AircraftPassenger)o).setBaggageByAccec(freeBaggage);
        }
        return isValidChildSpecialDepartament(o);
    }

    @Override
    protected void initChildValidation() {
        validCountOfTypeMap.put(AircraftItemType.passenger, new AircraftItemsCountValidation(0, maxPassanger));
        initChildValidationDepartament();
    }

    protected abstract void initChildValidationDepartament();


    protected abstract boolean isValidChildSpecialDepartament(AircraftComposite o);
}
