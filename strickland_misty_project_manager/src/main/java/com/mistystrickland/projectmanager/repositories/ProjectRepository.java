package com.mistystrickland.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mistystrickland.projectmanager.models.Project;
import com.mistystrickland.projectmanager.models.User;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	List<Project> findAll();
	
	List<Project> findAllByUsers(User user);
}
