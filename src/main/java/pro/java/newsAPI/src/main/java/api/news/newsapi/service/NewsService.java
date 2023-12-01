package api.news.newsapi.service;

import api.news.newsapi.config.Config;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class NewsService {
    private final Config config;

    @Autowired
    public NewsService(Config config) {
        this.config = config;
    }

    public void getTopNews() {
        NewsApiClient newsApiClient = new NewsApiClient(config.apiNewsKey);

        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .q("Ukraine")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {

                    @Override
                    public void onSuccess(ArticleResponse response) {
                        List<String> topNews = response.getArticles().stream()
                                .map(a -> "Glory to Ukraine - " + a.getTitle())
                                .filter(s -> !s.contains("[Removed]"))
                                .toList();
                        for (String s : topNews) {
                            System.out.println(s);
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );
    }

    public CompletableFuture<ArticleResponse> fetchTopHeadlinesAsync() {
        NewsApiClient newsApiClient = new NewsApiClient(config.apiNewsKey);

        CompletableFuture<ArticleResponse> future = new CompletableFuture<>();

        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .q("Ukraine")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse articleResponse) {
                        future.complete(articleResponse);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        future.completeExceptionally(throwable);
                    }
                }
        );

        return future;
    }

    public CompletableFuture<List<String>> getProcessedNews() {
        return fetchTopHeadlinesAsync().thenApply(response -> {
            return response.getArticles().stream()
                    .map(article -> "Glory to Ukraine - " + article.getTitle())
                    .filter(s -> !s.contains("[Removed]"))
                    .collect(Collectors.toList());
        });
    }
}