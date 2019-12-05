package pl.coderslab.spring.hibernate.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spring.hibernate.entities.Author;
import pl.coderslab.spring.hibernate.repositories.AuthorDao;

public class AuthorConverter implements Converter<String, Author> {

    private AuthorDao authorDao;

    @Autowired
    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author convert(String source) {
        try {
            Long id = Long.parseLong(source);
            Author author = authorDao.findById(id);
            if (author == null) {
                throw new IllegalArgumentException("Nie ma autora o id " + id);
            }
            return author;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Wartosc " + source + " nie jest poprawnym id");
        }
    }
}
