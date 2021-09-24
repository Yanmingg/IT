import java.util.List;

public class CRMTest {
    public ContactPage contactPage = new ContactPage();
    public SchedulePage schedulePage = new SchedulePage();

    Contact contact1 = new Contact("Tianyu");
    public ContactPage loadContact(){
        contactPage.newContact(contact1);
        contactPage.newContact("Yanming","158***9082","158***com","Unimelb","Jim");
        contactPage.newContact("Banming","258***9082","958***com","Knimelb","Lim");
        contactPage.newContact("Canming","358***9082","858***com","Pnimelb","Nim");
        contactPage.newContact("Danming","458***9082","758***com","Qnimelb","Mim");
        return this.contactPage;
    }

    public List<Schedule> loadSchedule(){
        schedulePage.newSchedule("meeting1", "1 Sep", "Home", "Stand-up meeting");
        schedulePage.newSchedule("meeting2", "3 Sep", "Home", "Stand-up meeting");
        schedulePage.newSchedule("meeting3", "5 Sep", "Home", "Stand-up meeting");
        return schedulePage.getScheduleList();
    }

    public CRMTest() {
    }
}