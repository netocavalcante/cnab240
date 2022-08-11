package cnab.batch.segment.commonsfields.payee;

import cnab.commonsfileds.Name;
import cnab.commonsfileds.account.Account;
import cnab.utils.Util;

public final class Payee {
    private final CentralizedChamberCode centralizedChamberCode;
    private final PayeeBankCode payerBankCode;
    private final Account account;
    private final Name name;

    public Payee(PayeeBuilder payeeBuilder) {
        this.centralizedChamberCode = payeeBuilder.centralClearingHouseCode;
        this.payerBankCode = payeeBuilder.payerBankCode;
        this.account = payeeBuilder.account;
        this.name = payeeBuilder.name;
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(centralizedChamberCode) +
                Util.getValueIfExist(payerBankCode) +
                Util.getValueIfExist(account) +
                Util.getValueIfExist(name);
    }

    public static final class PayeeBuilder {
        private CentralizedChamberCode centralClearingHouseCode;
        private PayeeBankCode payerBankCode;
        private Account account;
        private Name name;

        public PayeeBuilder(CentralizedChamberCode centralClearingHouseCode, PayeeBankCode payerBankCode,
                            Account account, Name name) {
            this.centralClearingHouseCode = centralClearingHouseCode;
            this.payerBankCode = payerBankCode;
            this.account = account;
            this.name = name;
        }

        public PayeeBuilder() {
        }

        public PayeeBuilder setCentralClearingHouseCode(CentralizedChamberCode centralClearingHouseCode) {
            this.centralClearingHouseCode = centralClearingHouseCode;
            return this;
        }

        public PayeeBuilder setPayerBankCode(PayeeBankCode payerBankCode) {
            this.payerBankCode = payerBankCode;
            return this;
        }

        public PayeeBuilder setAccount(Account account) {
            this.account = account;
            return this;
        }

        public PayeeBuilder setName(Name name) {
            this.name = name;
            return this;
        }

        public Payee build() {
            return new Payee(this);
        }
    }

}
