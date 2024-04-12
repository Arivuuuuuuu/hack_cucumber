package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SurgeryPage;

public class SurgeryList {
	
	SurgeryPage sp;
    
	@When("the user clicks on the surgeries option")
	public void the_user_clicks_on_the_surgeries_option() throws InterruptedException {
	
		BaseClass.getLogger().info("***Clicking the surgeries option***");        
        sp=new SurgeryPage(BaseClass.getDriver());
		
		Thread.sleep(3000);
		sp.clickSurgeries();
		
	}

	@Then("the user should get the surgeries list")
	public void the_user_should_get_the_surgeries_list() throws InterruptedException {
		
		BaseClass.getLogger().info("***Clicking the surgeries option***");  
		Thread.sleep(3000);
		
		//System.out.println(sp.surgeryList());	
		sp.surgeryList();
		System.out.println();
	    
	}

	
}
