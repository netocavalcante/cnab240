package cnab.batch.segment.asegment.service;

import cnab.batch.segment.asegment.service.transaction.Transaction;
import cnab.batch.segment.commonsfields.RegistrationNumber;
import cnab.batch.segment.commonsfields.Segment;
import cnab.batch.segment.commonsfields.service.Service;
import cnab.utils.Util;

public final class PrimaryService extends Service {
    private final Transaction transaction;

    public PrimaryService(RegistrationNumber registrationNumber, Transaction transaction, Segment segment) {
        super(registrationNumber, segment);
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(getRegistrationNumber())+
                Util.getValueIfExist(getSegment())+
                Util.getValueIfExist(transaction);
    }
}
