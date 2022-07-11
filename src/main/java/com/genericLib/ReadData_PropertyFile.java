package com.genericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadData_PropertyFile {

	public String readProp(String key) throws IOException {
		FileInputStream fis = new FileInputStream(AutoConstant.propertyfile);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}

}
