package com.sormmi.pma.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "project_employee",
            joinColumns = @JoinColumn(name="employee_id"),
            inverseJoinColumns = @JoinColumn(name="project_id")
    )
    private Set<Project> projects;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void addProject(Project project) {
        if (projects == null) {
            projects = new HashSet<>();
        }
        projects.add(project);
    }
}
