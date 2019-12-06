package pl.coderslab.spring.hibernate.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring.hibernate.entities.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = "categories")
    List<Article> findAll();

}
