package cnab.file.header.fields.file;


import cnab.commonsfileds.base.GenericBasicField;

public final class Sequence extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 6;

    public Sequence(Long field, int size) {
        super(field, size);
    }

    public Sequence(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
