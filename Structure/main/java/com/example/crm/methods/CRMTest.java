package com.example.crm.methods;


public class CRMTest {
    public ContactPage contactPage = new ContactPage();
    public SchedulePage schedulePage = new SchedulePage();

    //Contact contact1 = new Contact("Tianyu");
    public ContactPage loadContact(){
        //contactPage.newContact(contact1);
        contactPage.newContact("Yanming","158***9082","yanmingg@student.unimelb.edu.au","Unimelb","Jim");
        contactPage.newContact("Banming","258***9082","958***com","Knimelb","Lim");
        contactPage.newContact("Canming","358***9082","858***com","Pnimelb","Nim");
        contactPage.newContact("Danming","458***9082","758***com","Qnimelb","Mim");
        return this.contactPage;
    }

    public SchedulePage loadSchedule(){
        schedulePage.newSchedule("meeting1", "6 Sep", "Home", "Stand-up meeting");
        schedulePage.newSchedule("aeeting2", "5 Sep", "zome", "Ytand-up meeting");
        schedulePage.newSchedule("beeting3", "7 Sep", "xome", "Ttand-up meeting");
        schedulePage.newSchedule("beeting3", "1 Sep", "xome", "Ttand-up meeting");
        return schedulePage;
    }

    public CRMTest() {
    }
}
