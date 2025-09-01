package com.example.springexception.controller;

import com.example.springexception.model.dto.ItemDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/items/new")
    public String addItem(@Valid @ModelAttribute("item") ItemDTO dto,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "validation/form"; // 에러 사항을 알아서 담아서 출력
        }
        return "redirect:/";
    }
}
