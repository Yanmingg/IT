import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    This class provide sorting methods for the list by
    required attributes, it's possible to implement
    all attributes to sort.
 */
public class Sorter {
    // Sort by contact name
    public List<CRMObject> sortName(CRMObjectPage crmObjectPage) {
        Collections.sort(crmObjectPage.getCrmList(), new NameComparator());
        return crmObjectPage.getCrmList();
    }

    // Sort by phone
    public List<CRMObject> sortPhone(ContactPage contactPage) {
        Collections.sort(contactPage.getContactList(), new PhoneComparator());
        return contactPage.getContactList();
    }

    // Sort by email
    public List<CRMObject> sortEmail(ContactPage contactPage) {
        Collections.sort(contactPage.getContactList(), new EmailComparator());
        return contactPage.getContactList();
    }

    // Sort by team name
    public List<CRMObject> sortTeamName(ContactPage contactPage) {
        Collections.sort(contactPage.getContactList(), new TeamNameComparator());
        return contactPage.getContactList();
    }

    // Sort by remark
    public List<CRMObject> sortRemark(ContactPage contactPage) {
        Collections.sort(contactPage.getContactList(), new RemarkComparator());
        return contactPage.getContactList();
    }

    // Sort by time
    public List<CRMObject> sortTime(SchedulePage schedulePage) {
        Collections.sort(schedulePage.getScheduleList(), new TimeComparator());
        return schedulePage.getScheduleList();
    }

    // Comparators
    public class NameComparator implements Comparator<CRMObject> {
        public int compare(CRMObject m1, CRMObject m2) {
            return m1.getName().compareTo(m2.getName());
        }
    }

    public class PhoneComparator implements Comparator<CRMObject> {
        public int compare(CRMObject m1, CRMObject m2) {
            return ((Contact)m1).getPhone().compareTo(((Contact) m2).getPhone());
        }
    }

    public class EmailComparator implements Comparator<CRMObject> {
        public int compare(CRMObject m1, CRMObject m2) {
            return ((Contact)m1).getEmail().compareTo(((Contact) m2).getEmail());
        }
    }

    public class TeamNameComparator implements Comparator<CRMObject> {
        public int compare(CRMObject m1, CRMObject m2) {
            return ((Contact)m1).getTeamName().compareTo(((Contact) m2).getTeamName());
        }
    }

    public class RemarkComparator implements Comparator<CRMObject> {
        public int compare(CRMObject m1, CRMObject m2) {
            return ((Contact)m1).getRemark().compareTo(((Contact) m2).getRemark());
        }
    }

    public class TimeComparator implements Comparator<CRMObject> {
        public int compare(CRMObject m1, CRMObject m2) {
            return ((Schedule)m1).getTime().compareTo(((Schedule) m2).getTime());
        }
    }
}

