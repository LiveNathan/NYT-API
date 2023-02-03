package com.example.NYTAPI.Models;

import lombok.Data;

@Data
public class NytSearchResponse {
    private String status;
    private Response response;
}
