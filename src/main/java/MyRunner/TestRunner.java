package MyRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "E:/Selenium WorkSpace/JavaMavenProject/BddCucumberNew/src/main/java/Features/ZohoHomepage.feature",
    glue = "StepDefinationfile",
    plugin = {"pretty", "html:target/cucumber-reports.html","json:json_output/cucumber.json","junit:junit_xml/cucumber.xml"},
//		 tags = "not @skip", 
		/* tags = "@regression", */
		 monochrome = true, 
    dryRun = false
    // Exclude scenarios tagged with @skip
)public class TestRunner {
    // No code needed here; the annotations handle everything
}
