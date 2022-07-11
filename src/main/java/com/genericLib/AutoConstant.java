package com.genericLib;

public interface AutoConstant {

	public static String dirPath = System.getProperty("user.dir");
	static String propertyfile = dirPath + "/src/test/resources/CommonData.properties";
	long implicitwait = 10;
}
