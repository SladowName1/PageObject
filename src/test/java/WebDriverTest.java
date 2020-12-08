import model.NameOfProduct;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomePage;
import page.ProductPage;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WebDriverTest {

    private WebDriver driver;

    @Test
    @Order(1)
    public void AddToBasketProductWithCorrespondingArticleTest()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        ProductPage productPage=new HomePage(driver)
                .openPage()
                .searchForProductName(NameOfProduct.bicycleRed.getNameOfProduct())
                .selectProduct()
                .addToBasket();
        Assert.assertEquals(productPage.getBasketOrderTotal(),"22 руб.");
        driver.quit();
    }

    @Test
    @Order(2)
    public void AddToBasketProductToBasketAndDeleteThis()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        ProductPage productPage=new HomePage(driver)
                .openPage()
                .selectedMenuItem()
                .inputFilter()
                .selectFilter()
                .selectProductSecondTest()
                .addToBasket()
                .deleteFromBasket();
        Assert.assertEquals(productPage.getBasketFree(),"Ваша корзина пуста");
        driver.quit();
    }
}
