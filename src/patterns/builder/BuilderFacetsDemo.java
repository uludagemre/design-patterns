package patterns.builder;

class FacetPerson {
    // address
    public String streetAddress, postcode, city;

    // employment
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}

// builder facade
class FacetPersonBuilder {
    // the object we're going to build
    protected FacetPerson facetPerson = new FacetPerson(); // reference!

    public FacetPersonJobBuilder works() {
        return new FacetPersonJobBuilder(facetPerson);
    }

    public FacetPersonAddressBuilder lives() {
        return new FacetPersonAddressBuilder(facetPerson);
    }

    public FacetPerson build() {
        return facetPerson;
    }
}

class FacetPersonAddressBuilder extends FacetPersonBuilder {
    public FacetPersonAddressBuilder(FacetPerson facetPerson) {
        this.facetPerson = facetPerson;
    }

    public FacetPersonAddressBuilder at(String streetAddress) {
        facetPerson.streetAddress = streetAddress;
        return this;
    }

    public FacetPersonAddressBuilder withPostcode(String postcode) {
        facetPerson.postcode = postcode;
        return this;
    }

    public FacetPersonAddressBuilder in(String city) {
        facetPerson.city = city;
        return this;
    }
}

class FacetPersonJobBuilder extends FacetPersonBuilder {
    public FacetPersonJobBuilder(FacetPerson facetPerson) {
        this.facetPerson = facetPerson;
    }

    public FacetPersonJobBuilder at(String companyName) {
        facetPerson.companyName = companyName;
        return this;
    }

    public FacetPersonJobBuilder asA(String position) {
        facetPerson.position = position;
        return this;
    }

    public FacetPersonJobBuilder earning(int annualIncome) {
        facetPerson.annualIncome = annualIncome;
        return this;
    }
}

class BuilderFacetsDemo {
    public static void main(String[] args) {
        FacetPersonBuilder pb = new FacetPersonBuilder();
        FacetPerson facetPerson = pb
                .lives()
                .at("123 London Road")
                .in("London")
                .withPostcode("SW12BC")
                .works()
                .at("Fabrikam")
                .asA("Engineer")
                .earning(123000)
                .build();
        System.out.println(facetPerson);
    }
}