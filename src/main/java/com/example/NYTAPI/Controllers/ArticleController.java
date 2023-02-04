package com.example.NYTAPI.Controllers;

import com.example.NYTAPI.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("articleList", articleService.getMostPopular());
        return "index";
    }

    @GetMapping("/search")
    public String searchPage() {
        return "search";
    }

    @PostMapping("/search")
    public String home(String query, Model model) {
        model.addAttribute("query",query);
        model.addAttribute("articleList", articleService.getSearchResults(query));
        return "search-results";
    }
}