package ru.rnikonorov.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public String saveRecord(String name, Model model) {
        boolean result = testService.save(name);
        if (result != true) {
            model.addAttribute("error", "There's an error reading database. See log for details.");
            return "/new";
        } else {
            model.addAttribute("error", null);
            return "redirect:/";
        }
    }
}
