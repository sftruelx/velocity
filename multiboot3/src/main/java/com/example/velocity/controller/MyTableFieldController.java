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
import com.example.velocity.entity.MyTableField;
import com.example.velocity.repository.MyTableFieldRepository;

@Controller
@RequestMapping("/myTableField")
public class MyTableFieldController {

private static final Logger logger = LoggerFactory
.getLogger(MyTableFieldController.class);

private final MyTableFieldRepository myTableFieldRepository;

public MyTableFieldController(MyTableFieldRepository myTableFieldRepository) {
this.myTableFieldRepository = myTableFieldRepository;
}

@GetMapping
public ModelAndView list() {
Iterable<MyTableField> myTableFields = this.myTableFieldRepository.findAll();
    return new ModelAndView("myTableFields/list", "myTableFields", myTableFields);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") MyTableField myTableField) {
    logger.info(myTableField.toString());
    return new ModelAndView("myTableFields/view", "myTableField", myTableField);
    }

    @GetMapping(params = "form")
    public String createForm(@ModelAttribute MyTableField myTableField) {
    return "myTableFields/form";
    }

    @PostMapping
    public ModelAndView create(@Valid MyTableField myTableField, BindingResult result,
    RedirectAttributes redirect) {
    if (result.hasErrors()) {
    return new ModelAndView("myTableFields/form", "formErrors", result.getAllErrors());
    }
    myTableField = this.myTableFieldRepository.save(myTableField);
    redirect.addFlashAttribute("globalMyTableField", "Successfully created a new myTableField");
    return new ModelAndView("redirect:/myTableField/{myTableField.id}", "myTableField.id", myTableField.getId());
    }

    @RequestMapping("foo")
    public String foo() {
    throw new RuntimeException("Expected exception in controller");
    }

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
    this.myTableFieldRepository.delete(id);
    Iterable<MyTableField> myTableFields = this.myTableFieldRepository.findAll();
        return new ModelAndView("myTableFields/list", "myTableFields", myTableFields);
        }

        @GetMapping(value = "modify/{id}")
        public ModelAndView modifyForm(@PathVariable("id") MyTableField myTableField) {
        return new ModelAndView("myTableFields/form", "myTableField", myTableField);
        }

        }
