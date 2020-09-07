package com.april.springwebbapp.controllers;

import com.april.springwebbapp.repositories.AuthorRepository;
import com.april.springwebbapp.repositories.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublisherController {

    private final PublisherRepository publisherRepository;


    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @RequestMapping("/publishers")
    public String getAuthors(Model model){

        model.addAttribute("publishers", publisherRepository.findAll());

        return "publishers/list";
    }
}