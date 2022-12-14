package cnab.file.header.fields.file;

import cnab.utils.Util;

import java.time.LocalDate;
import java.time.LocalTime;

public class File {
    private final Code code;
    private final Layout layout;
    private final Density density;
    private final Sequence sequence;
    private final GenerationDate generationDate;
    private final GenerationTime generationTime;

    public File(FileBuilder fileBuilder) {
        this.code = fileBuilder.code;
        this.layout = fileBuilder.layout;
        this.density = fileBuilder.density;
        this.sequence = fileBuilder.sequence;
        this.generationDate = fileBuilder.generationDate;
        this.generationTime = fileBuilder.generationTime;
    }

    public static File createDefaultSinglePaymentFile(){
        Code code = new Code(1L);
        Layout layout = new Layout("103");
        Sequence sequence = new Sequence(1L);
        Density density = new Density(1650L);
        GenerationTime generationTime = new GenerationTime(LocalTime.now());
        GenerationDate generationDate = new GenerationDate(LocalDate.now());
        return new FileBuilder(code,generationDate,generationTime,sequence,layout,density).build();
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(code)+
                Util.getValueIfExist(generationDate)+
                Util.getValueIfExist(generationTime)+
                Util.getValueIfExist(sequence)+
                Util.getValueIfExist(layout)+
                Util.getValueIfExist(density);
    }

    public static final class FileBuilder {
        private Code code;
        private Layout layout;
        private Density density;
        private Sequence sequence;
        private GenerationDate generationDate;
        private GenerationTime generationTime;

        public FileBuilder() {
        }

        public FileBuilder(Code code, GenerationDate generationDate, GenerationTime generationTime, Sequence sequence,
                           Layout layout, Density density) {
            this.code = code;
            this.layout = layout;
            this.density = density;
            this.sequence = sequence;
            this.generationDate = generationDate;
            this.generationTime = generationTime;
        }

        public FileBuilder setCode(Code code) {
            this.code = code;
            return this;
        }

        public FileBuilder setGenerationDate(GenerationDate generationDate) {
            this.generationDate = generationDate;
            return this;
        }

        public FileBuilder setGenerationTime(GenerationTime generationTime) {
            this.generationTime = generationTime;
            return this;
        }

        public FileBuilder setSequence(Sequence sequence) {
            this.sequence = sequence;
            return this;
        }

        public FileBuilder setLayout(Layout layout) {
            this.layout = layout;
            return this;
        }

        public FileBuilder setDensity(Density density) {
            this.density = density;
            return this;
        }

        public File build() {
            return new File(this);
        }
    }

}
