package flow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import flow.entities.Window;
import flow.repositories.WindowRepository;

@Controller
@ExposesResourceFor(Window.class)
@RequestMapping("/window/{id}")
public class WindowController {
	
	@Autowired
	private WindowRepository repo; 
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody Window getWindow(@PathVariable("id") String id) {
		
		Window w =  repo.findOne(Long.valueOf(id));
		System.out.println(w.toString());
		
		return w;
	}	
}
