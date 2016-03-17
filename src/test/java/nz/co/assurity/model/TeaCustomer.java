package nz.co.assurity.model;

/**
 * This is a <Description>.
 *
 * @author: Assurity
 * Date: 1/17/16
 * Time: 7:25 PM
 * To change this template use File | Settings | Editor |File and code Templates.
 */
public class TeaCustomer {
    String name = "Default Name";
    String address = "Default Address";
    String cardType = "Visa";
    String eMail = "test@assurity.co.nz";

    public TeaCustomer(String name, String address, String cardType, String eMail) {
        this.name = name;
        this.address = address;
        this.cardType = cardType;
        this.eMail = eMail;
    }

    public TeaCustomer() {
    }


    public String getName() {
        return name;
    }

    public TeaCustomer withName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public TeaCustomer withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCardType() {
        return cardType;
    }

    public TeaCustomer withCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public String geteMail() {
        return eMail;
    }

    public TeaCustomer witheMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

}
