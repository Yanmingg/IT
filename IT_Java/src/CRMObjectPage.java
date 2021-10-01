import java.util.ArrayList;
import java.util.List;

public class CRMObjectPage{
    // Sorter and searcher
    protected Sorter sorter = new Sorter();
    protected Searcher searcher = new Searcher();
    protected List<CRMObject> crmList = new ArrayList<>();

    public List<CRMObject> getCrmList() {
        return crmList;
    }

    public List<CRMObject> sortName() {
        return sorter.sortName(this);
    }

}
