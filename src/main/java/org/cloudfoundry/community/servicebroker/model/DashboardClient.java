package org.cloudfoundry.community.servicebroker.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class DashboardClient {

    @JsonSerialize
    @JsonProperty("id")
    private String id;

    @JsonSerialize
    @JsonProperty("secret")
    private String secret;

    @JsonSerialize
    @JsonProperty("redirect_uri")
    private String redirectUri;

    public DashboardClient(String id, String secret, String redirectUri) {
        this.id = id;
        this.secret = secret;
        this.redirectUri = redirectUri;
    }

    public DashboardClient(@SuppressWarnings("rawtypes") Map m) {
        if (m != null) {
            this.id = (String) m.get("id");
            this.secret = (String) m.get("secret");
            this.redirectUri = (String) m.get("redirect_uri");
        }
    }

    public String getId() {
        return id;
    }

    public String getSecret() {
        return secret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

}
