package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ThankYouPage;

public class NegativeCaseName {
	
	ThankYouPage typ=new ThankYouPage(BaseClass.getDriver());
	
	@When("the user provides the Invalid name")
	public void the_user_provides_the_incorrect_data_to_the_name_column() {
		
        BaseClass.getLogger().info("***Providing the invalid name***"); 
		
		typ.sendName(BaseClass.randomeNumber());
	    
	}

	@Then("the user should not be able to click the schedule a demo button")
	public void the_user_should_not_be_able_to_click_the_schedule_a_demo_button() {
		
		BaseClass.getLogger().info("***Checking whether the Schedule a demo button is displayed or not***");

		if(typ.submit.isEnabled()) {
			System.out.println("***Schedule a demo button is enabled****");
		}
		else {
			System.out.println("***Schedule a demo button is not enabled****");
		}
	    
	}


}
