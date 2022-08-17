package com.mistystrickland.projectmanager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mistystrickland.projectmanager.models.LoginUser;
import com.mistystrickland.projectmanager.models.Project;
import com.mistystrickland.projectmanager.models.User;
import com.mistystrickland.projectmanager.services.ProjectService;
import com.mistystrickland.projectmanager.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	// -----------------------LOGIN-------------------------------------
	
	@GetMapping("/")
	public String loginPage(Model model) {
		// Create an empty User object in the jsp to capture form input
		model.addAttribute("newUser", new User());
		// Create an empty LoginUser object in the jsp to capture form input
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}
	
	@PostMapping("/register")
	public String processRegistration(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, 
			Model model, HttpSession session) {
		
		userService.register(newUser, result);
		if (result.hasErrors()) {
			// the newUser is already there, so send in empty LoginUser object to re-render the page correctly
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		}
		session.setAttribute("userId", newUser.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, 
			Model model, HttpSession session) {
		
		User user = userService.login(newLogin, result);
		if (result.hasErrors()) {
			// the newLogin is already there, so send in empty User object to re-render the page correctly
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// -----------------------DASHBOARD-------------------------------------
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		
		// Cast userId that's in session as Long datatype
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("currUser", userService.findById(userId));
		
		List<Project> projectList = projectService.allProjects();
		model.addAttribute("projectList", projectList);
		
//		List<Project> myProjectList = projectService.findMyProjects(userId)
		
		return "dashboard.jsp";
	}
	
	// -----------------------CREATE NEW PROJECT-------------------------------------
	
	@GetMapping("/projects/new")
	public String createPage(HttpSession session, @ModelAttribute("project") Project project) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		return "create.jsp";
	}
	
	@PostMapping("/projects/new")
	public String processCreate(@Valid @ModelAttribute("project") Project project, BindingResult result, 
			HttpSession session, Model model) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			return "create.jsp";
		} else {
			projectService.saveProject(project);
			return "redirect:/dashboard";
		}
	}
	
	// -----------------------ONE PROJECT-------------------------------------
	
	@GetMapping("/projects/{id}")
	public String detailsPage(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		model.addAttribute("project", projectService.oneProject(id));
		return "details.jsp";
	}
	
	// -----------------------DELETE PROJECT-------------------------------------
	
	@DeleteMapping("/projects/delete/{id}")
	public String deleteProject(@PathVariable("id") Long id, @Valid @ModelAttribute("project") Project project, 
			BindingResult result, HttpSession session) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		// Ensure that ONLY the user -> (lead) that created the project can delete it
		Project myProject = projectService.oneProject(id);
		if (myProject.getLead().getId() != (Long) session.getAttribute("userId")) {
			return "redirect:/dashboard";
		}
		projectService.deleteProject(id);
		return "redirect:/dashboard";
	}
	
	// -----------------------EDIT PROJECT-------------------------------------
	
	@GetMapping("/projects/edit/{id}")
	public String editPage(@PathVariable("id") Long id, HttpSession session, Model model) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		// Ensure that ONLY the user -> (lead) that created the project can edit it
		Project project = projectService.oneProject(id);
		if (project.getLead().getId() != (Long) session.getAttribute("userId")) {
			return "redirect:/dashboard";
		}
		
		model.addAttribute("project", projectService.oneProject(id));
		return "edit.jsp";
	}
	
	@PutMapping("/projects/edit/{id}")
	public String processEdit(@PathVariable("id") Long id, @Valid @ModelAttribute("project") Project project, 
			BindingResult result, HttpSession session) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			projectService.saveProject(project);
			return "redirect:/dashboard";
		}
	}
	
	// -----------------------JOIN PROJECT-------------------------------------
	
	@PutMapping("/project/join/{id}")
	public String joinProject(@PathVariable("id") Long projectId, HttpSession session) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		projectService.joinProject(projectId, userId);
		return "redirect:/dashboard";
	}
	
	// -----------------------LEAVE PROJECT-------------------------------------
	
	@PutMapping("/project/leave/{id}")
	public String leaveProject(@PathVariable("id") Long projectId, HttpSession session) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		projectService.leaveProject(projectId, userId);
		return "redirect:/dashboard";
	}

}
