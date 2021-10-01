import java.io.IOException;

public class CRM {
    static Importer importer = new Importer();
    static User myInfo = new User();
    static CRMTest crmTest = new CRMTest();
    static Exporter exporter = new Exporter();
    static ContactPage contactPage = crmTest.loadContact();
    static SchedulePage schedulePage = crmTest.loadSchedule();
    static String filename = "/Users/jim/Desktop/IT_Project/IT_Java/res/import.csv";

    public static void main(String[] argc) throws IOException {
        Contact contact1 = new Contact("Tianyu");
        contactPage.newContact(contact1);
//
        importer.loadCSV(contactPage.getContactList(),schedulePage.getScheduleList(), filename);
        System.out.println(schedulePage.getScheduleList());

        System.out.println(schedulePage.sortName());
    }
}
