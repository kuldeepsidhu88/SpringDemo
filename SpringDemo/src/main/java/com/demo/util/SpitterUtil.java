package com.demo.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import com.demo.constants.SpitterConstants;
import com.demo.model.Spittle;

public class SpitterUtil {
	
	public static List<Spittle> getSpittleList(List<Map<String, Object>> rows){
		List<Spittle> spittleList = new ArrayList<>();
		for(Map<String,Object> row:rows){
			Spittle spittle = new Spittle();
			spittle.setId(Integer.parseInt(row.get("spittle_id").toString()));
			spittle.setText(row.get("text").toString());
			spittle.setCreatedAt(row.get("created_at").toString());
			spittle.setUsername(row.get("username").toString());
			spittleList.add(spittle);
		}
		return spittleList;
	}

	public static void saveImage(String filename,MultipartFile image) throws Exception{
		try{
			File file = new File(SpitterConstants.IMAGE_PATH+filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		}
		catch(Exception e){
			throw new Exception("Unable to save image");
		}
	}
	
	public static void validateImage(MultipartFile image) throws Exception{
		if(!image.getContentType().equals("image/jpeg")){
			throw new Exception("Only JPG images are accepted");
		}
	}
	
	public static String getProfileImage(String username){
		File file = new File(SpitterConstants.IMAGE_PATH+username+".jpg");
		if (file.exists())
			return file.getPath();
		else
			return null;
	}
}
