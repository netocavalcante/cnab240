import cnab.batch.Batch;
import cnab.commonsfileds.control.BankCode;
import cnab.exceptions.ContentMoreThan240CharactersException;
import cnab.exceptions.ServiceNotAllowedException;
import cnab.file.trailer.FileTrailer;
import cnab.service.Service;
import cnab.service.TED;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static testFactories.ASegmentTestFactory.createDefaultASegment;
import static testFactories.BSegmentTestFactory.createDefaultBSegment;
import static testFactories.BatchHeaderTestFactory.createDefaultBatchHeader;

class FileTrailerTest {
    @Test
    void shouldDo() throws ContentMoreThan240CharactersException, ServiceNotAllowedException {
        Set<Batch> batches = new HashSet<>();
        TED ted = new TED.TEDBuilder(createDefaultASegment(new BankCode(123L)))
                .setbSegment(createDefaultBSegment())
                .build();

        TED ted2 = new TED.TEDBuilder(createDefaultASegment(new BankCode(123L)))
                .setbSegment(createDefaultBSegment())
                .build();

        Set<Service> services = new HashSet<>();
        services.add(ted);
        services.add(ted2);

        Batch batch = new Batch.BatchBuilder(createDefaultBatchHeader(), services).build();
        batches.add(batch);

        FileTrailer fileTrailer = new FileTrailer(batches, new BankCode(123L));
    }
}
