package cnab;

import cnab.file.CnabFile;
import cnab.meta.FileName;
import cnab.meta.Version;

public final class Cnab {
    private final Version version;
    private final FileName nameOfFile;
    private final CnabFile cnabFile;

    private Cnab(CnabBuilder builder){
        this.version = builder.version;
        this.nameOfFile = builder.nameOfFile;
        this.cnabFile = builder.cnabFile;
    }

    public static Cnab createNewCnab(String versionDescription, String name, CnabFile cnabFile) {
        Version version = new Version(versionDescription);
        FileName fileName = new FileName(name);
        return  new CnabBuilder(version, fileName, cnabFile).build();
    }

    public static final class CnabBuilder {
        private  Version version;
        private  FileName nameOfFile;
        private  CnabFile cnabFile;

        public CnabBuilder setVersion(Version version) {
            this.version = version;
            return this;
        }

        public CnabBuilder setNameOfFile(FileName nameOfFile) {
            this.nameOfFile = nameOfFile;
            return this;
        }

        public CnabBuilder setCnabFile(CnabFile cnabFile) {
            this.cnabFile = cnabFile;
            return this;
        }

        public CnabBuilder() {
        }

        public CnabBuilder(Version version, FileName nameOfFile, CnabFile cnabFile) {
            this.version = version;
            this.nameOfFile = nameOfFile;
            this.cnabFile = cnabFile;
        }

        public Cnab build(){
            return new Cnab(this);
        }
    }
}
