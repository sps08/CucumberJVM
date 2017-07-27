package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

	@CucumberOptions(
			features="src/test/java/features",
			glue={"StepDefinition"},
		//	plugin = {"html:target/LoginReport", "json:target/cucumber.json",
		//			  "pretty:target/cucumber-pretty.txt",
		//			  "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml" },
			plugin = {"html:target/cucumber-html-report","pretty:target/cucumber-pretty.txt","junit:target/junitrep","testng:target/tn"},
			tags = "@testdiary"
			//plugin={"html:target/cucumber-html-report"}
			)
	public class TestRunner extends AbstractTestNGCucumberTests{

	}

