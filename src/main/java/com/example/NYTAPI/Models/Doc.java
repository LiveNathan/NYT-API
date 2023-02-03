package com.example.NYTAPI.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Doc {
    @JsonProperty("abstract")
    private String summary;
    private String web_url;
    private List<Multimedia> multimedia;
    private Headline headline;
    private String pub_date;
    private Byline byline;
}
