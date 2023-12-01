package template.rest.resttemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class NewsServiceConsumer {
    private final RestTemplate restTemplate;

    @Autowired
    public NewsServiceConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CompletableFuture<List<String>> consumeProcessedNewsService() {
        String url = "http://localhost:8081/api/news/processed";
        ResponseEntity<List<String>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return CompletableFuture.completedFuture(responseEntity.getBody());
    }
}