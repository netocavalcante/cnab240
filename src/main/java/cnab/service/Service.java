package cnab.service;

import cnab.commonsfileds.control.BankCode;

public interface Service {
    BankCode getBankCode();
    long getAmountOfSegments();
}
