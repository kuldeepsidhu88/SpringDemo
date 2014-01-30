package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.dao.SpitterDao;
import com.demo.model.Spitter;
import com.demo.model.Spittle;

@Component
public class SpitterService {
	
	@Autowired
	private SpitterDao spitterDao;
	
	public List<Spittle> getRecentSpittles(int noOfSpittles){
		return null;
	}
	
	public Spitter getSpitter(String username){
		Spitter spitter = null;
		try{
			spitter = spitterDao.getSpitter(username);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return spitter;
	}
	
	public List<Spittle> getSpittlesForSpitter(String username){
		List<Spittle> spittleList = null;
		try{
			spittleList = spitterDao.getSpittlesForSpitter(username);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return spittleList;
	}
	
	public int saveSpitter(Spitter spitter){
		try{
			spitterDao.saveSpitter(spitter);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return 0;
	}

}
