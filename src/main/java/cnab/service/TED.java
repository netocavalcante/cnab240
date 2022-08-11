package cnab.service;

import cnab.batch.segment.Segment;
import cnab.batch.segment.asegment.ASegment;
import cnab.batch.segment.bsegment.BSegment;
import cnab.batch.segment.csegment.CSegment;
import cnab.commonsfileds.control.BankCode;
import cnab.utils.Util;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public final class TED implements PaymentService {
    private final ASegment aSegment;
    private final BSegment bSegment;
    private final CSegment cSegment;

    public TED(TEDBuilder tedBuilder) {
        this.aSegment = tedBuilder.aSegment;
        this.bSegment = tedBuilder.bSegment;
        this.cSegment = tedBuilder.cSegment;
    }

    @Override
    public String toString() {
        StringJoiner content = new StringJoiner("\n")
                .add(Util.getValueIfExist(aSegment))
                .add(Util.getValueIfExist(bSegment));

        return Objects.isNull(cSegment) ? content.toString() : content.add(Util.getValueIfExist(cSegment)).toString();
    }

    @Override
    public BankCode getBankCode() {
        return aSegment.getBankCode();
    }

    @Override
    public long getAmountOfSegments() {
        Set<Segment> amountSegments = new HashSet<>();
        amountSegments.add(getRegistrationNumberIfexist(aSegment));
        amountSegments.add(getRegistrationNumberIfexist(bSegment));
        amountSegments.add(getRegistrationNumberIfexist(cSegment));
        return amountSegments.stream().filter(Objects::nonNull).count();
    }

    private Segment getRegistrationNumberIfexist(Segment segment){
        return Objects.nonNull(segment) ? segment : null ;
    }

    @Override
    public BigDecimal getTotalOfCoin() {
        return this.aSegment.getTotalOfCoin();
    }

    @Override
    public BigDecimal getPaymentAmount() {
        return this.aSegment.getPaymentAmount();
    }

    public static final class TEDBuilder {
        private final ASegment aSegment;
        private BSegment bSegment;
        private CSegment cSegment;

        public TEDBuilder(ASegment aSegment) {
            this.aSegment = aSegment;
        }

        public TEDBuilder setbSegment(BSegment bSegment) {
            this.bSegment = bSegment;
            return this;
        }

        public TEDBuilder setcSegment(CSegment cSegment) {
            this.cSegment = cSegment;
            return this;
        }

        public TED build() {
            return new TED(this);
        }
    }

}
