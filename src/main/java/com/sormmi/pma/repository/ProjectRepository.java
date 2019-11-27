package com.sormmi.pma.repository;

import com.sormmi.pma.dto.ProjectStatus;
import com.sormmi.pma.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Query(nativeQuery = true,
            value = "SELECT stage as label, COUNT(*) as value FROM PROJECT GROUP BY stage")
    List<ProjectStatus> projectStatus();
}
