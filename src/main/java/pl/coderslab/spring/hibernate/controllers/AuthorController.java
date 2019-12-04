package pl.coderslab.spring.hibernate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.spring.hibernate.entities.Author;
import pl.coderslab.spring.hibernate.repositories.AuthorDao;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping
    public String prepareAllAuthorsPage(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "all-authors";
    }

    @GetMapping("/create")
    public String prepareCreateAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "add-author";
    }

    @PostMapping("/create")
    public String processCreateAuthorForm(@ModelAttribute Author author) {

        authorDao.create(author);
        return "redirect:/authors";
    }
    
    
    
    
    
    
    
    
    
}
