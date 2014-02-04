package com.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.model.Spittle;
import com.demo.service.SpitterService;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	
	@Autowired
	private SpitterService spitterService;

	@RequestMapping(value="/recent",method=RequestMethod.GET)
	public String listRecentSpittles(Model model){
		List<Spittle> spittleList = spitterService.getRecentSpittles(10);
		model.addAttribute("spittleList",spittleList);
		return "spittles/recent";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addNewSpittle(@RequestParam(value="spittleText")String spittleText, Principal principal){
		
		int success = spitterService.saveSpittle(spittleText, principal.getName());
		if(success!=0){
			return "redirect:welcome";
		}else{
			return "redirect:spittles/recent";
		}
		
		
	}
}
