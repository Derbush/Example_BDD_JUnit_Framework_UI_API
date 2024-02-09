package ProjectName.Tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class IkeaGoShoppingPage extends AbstractPage{

    @FindBy(how = How.XPATH, using = "//div[@id='pub__carousel__4ff07ed0-ac01-11ee-b805-51bd6b560af5']//img")
    public List<WebElement> firstCarouselImanges;

    @FindBy(how = How.XPATH, using = "    //div[@id='pub__carousel__4ff07ed0-ac01-11ee-b805-51bd6b560af5']//span[@class='pub__btn__label']\n")
    public List<WebElement> firstCarouseText;

    public List<String> listOfElementsInFirstCarousel(List<WebElement> carosel){
        List<String> listOfModules = new ArrayList<>();
        for (int i = 0; i < carosel.size(); i++) {
            listOfModules.add(carosel.get(i).getText());
        }
        return listOfModules;

    }
}
