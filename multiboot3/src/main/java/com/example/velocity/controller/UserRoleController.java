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
import com.example.velocity.entity.UserRole;
import com.example.velocity.repository.UserRoleRepository;

@Controller
@RequestMapping("/userRole")
public class UserRoleController {

private static final Logger logger = LoggerFactory
.getLogger(UserRoleController.class);

private final UserRoleRepository userRoleRepository;

public UserRoleController(UserRoleRepository userRoleRepository) {
this.userRoleRepository = userRoleRepository;
}

@GetMapping
public ModelAndView list() {
Iterable<UserRole> userRoles = this.userRoleRepository.findAll();
    return new ModelAndView("userRoles/list", "userRoles", userRoles);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") UserRole userRole) {
    logger.info(userRole.toString());
    return new ModelAndView("userRoles/view", "userRole", userRole);
    }

    @GetMapping(params = "form")
    public String createForm(@ModelAttribute UserRole userRole) {
    return "userRoles/form";
    }

    @PostMapping
    public ModelAndView create(@Valid UserRole userRole, BindingResult result,
    RedirectAttributes redirect) {
    if (result.hasErrors()) {
    return new ModelAndView("userRoles/form", "formErrors", result.getAllErrors());
    }
    userRole = this.userRoleRepository.save(userRole);
    redirect.addFlashAttribute("globalUserRole", "Successfully created a new userRole");
    return new ModelAndView("redirect:/userRole/{userRole.id}", "userRole.id", userRole.getId());
    }

    @RequestMapping("foo")
    public String foo() {
    throw new RuntimeException("Expected exception in controller");
    }

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
    this.userRoleRepository.delete(id);
    Iterable<UserRole> userRoles = this.userRoleRepository.findAll();
        return new ModelAndView("userRoles/list", "userRoles", userRoles);
        }

        @GetMapping(value = "modify/{id}")
        public ModelAndView modifyForm(@PathVariable("id") UserRole userRole) {
        return new ModelAndView("userRoles/form", "userRole", userRole);
        }

        }
