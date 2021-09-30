import java.util.ArrayList;
import java.util.List;

public class CRMObjectPage{
    protected Sorter sorter = new Sorter();
    protected Searcher searcher = new Searcher();

    private List<CRMObject> objectList = new ArrayList<>();

    public List<CRMObject> getContactList() {
        return objectList;
    }

    public List<CRMObject> sortName() {
        return sorter.sortName(this.objectList);
    }

    @Override
    public String toString() {
        return "ContactPage{" +
                "contactList=" + objectList +
                '}';
    }
}
