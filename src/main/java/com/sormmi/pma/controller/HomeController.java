package com.sormmi.pma.controller;

import com.sormmi.pma.repository.EmployeeRepository;
import com.sormmi.pma.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("employees", employeeRepository.findAll());
        return "home";
    }
}
