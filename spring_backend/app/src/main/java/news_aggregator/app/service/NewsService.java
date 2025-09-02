package news_aggregator.app.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import news_aggregator.app.entity.NewsArticle;
import news_aggregator.app.repository.NewsArticleRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsArticleRepository newsArticleRepository;

    @Transactional
    public void saveArticlesFromApi(JsonNode apiResponse) {
        if (apiResponse == null || !apiResponse.has("articles")) {
            return;
        }

        List<NewsArticle> articlesToSave = new ArrayList<>();

        for (JsonNode articleNode : apiResponse.get("articles")) {
            try {
                NewsArticle article = NewsArticle.builder()
                        .sourceName(articleNode.path("source").path("name").asText(null))
                        .author(articleNode.path("author").asText(null))
                        .title(articleNode.path("title").asText(null))
                        .description(articleNode.path("description").asText(null))
                        .url(articleNode.path("url").asText(null))
                        .urlToImage(articleNode.path("urlToImage").asText(null))
                        .publishedAt(parseDate(articleNode.path("publishedAt").asText(null)))
                        .content(articleNode.path("content").asText(null))
                        .build();

                articlesToSave.add(article);
            } catch (Exception e) {
                System.err.println("Error parsing article: " + e.getMessage());
            }
        }

        if (!articlesToSave.isEmpty()) {
            newsArticleRepository.saveAll(articlesToSave);
        }
    }

    public List<NewsArticle> getAllArticles() {
        return newsArticleRepository.findAll();
    }

    private LocalDateTime parseDate(String dateString) {
        try {
            if (dateString != null) {
                return LocalDateTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME);
            }
        } catch (Exception e) {
            System.err.println("Date parse error: " + e.getMessage());
        }
        return null;
    }
}
