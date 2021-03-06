package ru.mond51.workplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mond51.workplace.model.Eds;
import ru.mond51.workplace.repository.EdsRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/eds")
public class EdsController {

    private EdsRepository edsRepository;

    public EdsController(EdsRepository edsRepository) {
        this.edsRepository = edsRepository;
    }

    @GetMapping
    public String edsTable(Model model) {
        model.addAttribute("eds", edsRepository.findAllByOrderByActiveDescExpirationDateAsc());

        return  "eds/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        edsRepository.deleteById(id);

        return "redirect:/eds";
    }

    @GetMapping("/deactivate/{id}")
    public String deactivate(@PathVariable Long id) {
        Eds edsToEdit = edsRepository.findById(id).get();
        edsToEdit.setActive(false);
        edsToEdit.setComment("Срок действия истек");
        edsRepository.save(edsToEdit);

        return "redirect:/eds";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("eds", new Eds());
        model.addAttribute("action", "create");

        return "eds/form";
    }

    @PostMapping("/create")
    public String save(@Valid Eds eds, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("action", "create");
            return "eds/form";
        }

        edsRepository.save(eds);
        return "redirect:/eds";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Eds edsToEdit = edsRepository.findById(id).get();
        model.addAttribute("eds", edsToEdit);

        return "eds/form";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid Eds eds, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "eds/form";
        }

        edsRepository.save(eds);
        return "redirect:/eds";
    }
}
