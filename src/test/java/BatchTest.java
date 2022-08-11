import cnab.batch.Batch;
import cnab.batch.header.BatchHeader;
import cnab.batch.segment.asegment.ASegment;
import cnab.commonsfileds.control.BankCode;
import cnab.exceptions.ContentMoreThan240CharactersException;
import cnab.exceptions.ServiceNotAllowedException;
import cnab.service.Service;
import cnab.service.TED;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testFactories.ASegmentTestFactory;
import testFactories.BatchHeaderTestFactory;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BatchTest {

    @Test
    void mustThrowExceptionWhenServiceHanstBankCode() throws ContentMoreThan240CharactersException {
        Set<Service> services = new HashSet<>();

        ASegment aSegment = ASegmentTestFactory.createDefaultASegment(new BankCode(123L));
        ASegment aSegmentWithoutBankCode = ASegmentTestFactory.createDefaultASegment(null);

        TED ted = new TED.TEDBuilder(aSegment).build();
        TED ted2 = new TED.TEDBuilder(aSegmentWithoutBankCode).build();

        services.add(ted);
        services.add(ted2);

        BatchHeader batchHeader = BatchHeaderTestFactory.createDefaultBatchHeader();

        ServiceNotAllowedException serviceNotAllowedException = Assertions.assertThrows(ServiceNotAllowedException.class, () -> new Batch.BatchBuilder(batchHeader, services).build());
        assertEquals( "All Services must have a bank code", serviceNotAllowedException.getMessage());
    }
}
