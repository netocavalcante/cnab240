package cnab.batch.header.fields.service;

import cnab.commonsfileds.base.GenericBasicField;

public class ServiceType extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 2;

    public ServiceType(Long field, int size) {
        super(field, size);
    }

    public ServiceType(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
