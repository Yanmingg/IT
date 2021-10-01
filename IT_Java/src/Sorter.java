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
    public List<CRMObject> sortPhone(List<CRMObject> lst) {
        Collections.sort(lst, new PhoneComparator());
        return lst;
    }

    // Sort by email
    public List<CRMObject> sortEmail(List<CRMObject> lst) {
        Collections.sort(lst, new EmailComparator());
        return lst;
    }

    // Sort by team name
    public List<CRMObject> sortTeam(List<CRMObject> lst) {
        Collections.sort(lst, new TeamComparator());
        return lst;
    }

    // Sort by remark
    public List<CRMObject> sortRemark(List<CRMObject> lst) {
        Collections.sort(lst, new RemarkComparator());
        return lst;
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
            return m1.getPhone().compareTo(m2.getPhone());
        }
    }

    public class EmailComparator implements Comparator<CRMObject> {
        public int compare(CRMObject m1, CRMObject m2) {
            return m1.getEmail().compareTo(m2.getEmail());
        }
    }

    public class TeamComparator implements Comparator<CRMObject> {
        public int compare(CRMObject m1, CRMObject m2) {
            return m1.getTeamName().compareTo(m2.getTeamName());
        }
    }

    public class RemarkComparator implements Comparator<CRMObject> {
        public int compare(CRMObject m1, CRMObject m2) {
            return m1.getRemark().compareTo(m2.getRemark());
        }
    }

    public class TimeComparator implements Comparator<CRMObject> {
        public int compare(CRMObject m1, CRMObject m2) {
            return ((Schedule)m1).getTime().compareTo(((Schedule) m2).getTime());
        }
    }
}

