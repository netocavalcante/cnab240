package cnab.commonsfileds.account;

import cnab.utils.Util;

public class Account {
    private final BranchCode branchCode;
    private final AccountNumber accountNumber;
    private final BranchControlDigit branchControlDigit;
    private final AccountControlDigit accountControlDigit;
    private final BranchAccountControlDigit branchAccountControlDigit;

    public Account(AccountBuilder accountBuilder) {
        this.branchCode = accountBuilder.branchCode;
        this.accountNumber = accountBuilder.accountNumber;
        this.branchControlDigit = accountBuilder.branchControlDigit;
        this.accountControlDigit = accountBuilder.accountControlDigit;
        this.branchAccountControlDigit = accountBuilder.branchAccountControlDigit;
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(branchCode) +
                Util.getValueIfExist(branchControlDigit) +
                Util.getValueIfExist(accountNumber) +
                Util.getValueIfExist(accountControlDigit) +
                Util.getValueIfExist(branchAccountControlDigit) ;
    }

    public static final class AccountBuilder {
        private BranchCode branchCode;
        private AccountNumber accountNumber;
        private BranchControlDigit branchControlDigit;
        private AccountControlDigit accountControlDigit;
        private BranchAccountControlDigit branchAccountControlDigit;

        public AccountBuilder() {
        }

        public AccountBuilder(AccountNumber accountNumber, AccountControlDigit accountControlDigit, BranchCode branchCode, BranchControlDigit branchControlDigit, BranchAccountControlDigit branchAccountControlDigit) {
            this.branchCode = branchCode;
            this.accountNumber = accountNumber;
            this.branchControlDigit = branchControlDigit;
            this.accountControlDigit = accountControlDigit;
            this.branchAccountControlDigit = branchAccountControlDigit;
        }

        public AccountBuilder setAccountNumber(AccountNumber accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public AccountBuilder setAccountControlDigit(AccountControlDigit accountControlDigit) {
            this.accountControlDigit = accountControlDigit;
            return this;
        }

        public AccountBuilder setBranchCode(BranchCode branchCode) {
            this.branchCode = branchCode;
            return this;
        }

        public AccountBuilder setBranchControlDigit(BranchControlDigit branchControlDigit) {
            this.branchControlDigit = branchControlDigit;
            return this;
        }

        public AccountBuilder setBranchAccountControlDigit(BranchAccountControlDigit branchAccountControlDigit) {
            this.branchAccountControlDigit = branchAccountControlDigit;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
