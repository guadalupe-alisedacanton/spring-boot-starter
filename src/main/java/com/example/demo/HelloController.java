package com.example.demo;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@Autowired
	private Main mainCode;
	
	/*@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	*/
//	@GetMapping("/")
//	public String intro() {
//		Main main = new Main();
//		Controller control = new Controller(main);
//		List<Movie> nowPlaying = main.setupNowPlayingList();
//		return "greeting";	
//	}
	
	@GetMapping("/nowPlaying")
	public String fetchNowPlayingList(Model model) {
		List<Movie> result = null;
		
		
		try {
			
			result = mainCode.setupNowPlayingList();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("This is result" + result);
		model.addAttribute("movies", result);
		
		return "nowPlaying";
	}
	
	@GetMapping("/upcoming")
	public String fetchUpcomingList() {
		List<Movie> result = null;
		try {
			result =  mainCode.setupUpcomingList();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "greeting";
	}
	
	

}