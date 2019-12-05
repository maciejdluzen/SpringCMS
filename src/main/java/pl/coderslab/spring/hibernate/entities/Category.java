package pl.coderslab.spring.hibernate.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    // ENTITIES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Size(max = 100)
    @Column(nullable = false)
    private String name;

    private String description;

    // RELATIONS

    @ManyToMany(mappedBy = "categories")
    private List<Article> articles = new ArrayList<>();

    // CONSTRUCTOR

    public Category() {
    }

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
