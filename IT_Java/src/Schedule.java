import java.util.Date;

public class Schedule extends CRMObject{
    // Attributes of a schedule
    private String name = "NULL";
    private String time = "NULL";
    private String address = "NULL";
    private String context = "NULL";

    // Constructor with a given name
    public Schedule(String name) {
        this.name = name;
    }

    // Constructor with all the attributes
    public Schedule(String name, String time, String address, String context) {
        this.name = name;
        this.time = time;
        this.address = address;
        this.context = context;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    // This method is returning the attribute information into a csv format
    public String toCsv(){
        String csv = this.getName() + ',' + this.getTime() + ',' + this.getAddress() + ','
                + ',' + this.getContext();
        return csv;
    }

    // ToString method
    @Override
    public String toString() {
        return "Schedule{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", address='" + address + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
