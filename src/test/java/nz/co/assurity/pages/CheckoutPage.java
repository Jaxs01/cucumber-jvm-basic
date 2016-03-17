package nz.co.assurity.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * This is a <Description>.
 *
 * @author: Assurity
 * Date: 1/17/16
 * Time: 6:30 PM
 * To change this template use File | Settings | Editor |File and code Templates.
 */
public class CheckoutPage extends TeaCategoriesPage {
    private static WebDriver driver;

    @FindBy(how = How.ID, using = "email")
    private WebElement txt_email;


    @FindBy(how = How.ID, using = "name")
    private WebElement txt_name;

    @FindBy(how = How.ID, using = "address")
    private WebElement txt_address;

    @FindBy(how = How.ID, using = "card_type")
    private WebElement select_CardType;

    private Select cardType;

    @FindBy(how = How.CSS, using = "button.btn.btn-primary")
    private WebElement btn_Submit;

    public CheckoutPage() {

    }

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    public WebElement getTxt_email() {
        return txt_email;
    }

    public void type_Txt_email(String txt_email) {
        getTxt_email().sendKeys(txt_email);
    }

    public WebElement getTxt_name() {
        return txt_name;
    }

    public void type_Txt_name(String txt_name) {
        getTxt_name().sendKeys(txt_name);
    }

    public WebElement getTxt_address() {
        return txt_address;
    }

    public void type_Txt_address(String txt_address) {
        getTxt_address().sendKeys(txt_address);
    }

    public Select get_Select_CardType() {

        return new Select(select_CardType);

    }

    public void select_CardType(String cardType) {
        get_Select_CardType().selectByVisibleText(cardType);
    }

    public WebElement getBtn_Submit() {
        return btn_Submit;
    }

    public TeaCategoriesPage click_Btn_Submit() {
        getBtn_Submit().click();
        TeaCategoriesPage cp = new TeaCategoriesPage(driver);
        PageFactory.initElements(driver, cp);
        return cp;
    }

    public CheckoutPage navigateTo() throws InterruptedException {
        return super.navigateTo().clickBtn_RedTea();
    }

    public WebDriver getDriver() {
        return driver;
    }


}
