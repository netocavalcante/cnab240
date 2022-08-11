package cnab.file;

import cnab.batch.Batch;
import cnab.file.header.FileHeader;
import cnab.file.trailer.FileTrailer;
import cnab.utils.Util;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public final class CnabFile {
    private final Set<Batch> batchs;
    private final FileHeader fileHeader;
    private final FileTrailer fileTrailer;

    private CnabFile(CnabFileBuilder cnabFileBuilder) {
        this.batchs = cnabFileBuilder.batchs;
        this.fileHeader = cnabFileBuilder.fileHeader;
        this.fileTrailer = cnabFileBuilder.fileTrailer;
    }

    public FileHeader getFileHeader() {
        return fileHeader;
    }

    public FileTrailer getFileTrailer() {
        return fileTrailer;
    }

    public Set<Batch> getBatchs() {
        return cloneElements(batchs);
    }

    @Override
    public String toString() {
        return new StringJoiner("\n")
                .add(Util.getValueIfExist(fileHeader))
                .merge(getBatchsValues(batchs))
                .add(Util.getValueIfExist(fileTrailer))
                .toString();
    }

    private StringJoiner getBatchsValues(Set<Batch> batchs) {
        StringJoiner joiner = new StringJoiner("\n");
        batchs.forEach(batch -> joiner.add(Util.getValueIfExist(batch)));
        return joiner;
    }

    public static final class CnabFileBuilder {
        private  Set<Batch> batchs;
        private  FileHeader fileHeader;
        private final FileTrailer fileTrailer;

        public CnabFileBuilder(FileHeader fileHeader,  Set<Batch> batchs) {
            this.batchs = batchs;
            this.fileHeader = fileHeader;
            this.fileTrailer = new FileTrailer(batchs, fileHeader.getBankCode());
        }

        public CnabFileBuilder setFileHeader(FileHeader fileHeader) {
            this.fileHeader = fileHeader;
            return this;
        }

        public CnabFileBuilder setBatchs(Set<Batch> batchs) {
            this.batchs = cloneElements(batchs);
            return this;
        }

        public CnabFile build() {
            return new CnabFile(this);
        }
    }

    private static Set<Batch> cloneElements(Set<Batch> batchs) {
        return new HashSet<>(batchs);
    }
}
