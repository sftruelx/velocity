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
import com.example.velocity.entity.Album;
import com.example.velocity.repository.AlbumRepository;

@Controller
@RequestMapping("/album")
public class AlbumController {

private static final Logger logger = LoggerFactory
.getLogger(AlbumController.class);

private final AlbumRepository albumRepository;

public AlbumController(AlbumRepository albumRepository) {
this.albumRepository = albumRepository;
}

@GetMapping
public ModelAndView list() {
Iterable<Album> albums = this.albumRepository.findAll();
    return new ModelAndView("albums/list", "albums", albums);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Album album) {
    logger.info(album.toString());
    return new ModelAndView("albums/view", "album", album);
    }

    @GetMapping(params = "form")
    public String createForm(@ModelAttribute Album album) {
    return "albums/form";
    }

    @PostMapping
    public ModelAndView create(@Valid Album album, BindingResult result,
    RedirectAttributes redirect) {
    if (result.hasErrors()) {
    return new ModelAndView("albums/form", "formErrors", result.getAllErrors());
    }
    album = this.albumRepository.save(album);
    redirect.addFlashAttribute("globalAlbum", "Successfully created a new album");
    return new ModelAndView("redirect:/album/{album.id}", "album.id", album.getId());
    }

    @RequestMapping("foo")
    public String foo() {
    throw new RuntimeException("Expected exception in controller");
    }

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
    this.albumRepository.delete(id);
    Iterable<Album> albums = this.albumRepository.findAll();
        return new ModelAndView("albums/list", "albums", albums);
        }

        @GetMapping(value = "modify/{id}")
        public ModelAndView modifyForm(@PathVariable("id") Album album) {
        return new ModelAndView("albums/form", "album", album);
        }

        }
