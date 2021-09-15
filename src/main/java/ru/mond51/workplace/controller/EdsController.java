package ru.mond51.workplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eds")
public class EdsController {

    @GetMapping
    public String edsTable(Model model) {
        return  "edsTable";
    }
}
