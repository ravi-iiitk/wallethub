
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

public class login-stefdef{

static 	LoginPage loginPage;
static HomePage homePage;

@Given("^I am on facebook login page$")
public void i_have_opened_facebook_page()throws Throwable{
        // Write code here that turns the phrase above into concrete actions
        DriverInstance.createDriverInstance();
        DriverInstance.goToWebSite();

        }

@When("^I enter the user id$")
public void i_am_on_facebook_login_page()throws Throwable{
        // Write code here that turns the phrase above into concrete actions
        loginPage=PageFactory.initElements(DriverInstance.driver,LoginPage.class);
        loginPage.verifyUserOnLoginScreen();
        loginPage.login();

        }

}
