package nz.co.assurity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * This is the demo site's Home page page object.
 *
 * @author: Assurity
 * Date: 1/17/16
 * Time: 6:27 PM
 * To change this template use File | Settings | Editor |File and code Templates.
 */
public class HomePage {
    private static WebDriver driver;
    private String baseUrl = "http://www.practiceselenium.com/welcome.html";
//    http://localhost:8080/bdt/


    @FindBy(how = How.LINK_TEXT, using = "Menu")
    private WebElement link_Menu;


    public HomePage(WebDriver driver) {

        this.driver = driver;


    }

    public HomePage() {
        String browser;

        if (System.getProperty("selenium.browser") == null) {
            browser = "firefox";
        } else {
            browser = System.getProperty("selenium.browser");
        }
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        "src/test/resources/chromedriver");
                driver = new ChromeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "firefox":
            default:
                driver = new FirefoxDriver();
                break;
        }
    }


    public WebElement getLink_Menu() {
        return link_Menu;
    }

    public TeaCategoriesPage clickLink_Menu() {
        getLink_Menu().click();
        TeaCategoriesPage tcp = new TeaCategoriesPage(driver);
        PageFactory.initElements(driver, tcp);
        return tcp;
    }

    public HomePage navigateTo() throws InterruptedException {


        driver.get(baseUrl);
        PageFactory.initElements(getDriver(), this);
        getDriver().manage().window().maximize();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;

    }


    public WebDriver getDriver() {
        return this.driver;
    }
}
