package cnab.commonsfileds.control;

import cnab.utils.Util;

public final class Control {
    private final BankCode bankCode;
    private final ControlNumber controlNumber;
    private final RecordType registerType;

    public Control(ControlBuilder controlBuilder) {
        this.bankCode = controlBuilder.bankCode;
        this.controlNumber = controlBuilder.controlNumber;
        this.registerType = controlBuilder.registerType;
    }

    public static Control createDefaultFileHeader(BankCode bankCode) {
        return new ControlBuilder(bankCode, new ControlNumber(0L), new RecordType(0L)).build();
    }

    public static Control createTedSinglePayment(BankCode bankCode, RecordType recordType){
        return new ControlBuilder(bankCode, new ControlNumber(1L), recordType).build();
    }

    public static Control createDefaultBatchTrailer(BankCode bankCode, ControlNumber controlNumber) {
        return new ControlBuilder(bankCode,controlNumber, new RecordType(5L)).build();
    }

    public static Control createDefaultFileTrailer(BankCode bankCode) {
        return new ControlBuilder(bankCode, new ControlNumber(9999L), new RecordType(9L)).build();
    }

    public BankCode getBankCode() {
        return bankCode;
    }

    public ControlNumber getControlNumber() {
        return controlNumber;
    }

    public RecordType getRegisterType() {
        return registerType;
    }

    @Override
    public String toString() {
        return Util.getValueIfExist(bankCode) +
                Util.getValueIfExist(controlNumber) +
                Util.getValueIfExist(registerType);
    }

    public static final class ControlBuilder {
        private BankCode bankCode;
        private ControlNumber controlNumber;
        private RecordType registerType;

        public ControlBuilder(BankCode bankCode, ControlNumber controlNumber, RecordType registerType) {
            this.bankCode = bankCode;
            this.controlNumber = controlNumber;
            this.registerType = registerType;
        }

        public ControlBuilder setBankCode(BankCode bankCode) {
            this.bankCode = bankCode;
            return this;
        }

        public ControlBuilder setControlNumber(ControlNumber controlNumber) {
            this.controlNumber = controlNumber;
            return this;
        }

        public ControlBuilder setRegisterType(RecordType registerType) {
            this.registerType = registerType;
            return this;
        }

        public Control build() {
            return new Control(this);
        }

    }
}
