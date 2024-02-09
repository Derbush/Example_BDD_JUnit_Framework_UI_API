package ProjectName.Tests.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtil {

 WebDriverWait wait;

    public void waitForListBeNotEmpty(String locator, Integer time ){
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfAllElements(Driver.getDriver().findElements(By.xpath(locator))));
    }


}
