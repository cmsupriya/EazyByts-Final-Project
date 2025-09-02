package news_aggregator.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import news_aggregator.app.entity.NewsArticle;

public interface NewsArticleRepository extends JpaRepository<NewsArticle, Long> {

}
