import java.util.ArrayList;
import java.util.List;

public class ContactPage extends CRMObjectPage{
    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    private List<CRMObject> contactList = new ArrayList<>();

    public void newContact(String name){
        contactList.add(new CRMObject(name));
    }

    public void newContact(String name, String phone, String email, String teamName, String remark) {
        contactList.add(new Contact(name,phone,email,teamName,remark));
    }
    public void newContact(String name, String phone){
        contactList.add(new Contact(name, phone));
    }
    public void newContact(CRMObject contact){
        contactList.add(contact);
    }

    public ContactPage() {
    }

    public List<CRMObject> getContactList() {
        return contactList;
    }

    public List<CRMObject> sortName() {
        return sorter.sortName(this.contactList);
    }

    public List<CRMObject> sortPhone() {
        return sorter.sortPhone(this.contactList);
    }

    public List<CRMObject> sortEmail() {
        return sorter.sortEmail(this.contactList);
    }

    public CRMObject searchName(String name) {
        return searcher.bSearchName(this, name);
    }

    public List<CRMObject> deleteContact(CRMObject contact){
        this.getContactList().remove(contact);
        return this.getContactList();
    }

    @Override
    public String toString() {
        return "ContactPage{" +
                "contactList=" + contactList +
                '}';
    }
}
