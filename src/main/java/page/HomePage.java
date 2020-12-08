package page;

import mainPage.MainPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends MainPage {
    public HomePage(WebDriver driver){super(driver);}

    public  HomePage openPage(){
        driver.get(HOME_URL);
        return this;
    }
}
