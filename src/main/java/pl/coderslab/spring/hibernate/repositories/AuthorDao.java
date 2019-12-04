package pl.coderslab.spring.hibernate.repositories;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring.hibernate.entities.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager em;

    public void create(Author entity) {
        em.persist(entity);
    }

    public void update(Author entity) {
        em.merge(entity);
    }

    public Author findById(Long id) {
        return em.find(Author.class, id);
    }

    public void remove(Author entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public List<Author> findAll() {
        return em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }

}
