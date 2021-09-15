package ru.mond51.workplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mond51.workplace.repository.EdsRepository;

@Controller
@RequestMapping("/eds")
public class EdsController {

    private EdsRepository edsRepository;

    public EdsController(EdsRepository edsRepository) {
        this.edsRepository = edsRepository;
    }

    @GetMapping
    public String edsTable(Model model) {
        model.addAttribute("eds", edsRepository.findAll());

        return  "edsTable";
    }
}
