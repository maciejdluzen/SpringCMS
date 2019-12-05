package pl.coderslab.spring.hibernate.repositories;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring.hibernate.entities.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    private EntityManager em;

    public void create(Article entity) {
        em.persist(entity);
    }

    public void update(Article entity) {
        em.merge(entity);
    }

    public Article findById(Long id) {
        Article article = em.find(Article.class, id);
        Hibernate.initialize(article.getCategories());
        return article;
    }

    public void remove(Article entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public List<Article> findAll() {
        return em.createQuery("SELECT a FROM Article a", Article.class).getResultList();
    }
    
    
}
