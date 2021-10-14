package crm;

public class CRMObject {
    // Each CRM object should have a name
    private String name = "NULL";

    // Constructor and getter
    public CRMObject() {

    }

    public String getName() {
        return name;
    }

    // Sort by name
    public CRMObject(String name){
        this.name = name;
    }

    // ToString method
    @Override
    public String toString() {
        return "Object{" +
                "name='" + name + '\'' +
                '}';
    }
}
