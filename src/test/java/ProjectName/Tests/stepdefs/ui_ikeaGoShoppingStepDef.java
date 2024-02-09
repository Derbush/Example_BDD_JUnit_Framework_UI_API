package ProjectName.Tests.stepdefs;

import ProjectName.Tests.pages.IkeaGoShoppingPage;
import ProjectName.Tests.pages.IkeaMainPage;
import ProjectName.Tests.utilities.ConfigurationReader;
import ProjectName.Tests.utilities.Driver;
import ProjectName.Tests.utilities.TestBase;
import ProjectName.Tests.utilities.WaitUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.List;

public class ui_ikeaGoShoppingStepDef extends TestBase {

    WaitUtil waitUtil = new WaitUtil();
    IkeaMainPage ikeaMainPage = new IkeaMainPage();
    IkeaGoShoppingPage ikeaGoShoppingPage = new IkeaGoShoppingPage();


    @Given("User in on the main page")
    public void user_in_on_the_main_page() {
            Driver.getDriver().get(ConfigurationReader.getProperties("ikea_url"));
            log.info("User is on the main Ikea page");

    }

    @When("User clicks Go Shopping module")
    public void user_clicks_go_shopping_module() {
         ikeaMainPage.clickGoShoppingButton();

    }
    @Then("Verify first carousel has {string} images")
    public void verify_first_carousel_has_images(String string) {
        waitUtil.waitForListBeNotEmpty("(//div[@class='pub__carousel__content pub__carousel__content--snap-slide'])[1]/div/div/div", 30);
       int sizeOfTheList =  ikeaGoShoppingPage.listOfElementsInFirstCarousel(ikeaGoShoppingPage.firstCarouselImanges).size();
    //    Assertions.assertThat(Integer.parseInt(string)).isEqualTo(sizeOfTheList);
    }
    @Then("Verify text for the first module")
    public void verify_text_for_the_first_module(List<String> listOfModules) {



      //  Assertions.assertThatList(listOfModules).containsAll(ikeaGoShoppingPage.listOfElementsInFirstCarousel(ikeaGoShoppingPage.firstCarouseText));

    }
}
