package ProjectName.Tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class IkeaMainPage extends AbstractPage {


    @FindBy(how = How.XPATH, using = "//a[@class='website-link svelte-3eqvma']")
    private WebElement goShoppingButton;

    public void
    clickGoShoppingButton(){

        goShoppingButton.click();
    }

}
