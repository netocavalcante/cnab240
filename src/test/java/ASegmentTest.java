import cnab.batch.segment.asegment.*;
import cnab.commonsfileds.control.BankCode;
import cnab.exceptions.ContentMoreThan240CharactersException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testFactories.ASegmentTestFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ASegmentTest {
    @Test
    void shouldThrownException_WhenFileHeaderLargerThan240Characters(){
        ContentMoreThan240CharactersException exception =
                Assertions.assertThrows(ContentMoreThan240CharactersException.class, () ->
               ASegmentTestFactory.createInvalidASegmentWithNoticeWith100Characters(new BankCode(123L)));

        assertThat(exception.getMessage(), containsString("The " + ASegment.class.getName() + " must have less than 240 charactes"));
    }

    @Test
    void ASegmentMusHave240Characters() throws ContentMoreThan240CharactersException {

        ASegment singleTedPayment = ASegmentTestFactory.createDefaultASegment(new BankCode(123L));

        assertEquals( 240,singleTedPayment.toString().length());
    }

}
