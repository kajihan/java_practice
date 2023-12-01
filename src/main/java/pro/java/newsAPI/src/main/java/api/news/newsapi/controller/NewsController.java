package api.news.newsapi.controller;


import api.news.newsapi.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/top")
    public void getTopNews() {
        newsService.getTopNews();
    }

    @GetMapping("/processed")
    public CompletableFuture<List<String>> getProcessedNews() {
        return newsService.getProcessedNews();
    }
}
