package com.example.NYTAPI.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
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

    public Article(Long id, String url, String section, String subsection, String byline, String title, String summary, List<Media> media) {
        this.id = id;
        this.url = url;
        this.section = section;
        this.subsection = subsection;
        this.byline = byline;
        this.title = title;
        this.summary = summary;
        this.media = media;
        if (!media.get(0).getMediaMetadata().get(1).getUrl().isEmpty()) {
            this.imageUrl = getMedia().get(0).getMediaMetadata().get(1).getUrl();
        }
    }

}
