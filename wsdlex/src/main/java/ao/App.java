package ao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

//    @Bean
//    CommandLineRunner lookup(ExWsdlClient client) {
//        return args -> {
//            String country = "Spain";
//
//            if (args.length > 0) {
//                country = args[0];
//            }
//            GetCountryResponse response = client.getCountry(country);
//            System.err.println(response.getCountry().getCurrency());
//        };
//    }
}
