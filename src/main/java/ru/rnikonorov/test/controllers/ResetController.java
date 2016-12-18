package ru.rnikonorov.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rnikonorov.test.service.TestService;

@Controller
public class ResetController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "reset")
    public String reset() {
        testService.reset();
        return "reset";
    }

}
