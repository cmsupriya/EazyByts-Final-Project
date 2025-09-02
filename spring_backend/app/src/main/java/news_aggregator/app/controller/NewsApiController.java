package news_aggregator.app.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import news_aggregator.app.service.NewsApiClient;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/newsapi")
@RequiredArgsConstructor
public class NewsApiController {

    private final NewsApiClient newsApiClient;

    @GetMapping("/everything")
    public ResponseEntity<Map<String, Object>> getEverything(
            @RequestParam String q,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize) {

        JsonNode result = newsApiClient.everything(q, page, pageSize);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", result);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/top-headlines")
    public ResponseEntity<Map<String, Object>> getTopHeadlines(
            @RequestParam(defaultValue = "general") String category,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize) {

        JsonNode result = newsApiClient.topHeadlines(category, page, pageSize);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", result);

        return ResponseEntity.ok(response);
    }
}
