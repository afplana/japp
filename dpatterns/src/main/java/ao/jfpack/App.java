package ao.jfpack;

import ao.jfpack.patterns.builder.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        User user = User.Builder.builder()
                .id(1).name("Mockito").address("Vazrazhdane #15")
                .organisationId("1928_3746_5").build();
        System.out.println( "Hello World!" );
    }
}
