package com.mkalisvaart.spring5webapp.controllers;

import com.mkalisvaart.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private AuthorRepository repository;
    
    public AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }
    
    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", repository.findAll());
        return "authors";
    }
}
