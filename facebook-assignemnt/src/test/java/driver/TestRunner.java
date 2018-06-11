
package driver;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
//import cucumber.api.junit.Cucumber;
//import org.junit.runner.RunWith;

@CucumberOptions(
		features = {"src\\test\\resources\\features\\facebook-post.feature"},
		glue = {"stepdefinations"},
	    plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
					"junit:target/cucumber-reports/Cucumber.xml",
					"html:target/cucumber-reports"},
		monochrome= true
		)
//extends AbstractTestNGCucumberTests
//@RunWith(Cucumber.class)
public class TestRunner extends AbstractTestNGCucumberTests  {

}
	


