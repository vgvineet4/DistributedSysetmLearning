package com.distributedLearning.Utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class PropertyLoader {
		private static Properties prop = new Properties();
		private static boolean isPropertiesLoaded=false;
		public  PropertyLoader(){
			if(!isPropertiesLoaded){
			InputStream input = null;
			try {
				String env=System.getProperty("local");
				if(env!=null){
				String file ="/resources/"+env+".properties";
				input = PropertyLoader.class.getResourceAsStream(file);
				// load load testing properties file
				prop.load(input);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			}
		}
		public String getProperty(String propName){
			return prop.getProperty(propName);
		}
}
