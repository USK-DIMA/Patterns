package ru.uskov.dmitry.exercise.model.department;

import ru.uskov.dmitry.exercise.model.common.AircraftComponent;
import ru.uskov.dmitry.exercise.model.common.AircraftComposite;
import ru.uskov.dmitry.exercise.model.common.AircraftItemType;
import ru.uskov.dmitry.exercise.model.common.AircraftItemsCountValidation;
import ru.uskov.dmitry.exercise.model.persons.AircraftPassenger;

abstract public class AircraftDepartment extends AircraftComposite {

    private int freeBaggage;

    private int maxPassanger;

    public AircraftDepartment(AircraftItemType type, String description, int freeBaggage, int maxPassanger) {
        super(type, description);
        this.freeBaggage = freeBaggage;
        this.maxPassanger = maxPassanger;
        initChildValidation();
    }

    @Override
    protected boolean isValidChildSpecial(AircraftComponent o) {
        if(o instanceof AircraftPassenger){
            ((AircraftPassenger)o).setBaggageByAccec(freeBaggage);
        }
        return isValidChildSpecialDepartament(o);
    }

    @Override
    protected void initChildValidation() {
        validCountOfTypeMap.put(AircraftItemType.passenger, new AircraftItemsCountValidation(0, maxPassanger));
    }

    protected abstract boolean isValidChildSpecialDepartament(AircraftComponent o);
}
