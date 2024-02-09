package ProjectName.Tests.pages;

import ProjectName.Tests.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    public AbstractPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
