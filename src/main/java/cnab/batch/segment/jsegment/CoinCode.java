package cnab.batch.segment.jsegment;

import cnab.commonsfileds.base.GenericBasicField;

public class CoinCode extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 2;

    public CoinCode(String field, int size) {
        super(field, size);
    }

    public CoinCode(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
