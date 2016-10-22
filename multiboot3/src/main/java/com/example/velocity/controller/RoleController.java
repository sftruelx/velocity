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
import com.example.velocity.entity.Role;
import com.example.velocity.repository.RoleRepository;

@Controller
@RequestMapping("/role")
public class RoleController {

private static final Logger logger = LoggerFactory
.getLogger(RoleController.class);

private final RoleRepository roleRepository;

public RoleController(RoleRepository roleRepository) {
this.roleRepository = roleRepository;
}

@GetMapping
public ModelAndView list() {
Iterable<Role> roles = this.roleRepository.findAll();
    return new ModelAndView("roles/list", "roles", roles);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Role role) {
    logger.info(role.toString());
    return new ModelAndView("roles/view", "role", role);
    }

    @GetMapping(params = "form")
    public String createForm(@ModelAttribute Role role) {
    return "roles/form";
    }

    @PostMapping
    public ModelAndView create(@Valid Role role, BindingResult result,
    RedirectAttributes redirect) {
    if (result.hasErrors()) {
    return new ModelAndView("roles/form", "formErrors", result.getAllErrors());
    }
    role = this.roleRepository.save(role);
    redirect.addFlashAttribute("globalRole", "Successfully created a new role");
    return new ModelAndView("redirect:/role/{role.id}", "role.id", role.getId());
    }

    @RequestMapping("foo")
    public String foo() {
    throw new RuntimeException("Expected exception in controller");
    }

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
    this.roleRepository.delete(id);
    Iterable<Role> roles = this.roleRepository.findAll();
        return new ModelAndView("roles/list", "roles", roles);
        }

        @GetMapping(value = "modify/{id}")
        public ModelAndView modifyForm(@PathVariable("id") Role role) {
        return new ModelAndView("roles/form", "role", role);
        }

        }
