package page;

import mainPage.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends MainPage {

    private final static String PRODUCT_ARTICLE = "//span[@class = 'prod-article' and text() ='$']";
    private final String selectedProduct= "//*[@id='bx_3966226736_10205_7e1b8e3524755c391129a9d7e6f2d206']/div";
    private final String selectedProductSecondTest="//*[@id=\"bx_3966226736_10205_362ce596257894d11ab5c1d73d13c755\"]/div";
    private final String actualSizeSelected = "//div[contains(@class,'bx_size')]//li[contains(@class, 'active')]";
    private final String addToBasketOnSearch ="bx_117848907_10205_buy_link";
    private final String selectedProductCost="22 руб.";
    public final String productOrderId="allSum_FORMATED";
    public final String minCostFilter="0";
    public final String maxCostFilter="35";
    public ProductPage(WebDriver driver){super(driver);}

    public String getProductArticle(String articleProduct){
        return waitForElementLocatedBy(driver,By.xpath(PRODUCT_ARTICLE),waitTimeSeconds).getText();
    }

    public ProductPage selectProduct()
    {
        WebElement selectButton=waitForElementLocatedBy(driver, By.xpath(selectedProduct),waitTimeSeconds);
        selectButton.click();
        return this;
    }

    public ProductPage selectProductSecondTest()
    {
        WebElement selectButton=waitForElementLocatedBy(driver, By.xpath(selectedProductSecondTest),waitTimeSeconds);
        selectButton.click();
        return this;
    }

    public ProductPage inputFilter(){
        WebElement minCost=waitForElementLocatedBy(driver,By.xpath("//*[@id='arrFilter_P1_MIN']"),waitTimeSeconds);
        minCost.sendKeys(minCostFilter);
        WebElement maxCost=waitForElementLocatedBy(driver,By.xpath("//*[@id='arrFilter_P1_MAX']"),waitTimeSeconds);
        maxCost.sendKeys(maxCostFilter);
        maxCost.sendKeys(Keys.ENTER);
        return this;
    }

    public ProductPage selectFilter()
    {
        WebElement setFilter=waitForElementLocatedBy(driver,By.xpath("//button[@id='set_filter']//span[text()='102']"),waitTimeSeconds);
        setFilter.click();
        return this;
    }

    public ProductPage addToBasket(){
        WebElement cartButton=waitForElementLocatedBy(driver, By.id(addToBasketOnSearch),waitTimeSeconds);
        cartButton.click();
        return this;
    }

    public  ProductPage deleteFromBasket(){
        WebElement deleteButton=waitForElementLocatedBy(driver, By.xpath("//a[@class=\"basket-item-control\"]//i[@class=\"icon-close\"]"),waitTimeSeconds);

        deleteButton.click();
        return this;
    }

    public String getBasketOrderTotal(){
        return waitForElementLocatedBy(driver,By.id(productOrderId),waitTimeSeconds).getText();
    }

    public String getBasketFree()
    {
        return waitForElementLocatedBy(driver,By.xpath("/html/body/div[1]/div[4]/div[1]/div/div/div/span"),waitTimeSeconds).getText();
    }

}
