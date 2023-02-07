package com.example.NYTAPI.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class Doc {
    @JsonProperty("abstract")
    private String summary;
    private String web_url;
    private List<Multimedia> multimedia;
    private Headline headline;
    private String pub_date;
    private Byline byline;
        private String imageUrl;

    public Doc(String summary, String web_url, List<Multimedia> multimedia, Headline headline, String pub_date, Byline byline) {
        this.summary = summary;
        this.web_url = web_url;
        this.multimedia = multimedia;
        this.headline = headline;
        this.pub_date = pub_date;
        this.byline = byline;

        Optional<Multimedia> result = multimedia.stream().filter(media -> media.getSubtype().equals("largeHorizontal375")).findFirst();
        result.ifPresent(value -> this.imageUrl = "https://www.nytimes.com/" + value.getUrl());
//        Optional<Multimedia> result = multimedia.stream()
//                .filter(media -> media.getSubtype().equals("largeHorizontal375"))
//                .findFirst()
//                .ifPresent(value -> this.imageUrl = "https://www.nytimes.com/" + value.getUrl());
    }
}
