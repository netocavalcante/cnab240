package cnab.commonsfileds.company.taxid;

import cnab.utils.Util;

public class Registration {
    private final RegistrationType type;
    private final RegistrationNumber number;

    private Registration(RegistrationBuilder inscriptionId) {
        type = inscriptionId.type;
        number = inscriptionId.number;
    }

    public static Registration createRegistration(long type, long number) {
        return new Registration.RegistrationBuilder(new RegistrationType(type), new RegistrationNumber(number)).build();
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist( type )+
                Util.getValueIfExist( number );
    }

    public static final class RegistrationBuilder {
        private RegistrationType type;
        private RegistrationNumber number;

        public RegistrationBuilder(RegistrationType type, RegistrationNumber number) {
            this.type = type;
            this.number = number;
        }

        public RegistrationBuilder setType(RegistrationType type) {
            this.type = type;
            return this;
        }

        public RegistrationBuilder setNumber(RegistrationNumber number) {
            this.number = number;
            return this;
        }

        public Registration build() {
            return new Registration(this);
        }
    }

}
