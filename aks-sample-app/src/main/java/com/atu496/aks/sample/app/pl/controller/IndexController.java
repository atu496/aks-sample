package com.atu496.aks.sample.app.pl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        log.info("IndexController!!!!!");
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(path = "/service1", method = { RequestMethod.GET, RequestMethod.POST })
    public String getAksSampleService(RedirectAttributes ra) {

        log.info(service.getAksSampleService().toString());
        log.info(service.postAksSampleService().toString());
        ra.addFlashAttribute("getRes1", service.getAksSampleService().getBody());
        ra.addFlashAttribute("postRes1", service.postAksSampleService().getBody());

        return "redirect:/";
    }

    @RequestMapping(path = "/service2", method = { RequestMethod.GET, RequestMethod.POST })
    public String getAksSampleService2(RedirectAttributes ra) {

        log.info(service.getAksSampleService2().toString());
        log.info(service.postAksSampleService2().toString());
        ra.addFlashAttribute("getRes2", service.getAksSampleService2().getBody());
        ra.addFlashAttribute("postRes2", service.postAksSampleService2().getBody());

        return "redirect:/";
    }

    @RequestMapping(path = "/service3", method = { RequestMethod.GET, RequestMethod.POST })
    public String getAksSampleService3(RedirectAttributes ra) {

        log.info(service.getAksSampleService3().toString());
        log.info(service.postAksSampleService3().toString());
        ra.addFlashAttribute("getRes3", service.getAksSampleService3().getBody());
        ra.addFlashAttribute("postRes3", service.postAksSampleService3().getBody());

        return "redirect:/";
    }

    @RequestMapping(path = "/all", method = { RequestMethod.GET, RequestMethod.POST })
    public String all(RedirectAttributes ra) {
        log.info(service.getAksSampleService().toString());
        log.info(service.postAksSampleService().toString());
        log.info(service.getAksSampleService2().toString());
        log.info(service.postAksSampleService2().toString());
        log.info(service.getAksSampleService3().toString());
        log.info(service.postAksSampleService3().toString());

        ra.addFlashAttribute("getRes1", service.getAksSampleService().getBody());
        ra.addFlashAttribute("postRes1", service.postAksSampleService().getBody());

        ra.addFlashAttribute("getRes2", service.getAksSampleService2().getBody());
        ra.addFlashAttribute("postRes2", service.postAksSampleService2().getBody());

        ra.addFlashAttribute("getRes3", service.getAksSampleService3().getBody());
        ra.addFlashAttribute("postRes3", service.postAksSampleService3().getBody());
        return "redirect:/";

    }
}
