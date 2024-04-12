package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

	protected static WebDriver driver;  
	public static Properties p;
	public static Logger logger;
	  	     
	public static WebDriver initilizeBrowser() throws IOException
	{
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			
			if(getProperties().getProperty("os").equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WINDOWS);
			}
			else if(getProperties().getProperty("os").equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("invalid os name");
				//return;
			}
			
			if(getProperties().getProperty("browser").equalsIgnoreCase("chrome")) {
				cap.setBrowserName("chrome");
			}
			else if(getProperties().getProperty("browser").equalsIgnoreCase("edge")) {
				cap.setBrowserName("edge");
			}
			else {
				System.out.println("invalid browser name");
			}
			
			String nodeURL="http://localhost:4444/wd/hub";			
			driver=new RemoteWebDriver(new URL(nodeURL),cap);
		}
		else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
			{
			if(getProperties().getProperty("browser").equalsIgnoreCase("edge")) {
			    driver=new EdgeDriver();
			}
			else if(getProperties().getProperty("browser").equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
			}
			else {
				System.out.println("Invalid browser name");
			}
			}
		 driver.manage().deleteAllCookies(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
		 
		 return driver;
		 
	}
	
	public static WebDriver getDriver() {
			return driver;
		}
	
	public static Properties getProperties() throws IOException
	{		 
	    FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	   		
	    p=new Properties();
		p.load(file);
		return p;
	}
	
	public static Logger getLogger() 
	{		 
		logger=LogManager.getLogger(); //Log4j
		return logger;
	}
	
	public static String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	
	public static String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(9);
		return generatedString;
	}
	
	
		
	public static String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(5);
		String num=RandomStringUtils.randomNumeric(10);
		return str+num;
	}

		

	}

    

