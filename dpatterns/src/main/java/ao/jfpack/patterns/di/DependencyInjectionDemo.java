package ao.jfpack.patterns.di;

import ao.jfpack.patterns.di.injector.Injector;
import ao.jfpack.patterns.di.injector.UserServiceInjectorImpl;
import ao.jfpack.patterns.di.repository.Repository;
import ao.jfpack.patterns.di.service.UserService;
import ao.jfpack.patterns.entity.User;
import ao.jfpack.patterns.factory.abstfac.FactoryProvider;

import java.util.Arrays;
import java.util.List;

public class DependencyInjectionDemo {

    public static void main(String[] args) {
        User user = (User) FactoryProvider.factoryOf(User.class).build("0,Alain".split(","));
        User user0 = (User) FactoryProvider.factoryOf(User.class).build("1,Ingri".split(","));
        List<User> l = Arrays.asList(user, user0);

        Injector<UserService> injector = new UserServiceInjectorImpl();
        UserService userService = injector.getComponent();

        userService.saveAll(l);
    }
}
