import cnab.batch.segment.bsegment.BSegment;
import cnab.exceptions.ContentMoreThan240CharactersException;
import org.junit.jupiter.api.Test;
import testFactories.BSegmentTestFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BSegmentTest {

    @Test
    void shouldThrownException_WhenFileHeaderLargerThan240Characters(){
        ContentMoreThan240CharactersException exception = assertThrows(ContentMoreThan240CharactersException.class,
                BSegmentTestFactory::createInvalidBSegmentInformation10LongerThanPossible);

        assertThat(exception.getMessage(), containsString("The " + BSegment.class.getName() + " must have less than 240 charactes"));
    }

    @Test
    void BSegmentMusHave240Characters() throws ContentMoreThan240CharactersException {
        BSegment singleTedPayment = BSegmentTestFactory.createDefaultBSegment();
        assertEquals( 240,singleTedPayment.toString().length());
    }
}
