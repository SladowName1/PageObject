package page;

import mainPage.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage extends MainPage {

    private final String selectProductLink="";

    public ResultPage(WebDriver driver,String productName){super(driver);}

    public ProductPage selectProductLink(){
        WebElement productInfoLink=waitForElementLocatedBy(driver, By.xpath(selectProductLink),waitTimeSeconds);
        productInfoLink.click();
        return  new ProductPage(driver);
    }
}
