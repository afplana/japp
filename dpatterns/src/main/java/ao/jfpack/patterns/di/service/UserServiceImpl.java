package ao.jfpack.patterns.di.service;

import ao.jfpack.patterns.di.repository.Repository;
import ao.jfpack.patterns.entity.User;

import java.util.Collection;

public class UserServiceImpl implements UserService {

    private final Repository<User> userRepository;

    public UserServiceImpl(Repository<User> userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Collection<User> saveAll(Collection<User> users) {
        return userRepository.saveAll(users);
    }
}
