package template.rest.resttemplate.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import template.rest.resttemplate.service.NewsServiceConsumer;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class AppRunner implements CommandLineRunner {
    private final NewsServiceConsumer newsServiceConsumer;
    public AppRunner(NewsServiceConsumer newsServiceConsumer) {
        this.newsServiceConsumer = newsServiceConsumer;
    }

    @Override
    public void run(String... args) {
        try {
            List<String> processedNews = newsServiceConsumer.consumeProcessedNewsService().get();

            System.out.println("Received Processed News:");
            processedNews.forEach(System.out::println);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
