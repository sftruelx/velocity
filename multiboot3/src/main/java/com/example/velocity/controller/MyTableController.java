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
import com.example.velocity.entity.MyTable;
import com.example.velocity.repository.MyTableRepository;

@Controller
@RequestMapping("/myTable")
public class MyTableController {

private static final Logger logger = LoggerFactory
.getLogger(MyTableController.class);

private final MyTableRepository myTableRepository;

public MyTableController(MyTableRepository myTableRepository) {
this.myTableRepository = myTableRepository;
}

@GetMapping
public ModelAndView list() {
Iterable<MyTable> myTables = this.myTableRepository.findAll();
    return new ModelAndView("myTables/list", "myTables", myTables);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") MyTable myTable) {
    logger.info(myTable.toString());
    return new ModelAndView("myTables/view", "myTable", myTable);
    }

    @GetMapping(params = "form")
    public String createForm(@ModelAttribute MyTable myTable) {
    return "myTables/form";
    }

    @PostMapping
    public ModelAndView create(@Valid MyTable myTable, BindingResult result,
    RedirectAttributes redirect) {
    if (result.hasErrors()) {
    return new ModelAndView("myTables/form", "formErrors", result.getAllErrors());
    }
    myTable = this.myTableRepository.save(myTable);
    redirect.addFlashAttribute("globalMyTable", "Successfully created a new myTable");
    return new ModelAndView("redirect:/myTable/{myTable.id}", "myTable.id", myTable.getId());
    }

    @RequestMapping("foo")
    public String foo() {
    throw new RuntimeException("Expected exception in controller");
    }

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
    this.myTableRepository.delete(id);
    Iterable<MyTable> myTables = this.myTableRepository.findAll();
        return new ModelAndView("myTables/list", "myTables", myTables);
        }

        @GetMapping(value = "modify/{id}")
        public ModelAndView modifyForm(@PathVariable("id") MyTable myTable) {
        return new ModelAndView("myTables/form", "myTable", myTable);
        }

        }
