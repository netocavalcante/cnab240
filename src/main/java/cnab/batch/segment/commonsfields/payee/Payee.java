package cnab.batch.segment.commonsfields.payee;

import cnab.commonsfileds.Name;
import cnab.commonsfileds.account.Account;
import cnab.utils.Util;

public final class Payee {
    private final Name name;
    private final Account account;
    private final PayeeBankCode payerBankCode;
    private final CentralizedChamberCode centralizedChamberCode;

    public Payee(PayeeBuilder payeeBuilder) {
        this.name = payeeBuilder.name;
        this.account = payeeBuilder.account;
        this.payerBankCode = payeeBuilder.payerBankCode;
        this.centralizedChamberCode = payeeBuilder.centralClearingHouseCode;
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(centralizedChamberCode) +
                Util.getValueIfExist(payerBankCode) +
                Util.getValueIfExist(account) +
                Util.getValueIfExist(name);
    }

    public static final class PayeeBuilder {
        private Name name;
        private Account account;
        private PayeeBankCode payerBankCode;
        private CentralizedChamberCode centralClearingHouseCode;

        public PayeeBuilder(CentralizedChamberCode centralClearingHouseCode, PayeeBankCode payerBankCode,
                            Account account, Name name) {
            this.name = name;
            this.account = account;
            this.payerBankCode = payerBankCode;
            this.centralClearingHouseCode = centralClearingHouseCode;
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
