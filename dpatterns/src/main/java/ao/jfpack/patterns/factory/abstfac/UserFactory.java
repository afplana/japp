package ao.jfpack.patterns.factory.abstfac;

import ao.jfpack.patterns.entity.User;

public class UserFactory implements Factory<User> {

    @Override
    public User build(String[] attributes) {
        return  (attributes.length >= 2)
                ?new User(Long.parseLong(attributes[0]), attributes[1])
                :new User();
    }
}
