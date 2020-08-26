package com.subscriptio.main.repositories;

import com.subscriptio.main.models.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProjectRepository extends CrudRepository<Project, UUID> {

    @Query("SELECT p FROM Project p LEFT JOIN p.campaigns WHERE p.id = (:id)")
    Project findByIdAndFetchCampaignsEagerly(@Param("id") UUID id);
}
