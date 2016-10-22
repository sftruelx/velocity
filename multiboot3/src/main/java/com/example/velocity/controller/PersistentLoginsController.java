package com.example.velocity.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.velocity.entity.PersistentLogins;
import com.example.velocity.repository.PersistentLoginsRepository;

@Controller
@RequestMapping("/persistentLogins")
public class PersistentLoginsController {

private static final Logger logger = LoggerFactory
.getLogger(PersistentLoginsController.class);

private final PersistentLoginsRepository persistentLoginsRepository;

public PersistentLoginsController(PersistentLoginsRepository persistentLoginsRepository) {
this.persistentLoginsRepository = persistentLoginsRepository;
}

@GetMapping
public ModelAndView list() {
Iterable<PersistentLogins> persistentLoginss = this.persistentLoginsRepository.findAll();
    return new ModelAndView("persistentLoginss/list", "persistentLoginss", persistentLoginss);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") PersistentLogins persistentLogins) {
    logger.info(persistentLogins.toString());
    return new ModelAndView("persistentLoginss/view", "persistentLogins", persistentLogins);
    }

    @GetMapping(params = "form")
    public String createForm(@ModelAttribute PersistentLogins persistentLogins) {
    return "persistentLoginss/form";
    }

    @PostMapping
    public ModelAndView create(@Valid PersistentLogins persistentLogins, BindingResult result,
    RedirectAttributes redirect) {
    if (result.hasErrors()) {
    return new ModelAndView("persistentLoginss/form", "formErrors", result.getAllErrors());
    }
    persistentLogins = this.persistentLoginsRepository.save(persistentLogins);
    redirect.addFlashAttribute("globalPersistentLogins", "Successfully created a new persistentLogins");
    return new ModelAndView("redirect:/persistentLogins/{persistentLogins.id}", "persistentLogins.id", persistentLogins.getId());
    }

    @RequestMapping("foo")
    public String foo() {
    throw new RuntimeException("Expected exception in controller");
    }

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
    this.persistentLoginsRepository.delete(id);
    Iterable<PersistentLogins> persistentLoginss = this.persistentLoginsRepository.findAll();
        return new ModelAndView("persistentLoginss/list", "persistentLoginss", persistentLoginss);
        }

        @GetMapping(value = "modify/{id}")
        public ModelAndView modifyForm(@PathVariable("id") PersistentLogins persistentLogins) {
        return new ModelAndView("persistentLoginss/form", "persistentLogins", persistentLogins);
        }

        }
