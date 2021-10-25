package runner;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
    tags = {"@Srv131"},
    plugin = {
        "pretty",
        "html:target/cucumber",
        "json:target/cucumber.json"},
    features = ("src/test/resources/feature"),
    glue = {"com.apiwp.steps"})
public class CucumberRun {


	/*
	 * @BeforeClass public static void setreferencedata () throws
	 * FileNotFoundException, ClassNotFoundException, SQLException {
	 * 
	 * System.out.println("Reference data"); String referencefile =
	 * "ReferenceDataAPI"; SetData sd = new SetData();
	 * sd.readdatasheet(referencefile); }
	 */
	
}
