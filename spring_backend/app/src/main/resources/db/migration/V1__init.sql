CREATE TABLE news_articles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    source_name VARCHAR(255),
    author VARCHAR(255),
    title VARCHAR(500),
    description TEXT,
    url VARCHAR(2000),
    url_to_image VARCHAR(1000),
    published_at DATETIME,
    content TEXT
);
