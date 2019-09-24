package pageobjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonlibrary.SeleniumCommonLib;
import commonlibrary.Utility;


public class HomePage {
	private static Logger log;
    private static String message;
    private WebDriver driver;
    private static String screenName = "HomePage";
    
    static {
        try {
            log = Utility.getTheLogger("HomePage");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public HomePage(WebDriver driver)
    {
    	this.driver = driver;
    }
	 

    @FindBy(how = How.NAME, using = "xhpc_message")
    public WebElement post_editField;

    @FindBy(how = How.XPATH, using = "//div[@contenteditable='true']")
    public WebElement postnew_editField;
    
    @FindBy(how = How.XPATH, using = "//button[contains(.,'Post')]")
    public WebElement post_btn;
    
    @FindBy(how = How.XPATH, using = "//div[@data-click='home_icon']/a[contains(@href,'https://www.facebook.com')]")
    public WebElement home_link;
    
    public void createNewPost(String postText) throws InterruptedException
    {
            log.info("createNewPost function called");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            if(post_editField!=null)
            {
            	WebDriverWait wait = new WebDriverWait(driver, 15);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.name("xhpc_message")));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("xhpc_message")));
                SeleniumCommonLib.clickOnWebElement(post_editField, "Post-Edit-Field", screenName, 15);

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@contenteditable='true']")));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@contenteditable='true']")));
                boolean editFiledDataEntered = SeleniumCommonLib.enterDataInFieldWeb(postnew_editField,postText,"Post-Edit-Field",screenName,15);      
                if(editFiledDataEntered)
                {
                    message="Data could be sucessfully entered in fields-: on screen: -"+screenName;
                    log.info(message);
                    Utility.takeScreenshot(driver,"doLogin");
                   boolean btnClicked= SeleniumCommonLib.clickOnWebElement(post_btn,"Post-Button",screenName,15);
                   if(btnClicked)
                   {
                       message="Button could be clicked - on screen-:"+screenName;
                       log.info(message);
                       Utility.takeScreenshot(driver,"createPost");
                   }
                   else
                   {
                       message="Login Button could not be clicked -on screen-:"+screenName;
                       log.error(message);
                       Utility.takeScreenshot(driver,"createPost");
                   }

                }else
                {
                    message="Data can not be entered in fields-:user id and in password on screen: -"+screenName;
                    log.error(message);
                    Utility.takeScreenshot(driver,"createPost");
                }
            }
            else
            {
                message="Elements could not be located"+" on screen: -"+screenName;
                log.error(message);
            }
            log.info("createNewPost function called ended");
    }
    
    public void verfiyNewlyCreatedPost(String postText)
    {
    	log.info("createNewPost function called");
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	log.info("Function verfiyNewlyCreatedPost called");
    	WebElement post = driver.findElement(By.xpath("//div[contains(@class,'userContentWrapper')]//div[contains(@class,'userContent')]//p[contains(text(),'"+postText.trim()+"')]"));
    	SeleniumCommonLib.verifyWebElmentExistHard(post);
    	 log.info("createNewPost function called ended");
    }
    
    
}
