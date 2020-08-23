package ao.jfpack.patterns.di.service;

import ao.jfpack.patterns.entity.User;

import java.util.Collection;

public interface UserService {

    Collection<User> saveAll(Collection<User> users);
}
