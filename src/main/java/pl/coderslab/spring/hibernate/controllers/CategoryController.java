package pl.coderslab.spring.hibernate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.spring.hibernate.entities.Author;
import pl.coderslab.spring.hibernate.entities.Category;
import pl.coderslab.spring.hibernate.repositories.CategoryDao;

import javax.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping
    public String prepareAllCategoriesPage(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        return "all-categories";
    }

    @GetMapping("/create")
    public String prepareCreateCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "add-category";
    }

    @PostMapping("/create")
    public String processCreateCategoryForm(@ModelAttribute Category category) {

        categoryDao.create(category);
        return "redirect:/categories";
    }

}
