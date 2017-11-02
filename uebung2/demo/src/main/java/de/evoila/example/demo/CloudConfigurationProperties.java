package de.evoila.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cloud.training")
public class CloudConfigurationProperties {
    private String myprop = "";

    public String getMyprop() {
        return myprop;
    }

    public void setMyprop(String myprop) {
        this.myprop = myprop;
    }
}
