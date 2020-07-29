package ao.jfpack.patterns.builder;

public class User {

    private int id;
    private String name;
    private String address;
    private String organisationId;

    public User( Builder builder ){
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.organisationId = builder.organisationId;
    }

    public static class Builder {
        private int id;
        private String name;
        private String address;
        private String organisationId;

        private Builder( ) {
        }

        public static Builder builder(){
            return new Builder();
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder organisationId(String organisationId) {
            this.organisationId = organisationId;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
