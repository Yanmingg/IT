import java.util.ArrayList;
import java.util.List;

public class CRMObjectPage{
    // Sorter and searcher
    protected Sorter sorter = new Sorter();
    protected Searcher searcher = new Searcher();
    protected List<CRMObject> crmList = new ArrayList<>();

    // Getter
    public List<CRMObject> getCrmList() {
        return crmList;
    }

    // Sort name
    public List<CRMObject> sortName() {
        return sorter.sortName(this);
    }

    // Search name
    public List<CRMObject> bSearchName(String name) {
        return searcher.bSearchName(this, name);
    }

}
