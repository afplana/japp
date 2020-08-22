package ao.jfpack.patterns.factory.abstfac;

import ao.jfpack.patterns.entity.Organisation;

public class OrganisationFactory implements Factory<Organisation> {

    @Override
    public Organisation build(String[] attributes) {
        return  (attributes.length >= 1)
                ?new Organisation(Long.parseLong(attributes[0]), null)
                :new Organisation();
    }
}
