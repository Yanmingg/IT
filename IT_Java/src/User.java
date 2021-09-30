import java.util.List;

public class User extends Contact{
    private ContactPage contactPage = new ContactPage();
    private SchedulePage schedulePage = new SchedulePage();
    private List<String> notificationList;

    public List<String> getNotificationList() {
        return notificationList;
    }

    public boolean userEqual(Contact contact){
        boolean nameEqual = this.name == contact.getName();
        if (nameEqual){
            return true;
        }
        return false;
    }

    public User() {
    }

    public User(String name) {
        super(name);
    }
}
