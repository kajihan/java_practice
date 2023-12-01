package template.rest.resttemplate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import template.rest.resttemplate.service.NewsServiceConsumer;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RestTemplateApplicationTests {
    @Mock
    private RestTemplate restTemplate;

    @Test
    public void testConsumeProcessedNewsService() {
        List<String> newsList = Arrays.asList("News1", "News2", "News3");
        ResponseEntity<List<String>> mockResponseEntity = new ResponseEntity<>(newsList, HttpStatus.OK);

        Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET),
                        Mockito.any(), Mockito.<ParameterizedTypeReference<List<String>>>any()))
                .thenReturn(mockResponseEntity);

        NewsServiceConsumer newsServiceConsumer = new NewsServiceConsumer(restTemplate);
        CompletableFuture<List<String>> result = newsServiceConsumer.consumeProcessedNewsService();
        assertEquals(newsList, result.join());
    }
}