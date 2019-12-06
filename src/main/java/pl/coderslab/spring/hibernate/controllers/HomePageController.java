package pl.coderslab.spring.hibernate.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.spring.hibernate.entities.Article;
import pl.coderslab.spring.hibernate.repositories.ArticleRepository;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomePageController {

    private final ArticleRepository articleRepository;

    public HomePageController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping
    public String prepareHomePage(Model model) {
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "homepage";
    }

}
