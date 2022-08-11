import cnab.commonsfileds.control.BankCode;
import cnab.exceptions.ContentMoreThan240CharactersException;
import cnab.service.TED;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static testFactories.ASegmentTestFactory.createDefaultASegment;
import static testFactories.BSegmentTestFactory.createDefaultBSegment;
import static testFactories.CSegmentFactory.createDefaultCSegment;

class TEDTest {

    @Test
    @Tag("This test validate if the number of segments are three as expected")
    void theAmountOfSegmentsShouldBe3() throws ContentMoreThan240CharactersException {
        TED ted = new TED.TEDBuilder(createDefaultASegment(new BankCode(123L)))
                .setbSegment(createDefaultBSegment())
                .setcSegment(createDefaultCSegment())
                .build();

        assertEquals( 3, ted.getAmountOfSegments());
    }

    @Test
    @Tag("This test validate if the number of segments are two as expected")
    void theAmountOfSegmentsShouldBe2() throws ContentMoreThan240CharactersException {
        TED ted = new TED.TEDBuilder(createDefaultASegment(new BankCode(123L)))
                .setbSegment(createDefaultBSegment())
                .build();

        assertEquals( 2, ted.getAmountOfSegments());
    }

    @Test
    @Tag("This test validate if the number of segments is on as expected")
    void theAmountOfSegmentsShouldBe1() throws ContentMoreThan240CharactersException {
        TED ted = new TED.TEDBuilder(createDefaultASegment(new BankCode(123L)))
                .build();

        assertEquals( 1, ted.getAmountOfSegments());
    }
}
