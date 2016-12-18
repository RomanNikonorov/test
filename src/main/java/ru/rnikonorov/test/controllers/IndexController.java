package ru.rnikonorov.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.rnikonorov.test.TestDB;
import ru.rnikonorov.test.service.TestService;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    TestService testService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<TestDB> testDBS = testService.findAll();
        if (testDBS == null) {
            model.addAttribute("error", "There's an error reading database. See log for details.");
        } else {
            model.addAttribute("error", null);
            model.addAttribute("test_table", testDBS);
        }


        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String indexFilter(String name, Model model) {
        List<TestDB> testDBS = testService.findByName(name);
        if (testDBS == null) {
            model.addAttribute("error", "There's an error reading database. See log for details.");
        } else {
            model.addAttribute("error", null);
            model.addAttribute("test_table", testDBS);
        }
        return "index";
    }
}
