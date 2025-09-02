package news_aggregator.app.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "sources")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Source {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
@Column(length = 1024)
private String url;
@Enumerated(EnumType.STRING)
private Type type = Type.API;
private Boolean enabled = true;
private LocalDateTime lastFetchedAt;
public enum Type { RSS, API }
}