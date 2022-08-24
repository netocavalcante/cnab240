package cnab.batch.header.fields.service;

import cnab.utils.Util;

public final class BatchHeaderService {
    private final Operation operation;
    private final SenderType senderType;
    private final ServiceType serviceType;
    private final LayoutVersion layoutVersion;

    public BatchHeaderService(BatchHeaderServiceBuilder serviceBuilder) {
        this.operation = serviceBuilder.operation;
        this.senderType = serviceBuilder.senderType;
        this.serviceType = serviceBuilder.serviceType;
        this.layoutVersion = serviceBuilder.layoutVersion;
    }

    public static BatchHeaderService createDefaultBathHeaderService(Long serviceTypeValue, Long senderTypeValue) {
        Operation operation = new Operation("C");
        SenderType senderType = new SenderType(senderTypeValue);
        LayoutVersion layoutVersion = new LayoutVersion(46L);
        ServiceType serviceType = new ServiceType(serviceTypeValue);
        return new BatchHeaderServiceBuilder(operation, serviceType, layoutVersion, senderType).build();
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(operation)+
                Util.getValueIfExist(serviceType)+
                Util.getValueIfExist(senderType)+
                Util.getValueIfExist(layoutVersion);
    }

    public static final class BatchHeaderServiceBuilder {
        private Operation operation;
        private SenderType senderType;
        private ServiceType serviceType;
        private LayoutVersion layoutVersion;

        public BatchHeaderServiceBuilder(Operation operation, ServiceType serviceType,
                                         LayoutVersion layoutVersion, SenderType senderType) {
            this.operation = operation;
            this.senderType = senderType;
            this.serviceType = serviceType;
            this.layoutVersion = layoutVersion;
        }

        public BatchHeaderServiceBuilder setOperation(Operation operation) {
            this.operation = operation;
            return this;
        }

        public BatchHeaderServiceBuilder setServiceType(ServiceType serviceType) {
            this.serviceType = serviceType;
            return this;
        }

        public BatchHeaderServiceBuilder setLayoutVersion(LayoutVersion layoutVersion) {
            this.layoutVersion = layoutVersion;
            return this;
        }

        public BatchHeaderServiceBuilder setSenderType(SenderType senderType) {
            this.senderType = senderType;
            return this;
        }

        public BatchHeaderService build() {
            return new BatchHeaderService(this);
        }
    }
}
