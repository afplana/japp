package ao.jfpack.patterns.di.injector;

import ao.jfpack.patterns.di.repository.UserRepository;
import ao.jfpack.patterns.di.service.UserService;
import ao.jfpack.patterns.di.service.UserServiceImpl;

public class UserServiceInjectorImpl implements Injector<UserService> {
    @Override
    public UserService getComponent() {
        return new UserServiceImpl(new UserRepository());
    }
}
