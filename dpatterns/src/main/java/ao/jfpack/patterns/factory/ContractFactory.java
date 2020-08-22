package ao.jfpack.patterns.factory;

import ao.jfpack.patterns.entity.Contract;

public class ContractFactory implements Factory<Contract> {

    @Override
    public Contract build(String[] attributes) {
        return  (attributes.length >= 1)
                ?new Contract(Long.parseLong(attributes[0]))
                :new Contract();
    }
}
