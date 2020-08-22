package ao.jfpack.patterns.builder;

public class ConnectionBuilder {

    private String url;
    private int port;
    private String username;
    private String password;
    private String driver;
    private String service;
    private String fullUrl;

    public ConnectionBuilder(Builder builder){
        this.url = builder.url;
        this.username = builder.username;
        this.password = builder.password;
        this.driver = builder.driver;
        this.service = builder.service;
    }

    public String getFullUrl() {
        return driver+"://"+username+":"+password+"@"+url+":"+port+"/"+service;
    }

    public static class Builder {
        private String url;
        private String service;
        private int port;
        private String username;
        private String password;
        private String driver;

        private Builder() {}

        public static Builder builder(){
            return new Builder();
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder service(String service) {
            this.service = service;
            return this;
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder driver(String type) {
            this.driver = type;
            return this;
        }

        public ConnectionBuilder build() {
            return new ConnectionBuilder(this);
        }
    }
}
