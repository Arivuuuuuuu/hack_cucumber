package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DoctorsListPage;
import pageObjects.FiltersPage;
import pageObjects.LocationPage;


public class DoctorDetails {
    
	LocationPage lp;
	FiltersPage fp;
	DoctorsListPage dp;
	
	@Given("user enters city as {string}")
	public void user_enters_city_as(String city) throws InterruptedException {	
		
			BaseClass.getLogger().info("***User selecting the location of the hospital***");
			
	        lp=new LocationPage(BaseClass.getDriver());		
			
			Thread.sleep(7000);
			
			lp.clearLocation();		
			Thread.sleep(7000);

			lp.setLocation(city);
			
			Thread.sleep(7000);
			
			lp.clickLocation();
	}

	@Given("the user selects the speciality")
	public void the_user_selects_the_speciality() throws InterruptedException {
		
		BaseClass.getLogger().info("***User applying all the filters***");
		
        lp=new LocationPage(BaseClass.getDriver());	
        
		
		Thread.sleep(3000);
		
		lp.clickDepartment();
		
		Thread.sleep(5000);		
		lp.selectDepartment();
        
	    
	}

	@When("user applies the filter")
	public void user_applies_the_filter() throws InterruptedException {
		
		BaseClass.getLogger().info("***User selecting the location of the hospital***");
		
        fp=new FiltersPage(BaseClass.getDriver());	
		
		Thread.sleep(7000);		
		fp.clickStories();
		
		fp.selectStories();		
		fp.clickExp();
		
		fp.selectExp();		
		Thread.sleep(5000);		
		fp.clickAllFilter();

		
		fp.selectFees();		
		fp.selectAvailablity();

		fp.clickSortBy();		
		fp.selectSortBy();
		
		Thread.sleep(5000);

	   
	}

	@Then("the user should able to get the doctors list")
	public void the_user_should_able_to_get_the_doctors_list() throws InterruptedException {
		
		BaseClass.getLogger().info("****Printing the top 5 doctor details");
		
		dp=new DoctorsListPage(BaseClass.getDriver());
		
		for(int i=2;i<7;i++) {
			Thread.sleep(10000);				
			WebElement info=BaseClass.getDriver().findElement(By.xpath("(//div[@class='info-section'])["+i+"]"));
			JavascriptExecutor js=(JavascriptExecutor)BaseClass.getDriver();
			js.executeScript("arguments[0].scrollIntoView();", info);		

			js.executeScript("arguments[0].click();", info);
			
			Thread.sleep(5000);
			
			Set<String>window=BaseClass.getDriver().getWindowHandles();				
			List<String>wind=new ArrayList<String>(window);
			String parent=wind.get(0);
			
			Thread.sleep(5000);
			
			String child=wind.get(1);
			BaseClass.getDriver().switchTo().window(child);
			
			System.out.println();
			System.out.println(dp.docList());
		    System.out.println();
			
			Thread.sleep(5000);
			
			BaseClass.getDriver().close();
			
			BaseClass.getDriver().switchTo().window(parent);	
	    
	}
	
	
	
}
}
