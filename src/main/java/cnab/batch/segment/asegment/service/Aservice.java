package cnab.batch.segment.asegment.service;

import cnab.batch.segment.asegment.service.transaction.Transaction;
import cnab.batch.segment.commonsfields.RegistrationNumber;
import cnab.batch.segment.commonsfields.Segment;
import cnab.batch.segment.commonsfields.service.Service;
import cnab.utils.Util;

public final class Aservice extends Service {
    private final Transaction transaction;

    public Aservice(RegistrationNumber registrationNumber, Transaction transaction) {
        super(registrationNumber, new Segment("A"));
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(getRegistrationNumber())+
                Util.getValueIfExist(getSegment())+
                Util.getValueIfExist(transaction);
    }
}
