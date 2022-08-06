package com.mistystrickland.helloworld;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
//@RestController
@Controller
public class HelloWorldApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(HelloWorldApplication.class, args);
//	}
//	
//	@RequestMapping("/hello")
//	public String hello() {
//		return "Hello World!";
//	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
    @RequestMapping("/dojos")
    public String index(Model model) {
        ArrayList<String> dojos = new ArrayList<String>();
        dojos.add("Burbank");
        dojos.add("Chicago");
        dojos.add("Bellevue");
        model.addAttribute("dojosFromMyController", dojos);
        return "index.jsp";
    }

}
