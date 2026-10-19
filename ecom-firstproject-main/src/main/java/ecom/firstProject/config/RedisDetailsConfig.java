package ecom.firstProject.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "redis")
public class RedisDetailsConfig {

    private String host;
    private Integer port;
    private Integer ttl;

    public RedisDetailsConfig(String host, Integer port, Integer ttl) {
        this.host = host;
        this.port = port;
        this.ttl = ttl;

        System.out.println(host + ":" + port);
    }

    public String getHost() {
        return this.host;
    }
    public Integer getPort() {
        return this.port;
    }
    public Integer getTtl() {
        return this.ttl;
    }
}
