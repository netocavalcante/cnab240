package cnab.file.header.fields.file;

import cnab.commonsfileds.base.GenericBasicField;

import java.time.LocalDate;

import static cnab.utils.DateTimeUtil.dateFormat;

public final class GenerationDate extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 8;

    public GenerationDate(LocalDate field, int size) {
        super(dateFormat(field), size);
    }

    public GenerationDate(LocalDate field) {
        super(dateFormat(field), FIELD_SIZE_V10_9);
    }
}