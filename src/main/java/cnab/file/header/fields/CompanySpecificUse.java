package cnab.file.header.fields;


import cnab.commonsfileds.base.GenericBasicField;

public final class CompanySpecificUse extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 20;

    public CompanySpecificUse(String field, int size) {
        super(field, size);
    }

    public CompanySpecificUse(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}