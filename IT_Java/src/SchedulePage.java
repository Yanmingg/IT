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

    // Constructor
    public SchedulePage() {
    }

    // Getter
    public List<CRMObject> getScheduleList() {
        return scheduleList;
    }

    // ToString method
    @Override
    public String toString() {
        return "SchedulePage{" +
                "scheduleList=" + scheduleList +
                '}';
    }

    //-------------------------------------------------------------------1
    // 1. New, delete contacts in the page
    // New a schedule into the list by a given name
    public void newSchedule(String name){
        scheduleList.add(new Schedule(name));
    }

    // New a contact into the list by given all the attributes
    public void newSchedule(String name, String time,
                            String address, String context) {
        scheduleList.add(new Schedule(name, time, address, context));
    }

    // Remove a given schedule form the list
    public List<CRMObject> deleteContact(CRMObject schedule){
        this.getScheduleList().remove(schedule);
        return this.getContactList();
    }
    //-------------------------------------------------------------------1

    //-------------------------------------------------------------------2
    // 2. Edit the information of a schedule in the page
    // Change the name of a contact
    public void editScheduleName(Schedule schedule, String name){
        for (CRMObject con: this.scheduleList) {
            if (schedule.equals(con)){
                con.setName(name);
            }
        }
    }

    // Change the time of a schedule
    public void editScheduleTime(Schedule schedule, String time){
        for (CRMObject con: this.scheduleList) {
            if (schedule.equals(con)){
                ((Schedule) con).setTime(time);
            }
        }
    }

    // Change the address of a schedule
    public void editScheduleAddress(Schedule schedule, String address){
        for (CRMObject con: this.scheduleList) {
            if (schedule.equals(con)){
                ((Schedule) con).setAddress(address);
            }
        }
    }

    // Change the context of a schedule
    public void editScheduleContext(Schedule schedule, String context){
        for (CRMObject con: this.scheduleList) {
            if (schedule.equals(con)){
                ((Schedule) con).setContext(context);
            }
        }
    }

    // Change the related contact of a schedule
    public void editScheduleContact(Schedule schedule, Contact contact){
        for (CRMObject con: this.scheduleList) {
            if (schedule.equals(con)){
                ((Schedule) con).setRelatedContact(contact);
            }
        }
    }
    //-------------------------------------------------------------------2

    //-------------------------------------------------------------------3
    // 3. Show future schedules (Not completed so far)
    public List<CRMObject> futureSchedules(String currentTime){
        return this.scheduleList;
    }
    //-------------------------------------------------------------------3

    //-------------------------------------------------------------------4
    // 4. Notify the related contacts (Not completed so far)
    //-------------------------------------------------------------------4


    //-------------------------------------------------------------------5
    // 5. Sorting a schedule by name or time
    // Sort the list by attribute name
    // (Not the required function of the clients)
    public List<CRMObject> sortName() {
        return super.sorter.sortName(this.scheduleList);
    }
    //-------------------------------------------------------------------5

    //-------------------------------------------------------------------6
    // 6. Search the contact by name
    // Search the name of a schedule
    // (Using binary search to improve searching efficiency)
    public CRMObject searchName(String name) {
        return super.searcher.bSearchName(this, name);
    }
    //-------------------------------------------------------------------6
}
