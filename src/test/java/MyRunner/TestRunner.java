package MyRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "E:/Selenium WorkSpace/JavaMavenProject/BddCucumberNew/src/main/java/Features",
    glue = "StepDefinationfile",
    plugin = {"pretty", "html:target/cucumber-reports.html","json:json_output/cucumber.json","junit:junit_xml/cucumber.xml"},
		/* tags = "@SignIn" , */   // Only scenarios with this tag will run	 
	// tags = "@ZohoHomePage and @SignIn",
    monochrome = true, 
    dryRun = false
    
)public class TestRunner {
    // No code needed here; the annotations handle everything
}
