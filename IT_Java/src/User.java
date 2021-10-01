import java.util.List;

public class User extends Contact{
    // Each user should have one contact page and one schedule page
    private ContactPage contactPage = new ContactPage();
    private SchedulePage schedulePage = new SchedulePage();
    private List<String> notificationList;

    public List<String> getNotificationList() {
        return notificationList;
    }

    // To check whether one contact is equal to an user
    public boolean userEqual(Contact contact){
        boolean nameEqual = this.name == contact.getName();
        if (nameEqual){
            return true;
        }
        return false;
    }

    // Constructors and getters
    public User() {
    }

    public User(String name) {
        super(name);
    }

    public ContactPage getContactPage() {
        return contactPage;
    }

    public SchedulePage getSchedulePage() {
        return schedulePage;
    }
}
