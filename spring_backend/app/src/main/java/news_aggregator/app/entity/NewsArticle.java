package news_aggregator.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "news_articles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceName;
    private String author;
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(length = 2000)
    private String url;

    private String urlToImage;

    private LocalDateTime publishedAt;

    @Column(length = 5000)
    private String content;
}