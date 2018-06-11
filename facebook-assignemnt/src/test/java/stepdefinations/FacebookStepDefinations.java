package stepdefinations;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverInstance;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class FacebookStepDefinations {
	
	static 	LoginPage loginPage;
	static HomePage homePage;
	
	@Given("^I have opened facebook page$")
	public void i_have_opened_facebook_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		DriverInstance.createDriverInstance();
		DriverInstance.goToWebSite();

	}

	@When("^I am on facebook login page$")
	public void i_am_on_facebook_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginPage  = PageFactory.initElements(DriverInstance.driver, LoginPage.class);
		loginPage.verifyUserOnLoginScreen();
	}

	@When("^I enter credentials$")
	public void i_enter_credentials(DataTable creds) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<Map<String,String>> testData = creds.asMaps(String.class,String.class);
		loginPage.doLogin(testData.get(0).get("user_id"), testData.get(0).get("password"));
	}

	@When("^Click on Login Button$")
	public void click_on_Login_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

	}

	@Then("^I must be able to login$")
	public void i_must_be_able_to_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.verifyUserLoggedInSucessfully();
	}

	@Then("^I must see my facebook home page$")
	public void i_must_see_my_facebook_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		homePage  = PageFactory.initElements(DriverInstance.driver, HomePage.class);
	}


	@When("^I create a post$")
	public void i_create_a_post(DataTable posts) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<Map<String,String>> testData = posts.asMaps(String.class,String.class);
		homePage.createNewPost(testData.get(0).get("post_text").trim());
	}



	@When("^Post it to my time line$")
	public void post_it_to_my_time_line() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^I must see the recently created facebook post$")
	public void i_must_see_the_recently_created_facebook_post(DataTable posts) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		List<Map<String,String>> testData = posts.asMaps(String.class,String.class);
		homePage.verfiyNewlyCreatedPost(testData.get(0).get("post_text").trim());
	}

	@When("^I click on logout button$")
	public void i_click_on_logout_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.logOut();
	}

	@Then("^I must be logged out from facebook$")
	public void i_must_be_logged_out_from_facebook() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.verifyUserOnLoginScreen();
		DriverInstance.destroyDriverInstance();
		DriverInstance.verifyDriverDestroyed();
	}


}
