package cnab.commonsfileds.base;

import static cnab.utils.Util.formatFieldToBePrinted;

public abstract class GenericBasicField<T> {
    private final T field;
    private final int fieldSize;

    protected GenericBasicField(T field, int size) {
        this.field = field;
        this.fieldSize = size;
    }

    public T getField() {
        return field;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    @Override
    public String toString() {
        return formatFieldToBePrinted(field, fieldSize);
    }

}
