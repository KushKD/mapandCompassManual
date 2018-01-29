package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getHome(){
		return "index";     //testing
	}
	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String getAbout(){
		return "about";
	}
	
	
	
	@RequestMapping(value="/team", method=RequestMethod.GET)
	public String getTeam(){
		return "team";
	}
	
	@RequestMapping(value="/gallery", method=RequestMethod.GET)
	public String getGallery(){
		return "gallery";
	}
	
	
	

}
