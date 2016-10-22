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
import com.example.velocity.entity.Artist;
import com.example.velocity.repository.ArtistRepository;

@Controller
@RequestMapping("/artist")
public class ArtistController {

private static final Logger logger = LoggerFactory
.getLogger(ArtistController.class);

private final ArtistRepository artistRepository;

public ArtistController(ArtistRepository artistRepository) {
this.artistRepository = artistRepository;
}

@GetMapping
public ModelAndView list() {
Iterable<Artist> artists = this.artistRepository.findAll();
    return new ModelAndView("artists/list", "artists", artists);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Artist artist) {
    logger.info(artist.toString());
    return new ModelAndView("artists/view", "artist", artist);
    }

    @GetMapping(params = "form")
    public String createForm(@ModelAttribute Artist artist) {
    return "artists/form";
    }

    @PostMapping
    public ModelAndView create(@Valid Artist artist, BindingResult result,
    RedirectAttributes redirect) {
    if (result.hasErrors()) {
    return new ModelAndView("artists/form", "formErrors", result.getAllErrors());
    }
    artist = this.artistRepository.save(artist);
    redirect.addFlashAttribute("globalArtist", "Successfully created a new artist");
    return new ModelAndView("redirect:/artist/{artist.id}", "artist.id", artist.getId());
    }

    @RequestMapping("foo")
    public String foo() {
    throw new RuntimeException("Expected exception in controller");
    }

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
    this.artistRepository.delete(id);
    Iterable<Artist> artists = this.artistRepository.findAll();
        return new ModelAndView("artists/list", "artists", artists);
        }

        @GetMapping(value = "modify/{id}")
        public ModelAndView modifyForm(@PathVariable("id") Artist artist) {
        return new ModelAndView("artists/form", "artist", artist);
        }

        }
