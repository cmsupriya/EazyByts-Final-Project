package news_aggregator.app.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import news_aggregator.app.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
Optional<Article> findByUrlHash(String urlHash);

List<Article> findByCategoryIgnoreCase(String category);

List<Article> findByCountryIgnoreCase(String iso);
}
