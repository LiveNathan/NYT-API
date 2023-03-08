package com.example.NYTAPI.Services;

import com.example.NYTAPI.Models.Article;
import com.example.NYTAPI.Models.Doc;
import com.example.NYTAPI.Models.NytResponse;
import com.example.NYTAPI.Models.NytSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Value("${api_key}")
    private String apikey;

    @Value("${mostPopularUrl}")
    private String mostPopularUrl;

    @Value("${articleSearchUrl}")
    private String articleSearchUrl;

    @Autowired
    RestTemplate restTemplate;

    @Cacheable(value = "articles")
    public List<Article> getMostPopular() {
        NytResponse response = restTemplate.getForObject(mostPopularUrl + "api-key=" + apikey, NytResponse.class);
        List<Article> results = new ArrayList<>();
        if (response != null && response.getStatus().equals("OK")) {
            return response.getResults();
        } else {
            return results;
        }
    }

    @Cacheable(value = "docs")
    public List<Doc> getSearchResults(String searchText) {
        ResponseEntity<NytSearchResponse> responseEntity = restTemplate.getForEntity(articleSearchUrl + "q=" + searchText + "&api-key=" + apikey, NytSearchResponse.class);
        List<Doc> docs = new ArrayList<>();
        if (responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody() != null) {
            return responseEntity.getBody().getResponse().getDocs();
        } else {
            return docs;
        }
    }
}