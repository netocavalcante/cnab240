package cnab.batch.segment;

import cnab.batch.segment.commonsfields.RegistrationNumber;
import cnab.batch.segment.commonsfields.service.Service;

import java.util.Objects;

public interface Segment {

    default long getRegistrationNumber(Service service) {
        RegistrationNumber registrationNumber = service.getRegistrationNumber();
        return Objects.nonNull(registrationNumber) ? registrationNumber.getField() : 0;
    }


}
