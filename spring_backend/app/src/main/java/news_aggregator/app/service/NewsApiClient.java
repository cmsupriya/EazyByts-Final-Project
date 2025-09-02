package news_aggregator.app.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RequiredArgsConstructor
@Service
public class NewsApiClient {
    private final WebClient.Builder webClientBuilder;

    @Value("${newsapi.key}")
    private String apiKey;

    @Value("${newsapi.base-url}")
    private String baseUrl;

    private WebClient client() {
        return webClientBuilder.baseUrl(baseUrl).build();
    }

    public JsonNode everything(String q, int page, int pageSize) {
        try {
            return client()
                    .get()
                    .uri(uri -> uri.path("/everything")
                            .queryParam("q", q)
                            .queryParam("page", page)
                            .queryParam("pageSize", pageSize)
                            .queryParam("apiKey", apiKey)
                            .build())
                    .retrieve()
                    .bodyToMono(JsonNode.class)
                    .block();
        } catch (WebClientResponseException ex) {
            throw ex;
        }
    }

    public JsonNode topHeadlines(String category, int page, int pageSize) {
        try {
            return client()
                    .get()
                    .uri(uri -> uri.path("/top-headlines")
                            .queryParam("category", category)
                            .queryParam("language", "en")
                            .queryParam("page", page)
                            .queryParam("pageSize", pageSize)
                            .queryParam("apiKey", apiKey)
                            .build())
                    .retrieve()
                    .bodyToMono(JsonNode.class)
                    .block();
        } catch (WebClientResponseException ex) {
            throw ex;
        }
    }
}
