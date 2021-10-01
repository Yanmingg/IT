import java.util.ArrayList;
import java.util.List;

/*
    This class abstractly describe the interface of a contact page
    which is going to implement the following function requirement
    from the client.
    1. New, delete contacts in the page
    2. Edit the information of a contact in the page
    3. Search the contact by name or team name
    4. Add mark status to the contacts
    5. Send email to a contact

    Moreover, in order to improve the efficiency and the users' experience
    we decided to add a sorting function and using binary search, therefore

    (Bonus functions/ no requirement)
    6. Sorting the contact by name, phone, email or team name
 */
public class ContactPage extends CRMObjectPage{
    // Each contactPage should have a list containing the contacts
    private List<CRMObject> contactList = super.crmList;

    // Constructor
    public ContactPage() {
    }

    // Getter
    public List<CRMObject> getContactList() {
        return contactList;
    }

    // ToString method
    @Override
    public String toString() {
        return "ContactPage{" +
                "contactList=" + contactList +
                '}';
    }

    //-------------------------------------------------------------------1
    // 1. New, delete contacts in the page
    // New a contact into the list by a given name
    public void newContact(String name){
        contactList.add(new CRMObject(name));
    }

    // New a contact into the list by given all the attributes
    public void newContact(String name, String phone, String email,
                           String teamName, String remark) {
        contactList.add(new Contact(name,phone,email,teamName,remark));
    }

    // New a contact into the list by name and phone
    public void newContact(String name, String phone){
        contactList.add(new Contact(name, phone));
    }

    // Add a contact into the list by an existing contact
    public void newContact(CRMObject contact){
        contactList.add(contact);
    }

    // Remove a given contact form the list
    public List<CRMObject> deleteContact(CRMObject contact){
        this.getContactList().remove(contact);
        return this.getContactList();
    }
    //-------------------------------------------------------------------1


    //-------------------------------------------------------------------2
    // 2. Edit the information of a contact in the page
    // Change the name of a contact
    public void editContactName(CRMObject contact, String name){
        for (CRMObject con: this.contactList) {
            if (contact.equals(con)){
                ((Contact)con).setName(name);
            }
        }
    }

    // Change the phone number of a contact
    public void editContactPhone(CRMObject contact, String phone){
        for (CRMObject con: this.contactList) {
            if (contact.equals(con)){
                ((Contact)con).setPhone(phone);
            }
        }
    }

    // Change the email number of a contact
    public void editContactEmail(CRMObject contact, String email){
        for (CRMObject con: this.contactList) {
            if (contact.equals(con)){
                ((Contact)con).setEmail(email);
            }
        }
    }

    // Change the team name of a contact
    public void editContactTeamName(CRMObject contact, String teamName){
        for (CRMObject con: this.contactList) {
            if (contact.equals(con)){
                ((Contact)con).setTeamName(teamName);
            }
        }
    }

    // Change the team name of a contact
    public void editContactRemark(CRMObject contact, String remark){
        for (CRMObject con: this.contactList) {
            if (contact.equals(con)){
                ((Contact)con).setRemark(remark);
            }
        }
    }
    //-------------------------------------------------------------------2

    //-------------------------------------------------------------------3
    // 3. Search the contact by name or team name
    // Search the name of a contact
    // (Using binary search to improve searching efficiency)
    public List<CRMObject> searchName(String name) {
        return super.searcher.bSearchName(this, name);
    }

    public List<CRMObject> searchTeamName(String name) {
        return super.searcher.bSearchTeamName(this, name);
    }
    //-------------------------------------------------------------------3

    //-------------------------------------------------------------------4
    // 4. Add mark status to the contacts
    // Add the marked status of a contact
    public void editContactMarked(CRMObject contact, Boolean marked){
        for (CRMObject con: this.contactList) {
            if (contact.equals(con)){
                ((Contact)con).setMarked(marked);
            }
        }
    }
    //-------------------------------------------------------------------4

    //-------------------------------------------------------------------5
    // 5. Send email to a contact
    public void sendEmail(Contact contactS, Contact contactR,
                          String email){
        String emailContactS;
        String emailContactR;
        for (CRMObject con: contactList) {
            if (con.equals(contactS)){
                emailContactS = ((Contact)con).getEmail();
            }else if (con.equals(contactR)){
                emailContactR = ((Contact)con).getEmail();
            }
        }
    }
    //-------------------------------------------------------------------5

    //-------------------------------------------------------------------6
    // 6. Sorting the contact by name, phone, email or team name
    // Sort the list by attribute name
    // (Not the required function of the clients)
    public List<CRMObject> sortName() {
        return super.sorter.sortName(this);
    }

    // Sort the list by attribute phone
    // (Not the required function of the clients)
    public List<CRMObject> sortPhone() {
        return super.sorter.sortPhone(this);
    }

    // Sort the list by attribute email
    // (Not the required function of the clients)
    public List<CRMObject> sortEmail() {
        return super.sorter.sortEmail(this);
    }

    // Sort the list by attribute Team Name
    // (Not the required function of the clients)
    public List<CRMObject> sortTeamName() {
        return super.sorter.sortTeamName(this);
    }

    // Sort the list by attribute Remark
    // (Not the required function of the clients)
    public List<CRMObject> sortRemark() {
        return super.sorter.sortRemark(this);
    }
    //-------------------------------------------------------------------6

}
