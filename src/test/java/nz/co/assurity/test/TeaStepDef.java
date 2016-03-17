package nz.co.assurity.test;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.assurity.bp.CheckoutUtil;
import nz.co.assurity.pages.CheckoutPage;
import nz.co.assurity.pages.HomePage;
import nz.co.assurity.pages.TeaCategoriesPage;
import org.junit.Assert;

/**
 * This is a <Description>.
 *
 * @author: Assurity
 * Date: 1/17/16
 * Time: 8:02 PM
 * To change this template use File | Settings | Editor |File and code Templates.
 */
public class TeaStepDef {
    private static HomePage hp;
    private static TeaCategoriesPage tcp;
    private static CheckoutPage cop;

    @Given("^Precondition one$")
    public void precondition_one() throws Throwable {
    }

    @Given("^Precondition two$")
    public void precondition_two() throws Throwable {
    }

    @When("^I open Passion Tea URL$")
    public void i_open_passion_Tea_UR() throws Throwable {
        hp = CheckoutUtil.openHomePage();
    }

    @Then("^I should land at the Home page$")
    public void i_should_land_at_the_Home_page() throws Throwable {
        Assert.assertEquals("Welcome", hp.getDriver().getTitle());
    }

    @Given("^I open the tea Categories Page$")
    public void i_open_the_tea_Categories_Page() throws Throwable {
        hp = CheckoutUtil.openHomePage();
        tcp = hp.clickLink_Menu();
    }

    @When("^I click on the Red Tea checkout link$")
    public void i_click_on_the_Red_Tea_checkout_link() throws Throwable {
        cop = tcp.clickBtn_RedTea();
    }

    @Then("^I should navigate to Checkout page$")
    public void i_should_navigate_to_Checkout_page() throws Throwable {
        Assert.assertEquals("Check Out", cop.getDriver().getTitle());
    }

    @When("^I enter name \"([^\"]*)\" in the Name field$")
    public void i_enter_name_in_the_Name_field(String name) throws Throwable {
        cop.type_Txt_name(name);
    }

    @When("^I enter address \"([^\"]*)\" in the Address field$")
    public void i_enter_address_in_the_Address_field(String address) throws Throwable {
        cop.type_Txt_address(address);
    }

    @When("^I enter the email \"([^\"]*)\" in the email field\\.$")
    public void i_enter_the_email_in_the_email_field(String email) throws Throwable {
        cop.type_Txt_email(email);
    }

    @When("^I click submit Button$")
    public void i_click_submit_Button() throws Throwable {
        tcp = cop.click_Btn_Submit();
    }

    @Then("^I should successfully navigate to Menu page$")
    public void i_should_successfully_navigate_to_Menu_page() throws Throwable {

        Assert.assertEquals("Menu", tcp.getDriver().getTitle());
     }

    @After
    public void closeBrowser() {
        if (hp.getDriver() != null && hp != null) {
            hp.getDriver().close();
            hp.getDriver().quit();
        }
    }

}
