package com.mistystrickland.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/your_server")
		public String setCount(HttpSession session) {
		
			// Check if count is in the session
			if (session.getAttribute("count") == null) {
					// if not, create count and set to 0
					session.setAttribute("count", 0); }
			
			// Grab the count from the session and cast it into the right datatype
			Integer tempCount = (Integer) session.getAttribute("count");
			
			// Increment in the temp variable
			tempCount++;
			
			// Set the session with the new temp
			session.setAttribute("count", tempCount);
			// Increment the count in session
			
			return "welcome.jsp";
		}
	
	@GetMapping("/your_server/counter")
		public String getCount() {
		return "counter.jsp";
	}
	
	@GetMapping("/your_server/double")
		public String doubleCount(HttpSession session) {
		
			if (session.getAttribute("count") == null) {
				session.setAttribute("count", 0);
			}
			Integer tempCount = (Integer) session.getAttribute("count");
			tempCount +=2; // the only difference is to increment by 2
			session.setAttribute("count", tempCount);
			
			return "double.jsp";
	}
}
