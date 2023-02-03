package com.example.NYTAPI.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NytResponse {
    private String status;
    private String copyright;
    @JsonProperty("num_results")
    private int numResults;
    private List<Article> results;
}
