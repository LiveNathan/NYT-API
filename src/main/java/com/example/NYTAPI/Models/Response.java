package com.example.NYTAPI.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Response {
    @JsonProperty("doc")
    private List<Doc> docs;
}
