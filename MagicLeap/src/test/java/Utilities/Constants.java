package Utilities;


	public class Constants {
		
		
		// Paths
		public static String CONFIG_FILE_PATH =System.getProperty("user.dir")+"//src//test//java//Config//OR.properties";
		
		// xpaths, ids
		
		public static final String browser = "Chrome";
		public static final String testUrl = "https://www.magicleap.com/#/home";
		public static final String ContactURL = "https://www.magicleap.com/#/contact";
		
		public static final String ChromeDriverLoc = "//src//test//java//Utilities//chromedrivermac";
		//public static final String ChromeDriverLoc = "\\src\\test\\java\\Utilities\\chromedriverwin";
		
		public static final String GeckoDriverLoc = "//src//test//java//Utilities//geckodriver";
		
		// Login Page
		public static final String FirstName="firstname";
		public static final String LastName="lastname";
		public static final String Email="email";
		public static final String Phone="//form[@id='contactForm']//input[@id='phone']";
		public static final String Inquiry="inquiry_type";
		public static final String Company="company";
		public static final String Description="message";
		public static final String Submit="//button[@type='submit']";
		public static final String anyText="//div[@class='address']//h1";
	}


