import java.util.ArrayList;
import java.util.List;

/*
    This class abstractly describe the dashboard with a schedule page
    which is going to implement the following function requirement
    from the client.
    1. New, delete schedule in the page
    2. Edit the information of a schedule in the page
    3. Show future schedules
    4. Notify the related contacts

    Moreover, in order to improve the efficiency and the users' experience
    we decided to add a sorting function and using binary search, therefore

    (Bonus functions/ no requirement)
    5. Sorting a schedule by name or time
    6. Search the contact by name
 */
public class SchedulePage extends CRMObjectPage{
    // Each schedulePage should have a list containing the contacts
    private List<CRMObject> scheduleList = new ArrayList<>();

    // New a schedule into the list by a given name
    public void newSchedule(String name){
        scheduleList.add(new Schedule(name));
    }

    // New a contact into the list by given all the attributes
    public void newSchedule(String name, String time, String address, String context) {
        scheduleList.add(new Schedule(name, time, address, context));
    }

    // Constructor
    public SchedulePage() {
    }

    // Getter
    public List<CRMObject> getScheduleList() {
        return scheduleList;
    }

    // Sort the list by attribute name
    // (Not the required function of the clients)
    public List<CRMObject> sortName() {
        return super.sorter.sortName(this.scheduleList);
    }

    // Search the name of a schedule
    // (Using binary search to improve searching efficiency)
    public CRMObject searchName(String name) {
        return super.searcher.bSearchName(this, name);
    }

    // Remove a given schedule form the list
    public List<CRMObject> deleteContact(CRMObject schedule){
        this.getScheduleList().remove(schedule);
        return this.getContactList();
    }

    // ToString method
    @Override
    public String toString() {
        return "SchedulePage{" +
                "scheduleList=" + scheduleList +
                '}';
    }
}
