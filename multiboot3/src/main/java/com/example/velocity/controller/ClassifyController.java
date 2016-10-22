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
import com.example.velocity.entity.Classify;
import com.example.velocity.repository.ClassifyRepository;

@Controller
@RequestMapping("/classify")
public class ClassifyController {

private static final Logger logger = LoggerFactory
.getLogger(ClassifyController.class);

private final ClassifyRepository classifyRepository;

public ClassifyController(ClassifyRepository classifyRepository) {
this.classifyRepository = classifyRepository;
}

@GetMapping
public ModelAndView list() {
Iterable<Classify> classifys = this.classifyRepository.findAll();
    return new ModelAndView("classifys/list", "classifys", classifys);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Classify classify) {
    logger.info(classify.toString());
    return new ModelAndView("classifys/view", "classify", classify);
    }

    @GetMapping(params = "form")
    public String createForm(@ModelAttribute Classify classify) {
    return "classifys/form";
    }

    @PostMapping
    public ModelAndView create(@Valid Classify classify, BindingResult result,
    RedirectAttributes redirect) {
    if (result.hasErrors()) {
    return new ModelAndView("classifys/form", "formErrors", result.getAllErrors());
    }
    classify = this.classifyRepository.save(classify);
    redirect.addFlashAttribute("globalClassify", "Successfully created a new classify");
    return new ModelAndView("redirect:/classify/{classify.id}", "classify.id", classify.getId());
    }

    @RequestMapping("foo")
    public String foo() {
    throw new RuntimeException("Expected exception in controller");
    }

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
    this.classifyRepository.delete(id);
    Iterable<Classify> classifys = this.classifyRepository.findAll();
        return new ModelAndView("classifys/list", "classifys", classifys);
        }

        @GetMapping(value = "modify/{id}")
        public ModelAndView modifyForm(@PathVariable("id") Classify classify) {
        return new ModelAndView("classifys/form", "classify", classify);
        }

        }
