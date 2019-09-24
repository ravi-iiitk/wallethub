
package driver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
		features = {"src\\test\\resources\\features\\login.feature"},
		glue = {"stepdefinations"},
	    plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
					"junit:target/cucumber-reports/Cucumber.xml",
					"html:target/cucumber-reports"},
		tag = "smoke",
		monochrome= true
		)
@RunWith(Cucumber.class)
public class TestRunnerJunit  {

}
	


