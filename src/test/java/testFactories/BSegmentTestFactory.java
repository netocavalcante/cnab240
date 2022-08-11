package testFactories;

import cnab.batch.segment.bsegment.BSegment;
import cnab.batch.segment.bsegment.ISPBCode;
import cnab.batch.segment.bsegment.PayeeIdentification;
import cnab.batch.segment.bsegment.SIAPECode;
import cnab.batch.segment.bsegment.complementarydata.ComplementaryData;
import cnab.batch.segment.bsegment.complementarydata.Information10;
import cnab.batch.segment.bsegment.complementarydata.Information11;
import cnab.batch.segment.bsegment.complementarydata.Information12;
import cnab.batch.segment.bsegment.payeeenrollment.EnrollmentNumber;
import cnab.batch.segment.bsegment.payeeenrollment.EnrollmentType;
import cnab.batch.segment.bsegment.payeeenrollment.PayeeEnrollment;
import cnab.commonsfileds.control.BankCode;
import cnab.exceptions.ContentMoreThan240CharactersException;

public final class BSegmentTestFactory {

    private BSegmentTestFactory() {
    }

    public static BSegment createDefaultBSegment() throws ContentMoreThan240CharactersException {
        PayeeIdentification payeeIdentification = new PayeeIdentification("");
        PayeeEnrollment payeeEnrollment = new PayeeEnrollment(new EnrollmentType(2L),
                new EnrollmentNumber(47866934000174L));
        ComplementaryData complementaryData = new ComplementaryData.ComplementaryDataBuilder(
                new Information10("                              00000"),
                new Information11("                                                  00000000SP"),
                new Information12("07012022000000000510001000000000000000000000000000000000000000000000000000000000000NF12345678901210"))
                .build();
        return BSegment.createSingleTedPayment(new BankCode(123L), payeeIdentification,
                payeeEnrollment, complementaryData, new SIAPECode(0L), new ISPBCode(0L));
    }

    public static BSegment createInvalidBSegmentInformation10LongerThanPossible() throws ContentMoreThan240CharactersException {
        PayeeIdentification payeeIdentification = new PayeeIdentification("");
        PayeeEnrollment payeeEnrollment = new PayeeEnrollment(new EnrollmentType(2L),
                new EnrollmentNumber(47866934000174L));
        ComplementaryData complementaryData = new ComplementaryData.ComplementaryDataBuilder(
                new Information10("                              00000",100),
                new Information11("                                                  00000000SP"),
                new Information12("07012022000000000510001000000000000000000000000000000000000000000000000000000000000NF12345678901210"))
                .build();
        return BSegment.createSingleTedPayment(new BankCode(123L), payeeIdentification,
                payeeEnrollment, complementaryData, new SIAPECode(0L), new ISPBCode(0L));
    }
}
