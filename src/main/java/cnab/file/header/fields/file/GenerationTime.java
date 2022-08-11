package cnab.file.header.fields.file;

import cnab.commonsfileds.base.GenericBasicField;

import java.time.LocalTime;

import static cnab.utils.DateTimeUtil.timeFormat;


public final class GenerationTime extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 6;

    public GenerationTime(LocalTime field, int size) {
        super(timeFormat(field), size);
    }

    public GenerationTime(LocalTime field) {
        super(timeFormat(field), FIELD_SIZE_V10_9);
    }
}