package cnab.batch.header.fields.companyaddress;

import cnab.utils.Util;

public final class CompanyAdress {
    private final Cep cep;
    private final City city;
    private final State state;
    private final Street street;
    private final AddressNumber addressNumber;
    private final AddicionalInfo addicionalInfo;
    private final CepAddicionalInfo cepAddicionalInfo;

    public CompanyAdress(CompanyAddresBuilder companyAddresBuilder) {
        this.state = companyAddresBuilder.state;
        this.city = companyAddresBuilder.city;
        this.addressNumber = companyAddresBuilder.addressNumber;
        this.street = companyAddresBuilder.street;
        this.addicionalInfo = companyAddresBuilder.addicionalInfo;
        this.cepAddicionalInfo = companyAddresBuilder.cepAddicionalInfo;
        this.cep = companyAddresBuilder.cep;
    }

    public static CompanyAdress createDefaultCompanyAddressAsBlank(){

        return new CompanyAdress.CompanyAddresBuilder()
                .setStreet(new Street(" "))
                .setAddicionalInfo(new AddicionalInfo(" "))
                .setState(new State(" "))
                .setAddressNumber(new AddressNumber(0L))
                .setCity(new City(" "))
                .setCepAddicionalInfo(new CepAddicionalInfo(" "))
                .setCep(new Cep(0L))
                .build();
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(street)+
                Util.getValueIfExist(addressNumber)+
                Util.getValueIfExist(addicionalInfo)+
                Util.getValueIfExist(city)+
                Util.getValueIfExist(cep)+
                Util.getValueIfExist(cepAddicionalInfo)+
                Util.getValueIfExist(state);
    }

    public static final class CompanyAddresBuilder {
        private State state;
        private City city;
        private AddressNumber addressNumber;
        private Street street;
        private AddicionalInfo addicionalInfo;
        private CepAddicionalInfo cepAddicionalInfo;
        private Cep cep;

        public CompanyAddresBuilder() {
        }

        public CompanyAddresBuilder(State state, City city, AddressNumber number, Street street, AddicionalInfo addicionalInfo, CepAddicionalInfo cepAddicionalInfo, Cep cep) {
            this.state = state;
            this.city = city;
            this.addressNumber = number;
            this.street = street;
            this.addicionalInfo = addicionalInfo;
            this.cepAddicionalInfo = cepAddicionalInfo;
            this.cep = cep;
        }

        public CompanyAddresBuilder setState(State state) {
            this.state = state;
            return this;
        }

        public CompanyAddresBuilder setCity(City city) {
            this.city = city;
            return this;
        }

        public CompanyAddresBuilder setAddressNumber(AddressNumber addressNumber) {
            this.addressNumber = addressNumber;
            return this;
        }

        public CompanyAddresBuilder setStreet(Street street) {
            this.street = street;
            return this;
        }

        public CompanyAddresBuilder setAddicionalInfo(AddicionalInfo addicionalInfo) {
            this.addicionalInfo = addicionalInfo;
            return this;
        }

        public CompanyAddresBuilder setCepAddicionalInfo(CepAddicionalInfo cepAddicionalInfo) {
            this.cepAddicionalInfo = cepAddicionalInfo;
            return this;
        }

        public CompanyAddresBuilder setCep(Cep cep) {
            this.cep = cep;
            return this;
        }

        public CompanyAdress build() {
            return new CompanyAdress(this);
        }
    }

}
