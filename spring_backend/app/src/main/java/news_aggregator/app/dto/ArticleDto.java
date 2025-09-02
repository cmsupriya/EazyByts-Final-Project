package news_aggregator.app.dto;

import java.time.LocalDateTime;

public record ArticleDto(Long id, String title, String summary, String url, String thumbnailUrl, LocalDateTime publishedAt, String sourceName)
 {
    
 }
