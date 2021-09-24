import java.util.ArrayList;
import java.util.List;

public class SchedulePage {
    private NewScheduleStrategy NewScheduleStrategy = new NewScheduleStrategy();
    private List<Schedule> scheduleList = new ArrayList<>();

    public void newSchedule(String name){
        scheduleList.add(NewScheduleStrategy.newObject(name));
    }

    public void newSchedule(String name, String time, String address, String context) {
        scheduleList.add(NewScheduleStrategy.newObject(name, time, address, context));
    }

    public SchedulePage() {
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @Override
    public String toString() {
        return "SchedulePage{" +
                "scheduleList=" + scheduleList +
                '}';
    }
}
