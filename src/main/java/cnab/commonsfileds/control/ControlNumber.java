package cnab.commonsfileds.control;

import cnab.commonsfileds.base.GenericBasicField;

public class ControlNumber extends GenericBasicField<Long> {

    private static final int FIELD_SIZE_V10_9 = 4;

    public ControlNumber(Long field, int size) {
        super(field, size);
    }

    public ControlNumber(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}



