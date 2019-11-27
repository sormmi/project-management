package com.sormmi.pma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public String home(Model model) throws JsonProcessingException {

        var chartData = projectRepository.projectStatus();
        
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(chartData);

        model.addAttribute("projectStatus", json);
        model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("employeeProjects", employeeRepository.employeeProjects());

        return "home";
    }
}
