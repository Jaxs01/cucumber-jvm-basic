package nz.co.assurity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * This is a <Description>.
 *
 * @author: Assurity
 * Date: 1/17/16
 * Time: 6:29 PM
 * To change this template use File | Settings | Editor |File and code Templates.
 */
public class TeaCategoriesPage extends HomePage {
    private static WebDriver driver;

    @FindBy(how = How.XPATH, using = "//div[16]/div/a/span")
    private WebElement btn_RedTea;

    public TeaCategoriesPage() {

    }

    public TeaCategoriesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    public WebElement getBtn_RedTea() {
        return btn_RedTea;
    }

    public CheckoutPage clickBtn_RedTea() throws InterruptedException {
        getBtn_RedTea().click();
        Thread.sleep(2000);
        CheckoutPage cop = new CheckoutPage(driver);
        PageFactory.initElements(driver, cop);
        return cop;
    }


    public TeaCategoriesPage navigateTo() throws InterruptedException {
        return super.navigateTo().clickLink_Menu();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
