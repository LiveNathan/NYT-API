package com.example.NYTAPI.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Response {
    private List<Doc> docs;
}
