package stepDefinitions;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ThankYouPage;

public class ValidateThankYou {
	
	ThankYouPage typ;

	
	@Given("the user clicks on the For Corporates option")
	public void the_user_clicks_on_the_for_corporates_option() throws InterruptedException {
		
		BaseClass.getLogger().info("***Clicking the For-Corporates option***");        
        typ=new ThankYouPage(BaseClass.getDriver());
        
        Thread.sleep(3000);
        typ.clickCorp();
	   
	}

	@Given("the user clicks on the health and wellness option")
	public void the_user_clicks_on_the_health_and_wellness_option() throws InterruptedException {
		
		BaseClass.getLogger().info("***Clicking the Health and wellness option***"); 
		Thread.sleep(5000);
		typ.clickHealth();
	    
	}

	@When("the user provides the correct data to the input fields except mailID")
	public void the_user_provides_the_correct_data_to_the_input_fields_except_mail_id() throws IOException, InterruptedException {
		
		BaseClass.getLogger().info("***Providing the invalid email ID***"); 
		
		typ.sendName(BaseClass.randomeString().toLowerCase());
		typ.sendOrgName(BaseClass.randomeString().toLowerCase());
	
		//typ.sendContact(BaseClass.getProperties().getProperty("contact"));
		
		typ.sendContact("9"+BaseClass.randomeNumber());

		typ.sendMail(BaseClass.randomeString().toLowerCase());

		typ.clickOrgSize();
		Thread.sleep(3000);

		typ.clickInterest();
		Thread.sleep(3000);
	   
	}

	@Then("the user should check the Schedule a demo button is enabled or not")
	public void the_user_should_check_the_schedule_a_demo_button_is_enabled_or_not() {
		
		BaseClass.getLogger().info("***Checking whether the Schedule a demo button is displayed or not***");

		if(typ.submit.isEnabled()) {
			System.out.println("***Schedule a demo button is enabled****");
		}
		else {
			System.out.println("***Schedule a demo button is not enabled****");
		}
	    
	}

	@When("the user provides the correct mailId and")
	public void the_user_provides_the_correct_mail_id_and() throws InterruptedException {
		
		BaseClass.getLogger().info("***Providing the valid email ID***"); 
		
		Thread.sleep(10000);

		typ.clearMail();
		
		Thread.sleep(3000);
		typ.sendCorrectMail(BaseClass.randomeString().toLowerCase()+"@gmail.com");
	    
	}

	@Then("the user should click the schedule a demo button and")
	public void the_user_should_click_the_schedule_a_demo_button_and() {
		
		BaseClass.getLogger().info("***Checking the Schedule demo button***");
		typ.clickSubmit();
	   
	}

	@Then("the user should see the Thank You message displayed")
	public void the_user_should_see_the_thank_you_message_displayed() {
		
		BaseClass.getLogger().info("***Validating the Thank You message***"); 
		
		if(typ.thanks.isDisplayed()) {
			System.out.println("****Thank You message is displayed****");
		}
		else {
			System.out.println("***Thank You message is not displayed***");
		}
	    
	}
	
}











