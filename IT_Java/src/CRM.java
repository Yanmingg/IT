import javax.mail.MessagingException;
import java.io.IOException;

public class CRM {
    static Importer importer = new Importer();
    static User user1 = new User();
    static CRMTest crmTest = new CRMTest();
    static Exporter exporter = new Exporter();
    static String filename = "/Users/jim/Desktop/IT_Project/IT_Java/res/import.csv";
    static EmailSender emailSender = new EmailSender();

    public static void main(String[] argc) throws IOException, MessagingException {
        user1.setContactPage(crmTest.loadContact());
        user1.setSchedulePage(crmTest.loadSchedule());
        Contact contact1 = new Contact("Tianyu");
        user1.getContactPage().newContact(contact1);
//
        importer.loadCSV(user1.getContactPage().getContactList(),user1.getSchedulePage().getScheduleList(), filename);
        System.out.println(user1.getSchedulePage().getScheduleList());

        System.out.println(user1.getSchedulePage().sortName());
        System.out.println(user1.getSchedulePage().searchName("beeting3"));

        emailSender.send();
    }
}
