package news_aggregator.app.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "articles", uniqueConstraints = @UniqueConstraint(columnNames = "url_hash"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "source_id")
private Source source;
private String externalId;

@Column(length = 10)
private String country;


@Column(length = 1024)
private String url;

@Column(name = "url_hash", length = 64)
private String urlHash;

@Column(length = 512)
private String title;

@Lob
private String summary;
@Lob
private String content;
private String author;
private String language;
private LocalDateTime publishedAt;
private LocalDateTime fetchedAt;
private String thumbnailUrl;
private String category;

@Column(name = "content_hash", length = 64)
private String contentHash;


@Enumerated(EnumType.STRING)
private Status status = Status.ACTIVE;

public enum Status { ACTIVE, DELETED }
}
