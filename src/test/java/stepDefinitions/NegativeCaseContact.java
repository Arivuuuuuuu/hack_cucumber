package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.When;
import pageObjects.ThankYouPage;

public class NegativeCaseContact {
	
	ThankYouPage typ=new ThankYouPage(BaseClass.getDriver());
	
	@When("the user provides the invalid contact number")
	public void the_user_provides_the_invalid_contact_number() {
	    typ.sendContact(BaseClass.randomeString());
	}

}
