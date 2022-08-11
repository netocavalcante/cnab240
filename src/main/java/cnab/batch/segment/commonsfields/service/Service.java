package cnab.batch.segment.commonsfields.service;

import cnab.batch.segment.commonsfields.RegistrationNumber;
import cnab.batch.segment.commonsfields.Segment;
import cnab.utils.Util;

public class Service {
    private final RegistrationNumber registrationNumber;
    private final Segment segment;

    public Service(RegistrationNumber registrationNumber, Segment segment) {
        this.registrationNumber = registrationNumber;
        this.segment = segment;
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
