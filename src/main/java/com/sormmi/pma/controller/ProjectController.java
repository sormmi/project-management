package com.sormmi.pma.controller;

import com.sormmi.pma.entity.Project;
import com.sormmi.pma.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping
    public String fetchAll(Model model) {
        model.addAttribute("projects", projectRepository.findAll());
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        var project = new Project();
        model.addAttribute("project", project);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project) {
        projectRepository.save(project);
        return "redirect:/projects";
    }
}
