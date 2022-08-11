package cnab.batch.segment.bsegment.complementarydata;

import cnab.utils.Util;

public final class ComplementaryData {
    private final Information10 information10;
    private final Information11 information11;
    private final Information12 information12;

    public ComplementaryData(ComplementaryDataBuilder complementaryDataBuilder) {
        this.information10 = complementaryDataBuilder.information10;
        this.information11 = complementaryDataBuilder.information11;
        this.information12 = complementaryDataBuilder.information12;
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(information10)+
                Util.getValueIfExist(information11)+
                Util.getValueIfExist(information12);
    }

    public static final class ComplementaryDataBuilder {
        private Information10 information10;
        private Information11 information11;
        private Information12 information12;

        public ComplementaryDataBuilder() {
        }

        public ComplementaryDataBuilder(Information10 information10, Information11 information11,
                                        Information12 information12) {
            this.information10 = information10;
            this.information11 = information11;
            this.information12 = information12;
        }

        public ComplementaryDataBuilder setInformation10(Information10 information10) {
            this.information10 = information10;
            return this;
        }

        public ComplementaryDataBuilder setInformation11(Information11 information11) {
            this.information11 = information11;
            return this;
        }

        public ComplementaryDataBuilder setInformation12(Information12 information12) {
            this.information12 = information12;
            return this;
        }

        public ComplementaryData build() {
            return new ComplementaryData(this);
        }
    }

}
