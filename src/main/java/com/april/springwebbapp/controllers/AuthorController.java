package com.april.springwebbapp.controllers;

import com.april.springwebbapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){

        model.addAttribute("authors", authorRepository.findAll());
        return "authors/list";
    }

}
/*
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Cameron's Pictures</title>
</head>
<body>

</body>
<div style="...">
    <h1>Picture List</h1>
    table align="center".
    <tr>
        <th>ID</th>
        <th>Photographer</th>
        <th>Price</th>
        <th>Quantity</th>
    </tr>
    <tr th:each="book : ${books}">
        <td th:text="${book.id}">123</td>
        <td th:text="${book.title}">Spring into Action</td>
        <td th:text="${book.publisher.publisherName}">Wrox</td>

    </tr>
    </table>
</div>
</html>
 */