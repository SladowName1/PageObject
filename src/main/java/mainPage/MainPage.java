package mainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.ProductPage;

public abstract class MainPage {
    protected  WebDriver driver;
    protected  static final String HOME_URL="https://igromaster.by/";
    protected  final long waitTimeSeconds=20;

    public  MainPage(WebDriver driver){this.driver=driver;}

    public ProductPage searchForProductName(String productName){
        WebElement searchInputField=waitForElementLocatedBy(driver,
                By.id("title-search-input"),waitTimeSeconds);
        searchInputField.sendKeys(productName);
        searchInputField.sendKeys(Keys.ENTER);
        return new ProductPage(driver);
    }

    public ProductPage selectedMenuItem()
    {
        WebElement selectItem=waitForElementLocatedBy(driver,
                By.xpath("//*[@id='catalog-menu-obbx_92906147_g8taYv']/li[8]/a"),waitTimeSeconds);
        selectItem.click();
        return new ProductPage(driver);
    }

    public static WebElement waitForElementLocatedBy(WebDriver driver, By by,long time){
        return new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
