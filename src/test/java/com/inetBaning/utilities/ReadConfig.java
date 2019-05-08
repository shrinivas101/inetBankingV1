package com.inetBaning.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties props;

	public ReadConfig() {
		File src = new File("F:\\workspace\\inetBankingV1\\Configuration\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			props = new Properties();
			props.load(fis);

		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception is" + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = props.getProperty("baseUrl");
		return url;

	}

	public String getUserName() {
		String uName = props.getProperty("userName");
		return uName;
	}

	public String getPassword() {
		String pwd = props.getProperty("password");
		return pwd;
	}

	public String getChromePath() {
		String chromePath = props.getProperty("chromepath");
		return chromePath;
	}

	public String getIEPath() {
		String iePath = props.getProperty("iepath");
		System.out.println(iePath);
		return iePath;
	}

	public String getFirefoxPath() {
		String ffPath = props.getProperty("firefoxpath");
		return ffPath;
	}


}
