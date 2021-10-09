package crm;


import java.util.ArrayList;
import java.util.List;

/*
    This class provide binary search methods to search the list by
    name, team name. Moreover, it's possible to implement
    all attributes to search
 */
public class Searcher{

    // Search by name
    public int bSearchOneName(CRMObjectPage crmObjectPage, String name){
        int l = 0, r = crmObjectPage.getCrmList().size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int res = name.compareTo(crmObjectPage.getCrmList().get(m).getName());

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

    public List<CRMObject> bSearchName (CRMObjectPage objectPage, String name){
        List<Integer> indexLst = new ArrayList<>();
        List<CRMObject> output = new ArrayList<>();
        List<CRMObject> lst = objectPage.sortName();
        int index = bSearchOneName(objectPage, name);
        while (index != -1){
            indexLst.add(index);
            output.add(lst.get(index));
            lst.remove(index);
            index = bSearchOneName(objectPage, name);
        }
        return output;
    }

    // Search by Team name
    public int bSearchOneTeamName(CRMObjectPage crmObjectPage, String name){
        int l = 0, r = crmObjectPage.getCrmList().size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int res = name.compareTo(((Contact) (crmObjectPage.getCrmList().get(m))).getTeamName());

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

    public List<CRMObject> bSearchTeamName (CRMObjectPage objectPage, String name){
        List<Integer> indexLst = new ArrayList<>();
        List<CRMObject> output = new ArrayList<>();
        List<CRMObject> lst = objectPage.sortName();
        int index = bSearchOneTeamName(objectPage, name);
        while (index != -1){
            indexLst.add(index);
            output.add(lst.get(index));
            lst.remove(index);
            index = bSearchOneName(objectPage, name);
        }
        return output;
    }
    }
