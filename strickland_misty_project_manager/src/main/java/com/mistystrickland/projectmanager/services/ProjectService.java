package com.mistystrickland.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistystrickland.projectmanager.models.Project;
import com.mistystrickland.projectmanager.models.User;
import com.mistystrickland.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private UserService userService;

	// Create & Update (since they both do the same thing)
	public Project saveProject(Project project) {
		return projectRepo.save(project);
	}
	
	// Find All Projects
	public List<Project> allProjects(){
		return projectRepo.findAll();
	}
	
	// Find One Project
	public Project oneProject(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if (optionalProject.isPresent()) {
			return optionalProject.get();
		} else {
			return null;
		}
	}
	
	// Delete One Project
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}
	
	// This adds a user to a project in the middle table
	public void joinProject(Long projectId, Long userId) {
		User user = userService.findById(userId);
		Project project = this.oneProject(projectId);
		project.getUsers().add(user);
		projectRepo.save(project);
	}
	
	// This removes a user from a project in the middle table
	public void leaveProject(Long projectId, Long userId) {
		User user = userService.findById(userId);
		Project project = this.oneProject(projectId);
		project.getUsers().remove(user);
		projectRepo.save(project);
	}
	
	
	
	
	
	
	
	
	
	
	
	// Not Quite Right
//	public List<Project> joinedProjects(Long userId){
//		return projectRepo.
//	}
	
//	public List<Project> findMyProjects(User user){
//		return projectRepo.findAllByUsers(user);
//	}
	
	// Add a User to a Project
//	public Project addUserToProject(Project project) {
//		return projectRepo.save(project);
//	}
}
