package api.news.newsapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "api.news.newsapi")
public class Config {

    @Value("${api.news.key}")
    public String apiNewsKey;
}
