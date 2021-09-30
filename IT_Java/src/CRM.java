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
//        System.out.println(schedulePage.toString());
//        System.out.println(schedulePage.sortName().toString());
//        System.out.println(schedulePage.bSearchAll("beeting3"));
//        System.out.println(contactPage.getContactList());
//
        importer.loadCSV(contactPage.getContactList(),schedulePage.getScheduleList(), filename);
//        exporter.exportContacts(contactPage.getContactList());
//        exporter.exportSchedules(schedulePage.getScheduleList());
////        System.out.println(contactPage.getContactList());
//        //System.out.println(schedulePage.deleteContact(contact1));
        System.out.println(contactPage.toString());
        contactPage.editContactName(contact1, "TianyuHuang");
        System.out.println(contactPage.toString());
    }
}
