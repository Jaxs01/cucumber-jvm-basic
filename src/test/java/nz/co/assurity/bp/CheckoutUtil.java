package nz.co.assurity.bp;

import nz.co.assurity.model.TeaCustomer;
import nz.co.assurity.pages.CheckoutPage;
import nz.co.assurity.pages.HomePage;

/**
 * This is a <Description>.
 *
 * @author: Assurity
 * Date: 1/17/16
 * Time: 7:32 PM
 * To change this template use File | Settings | Editor |File and code Templates.
 */
public class CheckoutUtil {


    public static HomePage checkOut(CheckoutPage cp, TeaCustomer tc) {

        cp.type_Txt_name(tc.getName());
        cp.type_Txt_address(tc.getAddress());
        cp.type_Txt_email(tc.geteMail());
        cp.select_CardType(tc.getCardType());
        return cp.click_Btn_Submit();

    }

    public static HomePage openHomePage() throws InterruptedException {
        HomePage hp = new HomePage();
        return hp.navigateTo();

    }
}
