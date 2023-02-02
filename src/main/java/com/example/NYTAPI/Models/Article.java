package com.example.NYTAPI.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.Media;
import java.util.List;
@Data
@NoArgsConstructor
public class Article {
    private Long id;
    private String url;
    private String section;
    private String subsection;
    private String byline;
    private String title;

    @JsonProperty("abstract")
    private String summary;

    private List<Media> media;
    private String imageUrl;
}
