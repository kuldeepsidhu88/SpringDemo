package com.demo.constants;

public class SpitterConstants {
	
	public static final String IMAGE_PATH = "C:/Users/Kuldeep/Desktop/Java/ProfileImages/";
	public static final String INSERT_SPITTER = "INSERT INTO SPITTER (USERNAME,PASSWORD,EMAIL_ID,FULL_NAME) VALUES(?,?,?,?)";
	public static final String GET_SPITTER = "SELECT * FROM SPITTER WHERE USERNAME = ?";
	public static final String SPITTLE_LIST = "SELECT * FROM SPITTLE WHERE USERNAME = ?";
	public static final String RECENT_SPITTLE_LIST = "SELECT * FROM SPITTLE ORDER BY CREATED_AT DESC LIMIT ?";

}
