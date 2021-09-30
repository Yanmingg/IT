import java.util.ArrayList;
import java.util.List;

/*
    This class provide binary search methods to search the list by
    name, team name, or time. Moreover, it's possible to implement
    all attributes to search
 */
public class Searcher{

    // Search by name
    public CRMObject bSearchName(CRMObjectPage objectPage, String name){
            List<CRMObject> lst = objectPage.sortName();
            int l = 0, r = lst.size() - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;

                int res = name.compareTo(lst.get(m).getName());

                // Check if x is present at mid
                if (res == 0)
                    return lst.get(m);

                // If x greater, ignore left half
                if (res > 0)
                    l = m + 1;

                    // If x is smaller, ignore right half
                else
                    r = m - 1;
            }

            return null;
        }

    public int bSearchName1(List<CRMObject> lst, String name){
        List<Integer> index = new ArrayList<>();
        int l = 0, r = lst.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int res = name.compareTo(lst.get(m).getName());

            // Check if x is present at mid
            if (res == 0)
                return m;


            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        return -1;
    }

    public List<CRMObject> bSearchAll (CRMObjectPage objectPage, String name){
        List<Integer> indexLst = new ArrayList<>();
        List<CRMObject> output = new ArrayList<>();
        List<CRMObject> lst = objectPage.sortName();
        int index = bSearchName1(lst, name);
        while (index != -1){
            indexLst.add(index);
            output.add(lst.get(index));
            lst.remove(index);
            index = bSearchName1(lst, name);
        }
        return output;
    }

    }
