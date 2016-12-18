package ru.rnikonorov.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rnikonorov.test.TestDB;
import ru.rnikonorov.test.service.TestService;

@Controller
public class NewController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String show(){
        return "/new_record";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveRecord(String name) {
        testService.save(name);
        return "redirect:/";
    }
}
