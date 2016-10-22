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
import com.example.velocity.entity.AppUserRoles;
import com.example.velocity.repository.AppUserRolesRepository;

@Controller
@RequestMapping("/appUserRoles")
public class AppUserRolesController {

private static final Logger logger = LoggerFactory
.getLogger(AppUserRolesController.class);

private final AppUserRolesRepository appUserRolesRepository;

public AppUserRolesController(AppUserRolesRepository appUserRolesRepository) {
this.appUserRolesRepository = appUserRolesRepository;
}

@GetMapping
public ModelAndView list() {
Iterable<AppUserRoles> appUserRoless = this.appUserRolesRepository.findAll();
    return new ModelAndView("appUserRoless/list", "appUserRoless", appUserRoless);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") AppUserRoles appUserRoles) {
    logger.info(appUserRoles.toString());
    return new ModelAndView("appUserRoless/view", "appUserRoles", appUserRoles);
    }

    @GetMapping(params = "form")
    public String createForm(@ModelAttribute AppUserRoles appUserRoles) {
    return "appUserRoless/form";
    }

    @PostMapping
    public ModelAndView create(@Valid AppUserRoles appUserRoles, BindingResult result,
    RedirectAttributes redirect) {
    if (result.hasErrors()) {
    return new ModelAndView("appUserRoless/form", "formErrors", result.getAllErrors());
    }
    appUserRoles = this.appUserRolesRepository.save(appUserRoles);
    redirect.addFlashAttribute("globalAppUserRoles", "Successfully created a new appUserRoles");
    return new ModelAndView("redirect:/appUserRoles/{appUserRoles.id}", "appUserRoles.id", appUserRoles.getId());
    }

    @RequestMapping("foo")
    public String foo() {
    throw new RuntimeException("Expected exception in controller");
    }

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
    this.appUserRolesRepository.delete(id);
    Iterable<AppUserRoles> appUserRoless = this.appUserRolesRepository.findAll();
        return new ModelAndView("appUserRoless/list", "appUserRoless", appUserRoless);
        }

        @GetMapping(value = "modify/{id}")
        public ModelAndView modifyForm(@PathVariable("id") AppUserRoles appUserRoles) {
        return new ModelAndView("appUserRoless/form", "appUserRoles", appUserRoles);
        }

        }
