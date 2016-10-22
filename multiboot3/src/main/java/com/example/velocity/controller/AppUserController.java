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
import com.example.velocity.entity.AppUser;
import com.example.velocity.repository.AppUserRepository;

@Controller
@RequestMapping("/appUser")
public class AppUserController {

private static final Logger logger = LoggerFactory
.getLogger(AppUserController.class);

private final AppUserRepository appUserRepository;

public AppUserController(AppUserRepository appUserRepository) {
this.appUserRepository = appUserRepository;
}

@GetMapping
public ModelAndView list() {
Iterable<AppUser> appUsers = this.appUserRepository.findAll();
    return new ModelAndView("appUsers/list", "appUsers", appUsers);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") AppUser appUser) {
    logger.info(appUser.toString());
    return new ModelAndView("appUsers/view", "appUser", appUser);
    }

    @GetMapping(params = "form")
    public String createForm(@ModelAttribute AppUser appUser) {
    return "appUsers/form";
    }

    @PostMapping
    public ModelAndView create(@Valid AppUser appUser, BindingResult result,
    RedirectAttributes redirect) {
    if (result.hasErrors()) {
    return new ModelAndView("appUsers/form", "formErrors", result.getAllErrors());
    }
    appUser = this.appUserRepository.save(appUser);
    redirect.addFlashAttribute("globalAppUser", "Successfully created a new appUser");
    return new ModelAndView("redirect:/appUser/{appUser.id}", "appUser.id", appUser.getId());
    }

    @RequestMapping("foo")
    public String foo() {
    throw new RuntimeException("Expected exception in controller");
    }

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
    this.appUserRepository.delete(id);
    Iterable<AppUser> appUsers = this.appUserRepository.findAll();
        return new ModelAndView("appUsers/list", "appUsers", appUsers);
        }

        @GetMapping(value = "modify/{id}")
        public ModelAndView modifyForm(@PathVariable("id") AppUser appUser) {
        return new ModelAndView("appUsers/form", "appUser", appUser);
        }

        }
