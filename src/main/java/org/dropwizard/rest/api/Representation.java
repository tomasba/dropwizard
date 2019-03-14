package org.dropwizard.rest.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Representation {
    @Length(max = 3)
    private String content;

    public Representation() {
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Representation(String content) {
        this.content = content;
    }
}
