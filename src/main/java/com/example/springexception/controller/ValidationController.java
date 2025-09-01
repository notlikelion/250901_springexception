package com.example.springexception.controller;

import com.example.springexception.model.dto.ItemDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/validation") // prefix - 접두어
public class ValidationController {
    @GetMapping("/items/new")
    public String itemForm(Model model) {
        // th:object
        model.addAttribute("item", new ItemDTO());
        return "validation/form";
    }
}
