package ao.jfpack.patterns.builder;

public class BuilderDemo {

    public static void main(String[] args) {
        ConnectionBuilder c = ConnectionBuilder.Builder.builder()
                .url("127.0.0.1")
                .service("org.CDDMZ.13Service")
                .username("admin")
                .port(6000)
                .password("admin")
                .driver("jdbc.PostgreSQL.my").build();

        System.out.println("Full database connection URL: " + c.getFullUrl());
    }
}
