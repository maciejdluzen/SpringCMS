package pl.coderslab.spring.hibernate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.spring.hibernate.entities.Article;
import pl.coderslab.spring.hibernate.entities.Author;
import pl.coderslab.spring.hibernate.entities.Category;
import pl.coderslab.spring.hibernate.repositories.ArticleDao;
import pl.coderslab.spring.hibernate.repositories.AuthorDao;
import pl.coderslab.spring.hibernate.repositories.CategoryDao;

import javax.persistence.*;
import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorDao.findAll();
    }

    @GetMapping
    public String prepareAllArticlesPage(Model model) {
        model.addAttribute("articles", articleDao.findAll());
        return "all-articles";
    }

    @GetMapping("/create")
    public String prepareCreateArticleForm(Model model) {
        model.addAttribute("article", new Article());
        return "add-article";
    }

    @PostMapping("/create")
    public String processCreateArticleForm(@ModelAttribute Article article) {
        articleDao.create(article);
        return "redirect:/articles";
    }
}
