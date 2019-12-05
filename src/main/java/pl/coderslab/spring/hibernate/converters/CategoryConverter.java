package pl.coderslab.spring.hibernate.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spring.hibernate.entities.Author;
import pl.coderslab.spring.hibernate.entities.Category;
import pl.coderslab.spring.hibernate.repositories.CategoryDao;

public class CategoryConverter implements Converter<String, Category> {

    private CategoryDao categoryDao;

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category convert(String source) {
        try {
            Long id = Long.parseLong(source);
            Category category = categoryDao.findById(id);
            if (category == null) {
                throw new IllegalArgumentException("Nie ma autora o id " + id);
            }
            return category;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Wartosc " + source + " nie jest poprawnym id");
        }
    }











}
