package com.sormmi.pma.repository;

import com.sormmi.pma.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
