package ao.jfpack.patterns.di.repository;

import ao.jfpack.patterns.entity.User;

import java.util.Collection;
import java.util.Collections;

public class UserRepository implements Repository<User> {

    @Override
    public Collection<User> saveAll(Collection<User> c) {
        System.out.println("Persisting users collection of "+c.size()+" elements");
        return Collections.emptyList();
    }
}
