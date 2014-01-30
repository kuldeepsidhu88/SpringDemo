package com.demo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.model.Spitter;
import com.demo.model.Spittle;


public interface SpitterDao {
	
	public List<Spittle> getRecentSpittles(int noOfSpittles);
	public Spitter getSpitter(String username);
	public List<Spittle> getSpittlesForSpitter(String username);
	public int saveSpitter(Spitter spitter);

}
