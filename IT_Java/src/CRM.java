import javax.mail.MessagingException;
import java.io.IOException;

public class CRM {
    static Importer importer = new Importer();
    static User user1 = new User("Tester", "test@gmail.com");
    static CRMTest crmTest = new CRMTest();
    static Exporter exporter = new Exporter();
    static String filename = "/Users/jim/Desktop/IT_Project/IT_Java/res/import.csv";
    static EmailSender emailSender = new EmailSender();

    public static void main(String[] argc) throws IOException, MessagingException {
        user1.setContactPage(crmTest.loadContact());
        user1.setSchedulePage(crmTest.loadSchedule());
        Contact contact1 = new Contact("Yanming", "yanmingg@student.unimelb.edu.au");
        Contact contact2 = new Contact("Nobody", "abc@gmail.com");
        user1.getContactPage().newContact(contact1);
        user1.getContactPage().newContact(contact2);
        importer.loadCSV(user1.getContactPage().getContactList(),user1.getSchedulePage().getScheduleList(), filename);
        System.out.println(user1.getSchedulePage().getScheduleList());

        System.out.println(user1.getSchedulePage().sortName());
        System.out.println(user1.getSchedulePage().searchName("beeting3"));
        //user1.getContactPage().sendEmail(contact2,contact1,"Test", "TestEmail");
        System.out.println(user1.getContactPage().getContactList());
        user1.sendEmailToContact(contact1, "Testing by user", "Test!");
        //emailSender.send();
    }
}
