package com.demo.controller;

import java.io.File;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.demo.constants.SpitterConstants;
import com.demo.model.Spitter;
import com.demo.model.Spittle;
import com.demo.service.SpitterService;

@Controller
@RequestMapping("/spitters")
public class SpitterController {
	
	@Autowired
	private SpitterService spitterService;

	@RequestMapping(value="/spittles",method=RequestMethod.GET)
	public String listSpittlesForSpitter(@RequestParam("spitter")String username,Model model){
		
		// TO DO
		// get spittles for user
		List<Spittle> spittleList = spitterService.getSpittlesForSpitter(username);
		model.addAttribute("username",username);
		model.addAttribute("spittleList",spittleList);
		return "spittles/list";
	}
	
	@RequestMapping(method=RequestMethod.GET,params="new")
	public String createSpitterProfile(Model model){
		model.addAttribute(new Spitter());
		return "spitters/register";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/new")
	public String createNewSpitterProfile(Model model){
		model.addAttribute(new Spitter());
		return "spitters/register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addSpitterFromForm(@Valid Spitter spitter,BindingResult bindingResult,@RequestParam(value="image", required=false)MultipartFile image){
		
		if(bindingResult.hasErrors()){
			return "spitters/register";
		}
		
		// save spitter in db
		spitterService.saveSpitter(spitter);
		try {
			if(null!=image && !image.isEmpty()){
				validateImage(image);
				saveImage(spitter.getUsername()+".jpg",image);
			}
		} catch (Exception e) {
			bindingResult.reject("IMG_NOT_VALID",e.getMessage());
			return "spitters/register";
		}
		
		return "redirect:/spitters/"+spitter.getUsername();
	}
	
	@Secured("ROLE_SPITTER")
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username, Model model){
		
		//TO DO : get spitter from db
		/*Spitter spitter = new Spitter();
		spitter.setEmail("dummy@dummy.com");
		spitter.setFullName("Spitter");
		spitter.setUsername("spitter");*/
		Spitter spitter = spitterService.getSpitter(username);
		if(null!=spitter)
			spitter.setProfileImageUrl(getProfileImage(username));
		model.addAttribute(spitter);
		return "spitters/profile";
	}
	
	private void validateImage(MultipartFile image) throws Exception{
		if(!image.getContentType().equals("image/jpeg")){
			throw new Exception("Only JPG images accepted");
		}
	}
	
	private void saveImage(String filename,MultipartFile image) throws Exception{
		try{
			File file = new File(SpitterConstants.IMAGE_PATH+filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			
		}
		catch(Exception e){
			throw new Exception("Unable to save image");
		}
	}
	
	private String getProfileImage(String username){
		File file = new File(SpitterConstants.IMAGE_PATH+username+".jpg");
		if (file.exists())
			return file.getPath();
		else
			return null;
	}
}
