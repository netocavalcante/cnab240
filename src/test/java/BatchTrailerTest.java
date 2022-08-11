import cnab.batch.trailer.BatchTrailer;
import cnab.commonsfileds.control.BankCode;
import cnab.commonsfileds.control.ControlNumber;
import cnab.exceptions.ContentMoreThan240CharactersException;
import cnab.service.Service;
import cnab.service.TED;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static testFactories.ASegmentTestFactory.createDefaultASegment;
import static testFactories.BSegmentTestFactory.createDefaultBSegment;

class BatchTrailerTest {

    @Test
    void shouldDo() throws ContentMoreThan240CharactersException {
        TED ted = new TED.TEDBuilder(createDefaultASegment(new BankCode(123L)))
                .setbSegment(createDefaultBSegment())
                .build();

        TED ted2 = new TED.TEDBuilder(createDefaultASegment(new BankCode(123L)))
                .setbSegment(createDefaultBSegment())
                .build();

        Set<Service> services = new HashSet<>();
        services.add(ted);
        services.add(ted2);

        BatchTrailer batchTrailer = new BatchTrailer(services, new BankCode(123L), new ControlNumber(1L));

    }
}
