package letcode.runner;

	import org.junit.runner.RunWith;

	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(features = "C:\\Users\\cutem\\Projects\\LetCode\\src\\test\\resources\\Feature\\ProjectClassTask.feature",
					glue = {"letcode.stepdefintion", "letcode.hook"},
					dryRun = false,
					plugin = {"html:Report/HtmlReport.html", "json:Report/JsonReport.json", "rerun:target/rerun.txt"})
//					tags = "@Regression")
	public class RunnerClass {

	}

