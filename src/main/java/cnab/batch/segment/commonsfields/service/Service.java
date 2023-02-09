package cnab.batch.segment.commonsfields.service;

import cnab.batch.segment.commonsfields.RegistrationNumber;
import cnab.batch.segment.commonsfields.Segment;
import cnab.utils.Util;

public class Service {
    private final Segment segment;
    private final RegistrationNumber registrationNumber;

    public Service(RegistrationNumber registrationNumber, Segment segment) {
        this.segment = segment;
        this.registrationNumber = registrationNumber;
    }

    public RegistrationNumber getRegistrationNumber() {
        return registrationNumber;
    }

    public Segment getSegment() {
        return segment;
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(registrationNumber) +
                Util.getValueIfExist(segment);
    }
}
