package cnab.file.header.fields.file;


import cnab.commonsfileds.base.GenericBasicField;

public final class Layout extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 3;

    public Layout(String field, int size) {
        super(field, size);
    }

    public Layout(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}