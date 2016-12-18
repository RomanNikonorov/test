package ru.rnikonorov.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rnikonorov.test.service.TestService;

import javax.management.MalformedObjectNameException;

@Controller
public class ResetController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "reset")
    public String reset(Model model) {
        boolean result = testService.reset();
        if (result != true) {
            model.addAttribute("error", "There's an error reading database. See log for details.");
        } else {
            model.addAttribute("error", null);
        }
        return "reset";
    }

}
