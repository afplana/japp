package ao.jfpack.tests;

import java.util.HashMap;

// Test by value or by reference
public class User {
    String username;
    public User(String username){
        this.username = username;
    }

    public static void main(String... args){
        User u1 = new User("user_1"); //memory reference 50
        User u2 = new User("user_2"); //memory reference 100

        swap(u1, u2);
        System.out.println("First User: "+ u1.username);
        System.out.println("Second User: "+u2.username);

        setUsername(u2);
        System.out.println("Second User: "+u2.username);

    }

    private static void setUsername(User user) {
        user.username = "user_s";
        user = new User("user_3");
        user.username = "user_1";
    }

    //Generic swap method
    public static void swap(Object o1, Object o2){
        Object temp = o1;
        o1=o2;
        o2=temp;
    }
}
