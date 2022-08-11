package cnab.batch;

import cnab.batch.header.BatchHeader;
import cnab.batch.trailer.BatchTrailer;
import cnab.exceptions.ServiceNotAllowedException;
import cnab.service.Service;
import cnab.utils.Util;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;


public final class Batch {
    private final Set<Service> services;
    private final BatchHeader batchHeader;
    private final BatchTrailer batchTrailer;

    private Batch(BatchBuilder batchBuilder) {
        services = batchBuilder.segments;
        batchHeader = batchBuilder.batchHeader;
        batchTrailer = batchBuilder.batchTrailer;
    }

    public Set<Service> getServices() {
        return services;
    }

    @Override
    public String toString() {
        return  new StringJoiner("\n")
                .add(Util.getValueIfExist(batchHeader))
                .merge(getServicesValues(services))
                .add(Util.getValueIfExist(batchTrailer))
                .toString();
    }

    private StringJoiner getServicesValues(Set<Service> services) {
        StringJoiner joiner = new StringJoiner("\n");
        services.forEach(service -> joiner.add(Util.getValueIfExist(service)));
        return joiner;
    }

    public static final class BatchBuilder {
        private Set<Service> segments;
        private BatchHeader batchHeader;
        private BatchTrailer batchTrailer;

        public BatchBuilder(BatchHeader batchHeader, Set<Service> segments) {
            this.segments = cloneElements(segments);
            this.batchHeader = batchHeader;
            this.batchTrailer = new BatchTrailer(segments, batchHeader.getBankCode() , batchHeader.getControlNumber());
        }

        public BatchBuilder setBatchHeader(BatchHeader batchHeader) {
            this.batchHeader = batchHeader;
            return this;
        }

        public BatchBuilder setServices(Set<Service> segments) {
            this.segments = cloneElements(segments);
            return this;
        }

        public BatchBuilder setBatchTrailer(BatchTrailer batchTrailer) {
            this.batchTrailer = batchTrailer;
            return this;
        }

        private static Set<Service> cloneElements(Set<Service> services) {
            return new HashSet<>(services);
        }

        public Batch build() throws ServiceNotAllowedException {
            validate(this.segments);
            return new Batch(this);
        }

        private static void validate(Set<Service> services) throws ServiceNotAllowedException {
            for (Service service: services) {
                mustThrowExceptionIfServiceHasntTheBankCode(service);
            }
        }

        private static void mustThrowExceptionIfServiceHasntTheBankCode(Service service) throws ServiceNotAllowedException {
            if (Objects.isNull(service.getBankCode())) {
                throw new ServiceNotAllowedException("All Services must have a bank code");
            }
        }
    }
}


