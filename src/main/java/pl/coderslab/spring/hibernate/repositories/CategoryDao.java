package pl.coderslab.spring.hibernate.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring.hibernate.entities.Author;
import pl.coderslab.spring.hibernate.entities.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    private EntityManager em;

    public void create(Category entity) {
        em.persist(entity);
    }

    public void update(Category entity) {
        em.merge(entity);
    }

    public Category findById(Long id) {
        return em.find(Category.class, id);
    }

    public void remove(Category entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public List<Category> findAll() {
        return em.createQuery("SELECT a FROM Category a", Category.class).getResultList();
    }

}
