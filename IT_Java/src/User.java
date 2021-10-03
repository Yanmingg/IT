import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

/*
    This class represents an user in the system, each user will
    have a contact page and a schedule page and do operation
    on them. Moreover, this class supports to send email to
    an existing contact, sever contacts or just giving a valid
    email.

    main function from the client:
    1. Be able to send email to a contact

    In order to improve the user experience, the system will also
    allow user to send email to several contacts, or giving one or
    more valid email address.
    2. Be able to send to several contacts
    3. Be able to send email to a valid email address
    4. Be able to send email to several valid email address
 */
public class User extends Contact{
    // Each user should have one contact page and one schedule page
    private ContactPage contactPage = new ContactPage();
    private SchedulePage schedulePage = new SchedulePage();
    private EmailSender emailSender = new EmailSender();
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

    public User(String name, String email) {
        super(name, email);
    }


    public ContactPage getContactPage() {
        return contactPage;
    }

    public SchedulePage getSchedulePage() {
        return schedulePage;
    }

    public void setContactPage(ContactPage contactPage) {
        this.contactPage = contactPage;
    }

    public void setSchedulePage(SchedulePage schedulePage) {
        this.schedulePage = schedulePage;
    }

    //-------------------------------------------------------------------1
    // 1. Be able to send email to a contact
    public void sendEmailToContact(Contact contactR,
                          String emailSubject, String emailBody) throws IOException, MessagingException {
        String showSender;

        String emailContactS = this.getEmail();
        String nameContactS = this.getName();
        String emailContactR = "No such a contact in your contact page";
        //System.out.println(contactS.toString());
        for (CRMObject con: this.getContactPage().getContactList()) {
            if (con.equals(contactR)){
//                System.out.println("HHHH");
                emailContactR = ((Contact)con).getEmail();
            }
        }
        showSender = "This email was sent by "+ nameContactS + ". Which email is: " + emailContactS + ".\n";
        String body = showSender + emailBody;
//        System.out.println(emailContactR);
//        System.out.println(showSender);
//        System.out.println(body);
        emailSender.sendOneEmail(emailContactR, emailSubject, body);
    }
    //-------------------------------------------------------------------1

    //-------------------------------------------------------------------2
    // 2. Be able to send email to contacts
    //-------------------------------------------------------------------2


    //-------------------------------------------------------------------3
    // 3. Be able to send email to a valid email address
    public void sendEmailToAddress(String emailAddress,
                                   String emailSubject, String emailBody) throws IOException, MessagingException {
        String showSender;

        String emailContactS = this.getEmail();
        String nameContactS = this.getName();
        String emailContactR = emailAddress;
        //System.out.println(contactS.toString());

        showSender = "This email was sent by "+ nameContactS + ". Which email is: " + emailContactS + ".\n";
        String body = showSender + emailBody;
//        System.out.println(emailContactR);
//        System.out.println(showSender);
//        System.out.println(body);
        emailSender.sendOneEmail(emailContactR, emailSubject, body);
    }
    //-------------------------------------------------------------------3

    //-------------------------------------------------------------------4
    // 4. Be able to send email to valid email addresses
    public void sendEmailToAddresses(String[] emailAddresses,
                                   String emailSubject, String emailBody) throws IOException, MessagingException {
        String showSender;

        String emailContactS = this.getEmail();
        String nameContactS = this.getName();

        //System.out.println(contactS.toString());

        showSender = "This email was sent by "+ nameContactS + ". Which email is: " + emailContactS + ".\n";
        String body = showSender + emailBody;
//        System.out.println(emailContactR);
//        System.out.println(showSender);
//        System.out.println(body);
        emailSender.sendEmail(emailAddresses, emailSubject, body);
    }
    //-------------------------------------------------------------------4
}
