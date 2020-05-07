package com.atu496.aks.sample.app.pl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atu496.aks.sample.app.domain.service.SampleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    SampleService service;

    @GetMapping("/")
    public ModelAndView get(ModelAndView mav) {

        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/all")
    public String all(RedirectAttributes ra) {
        log.info(service.getAksSampleService().toString());
        log.info(service.postAksSampleService().toString());

        log.info(service.getAksSampleService2().toString());
        log.info(service.postAksSampleService2().toString());

        log.info(service.getAksSampleService3().toString());
        log.info(service.postAksSampleService3().toString());

        ra.addFlashAttribute("getRes1", service.getAksSampleService().toString());
        ra.addFlashAttribute("getRes2", service.postAksSampleService().toString());
        ra.addFlashAttribute("getRes3", service.getAksSampleService2().toString());
        ra.addFlashAttribute("postRes1", service.postAksSampleService2().toString());
        ra.addFlashAttribute("postRes2", service.getAksSampleService3().toString());
        ra.addFlashAttribute("postRes3", service.postAksSampleService3().toString());
        return "redirect:/";

    }
}
