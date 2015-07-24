package intership.dev.contact;

/**
 * Created by Administrator on 7/22/2015.
 */
public class Contacts_Item {
    private int ic_contact;
    private String tvNameContact;
    private String Description;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Contacts_Item(int ic_contact, String tvNameContact,String description) {
        this.ic_contact = ic_contact;
        this.tvNameContact = tvNameContact;
        this.Description=description;
    }

    public Contacts_Item() {
    }

    public String getTvNameContact() {
        return tvNameContact;
    }

    public void setTvNameContact(String tvNameCOntact) {
        this.tvNameContact = tvNameCOntact;
    }

    public int getIc_contact() {
        return ic_contact;
    }

    public void setIc_contact(int ic_contact) {
        this.ic_contact = ic_contact;
    }


}
