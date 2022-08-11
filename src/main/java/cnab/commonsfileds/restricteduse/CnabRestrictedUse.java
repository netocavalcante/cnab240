package cnab.commonsfileds.restricteduse;


import cnab.commonsfileds.base.GenericBasicField;

public final class CnabRestrictedUse extends GenericBasicField<String> {
    public CnabRestrictedUse(int size) {
        super(" ", size);
    }

    public CnabRestrictedUse(String field, int size) {
        super(" ", size);
    }
}
