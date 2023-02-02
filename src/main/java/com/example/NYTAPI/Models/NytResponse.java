package com.example.NYTAPI.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class NytResponse {
    private String status;
    private String copyright;
    @JsonProperty("num_results")
    private int numResults;
    private List<Article> results;
}
