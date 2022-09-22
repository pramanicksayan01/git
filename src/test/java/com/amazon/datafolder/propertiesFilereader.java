package com.amazon.datafolder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public class propertiesFilereader {

	
		// TODO Auto-generated method stub
		 private Properties properties;
		private final String path= "config.properties";
		public propertiesFilereader() {
			BufferedReader reader;
		try {
			reader=new BufferedReader(new FileReader(path));
			properties= new Properties();
		
		try {
				properties.load(reader);
				reader.close();
			}
			catch(IOException e) {
				e.printStackTrace();
				
			}
		}
		catch(FileNotFoundException f) {
			f.printStackTrace();
			throw new RuntimeException("file not found");
		}

	}
		public String getEmail() {
			String email=properties.getProperty("Email");
				return email;
				/*byte[] encodedBytes = Base64.getEncoder().encode(email.getBytes());
		        if(email!= null)
		            return new String(encodedBytes);
		        else
		            throw new RuntimeException("Username not specified in the application.properties file.");*/
		}
		public String getPassword() {
			String password=properties.getProperty("Password");
			return password;
			/*byte[] encodedBytes = Base64.getEncoder().encode(password.getBytes());
	        if(password!= null)
	            return new String(encodedBytes);
	        else
	            throw new RuntimeException("Username not specified in the application.properties file.");*/
		}
}

