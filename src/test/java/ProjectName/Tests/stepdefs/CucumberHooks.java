package ProjectName.Tests.stepdefs;

import ProjectName.Tests.utilities.Driver;
import ProjectName.Tests.utilities.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;

public class CucumberHooks extends TestBase {

    @Before ("@ui")
    public void setup_ui(){
        log.info("Code running before each UI Scenario");
    }

    @Before ("@api")
    public void setup_api(){

        log.info("Code running before each API Scenario");
    }

    @After ("@ui")
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()){
            byte[] data =  ( (TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data,"image/png", scenario.getName() );
        }
        log.info("After method");
        Driver.closeDriver();

    }
}
