package crm;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/*
    This class follow the requirement that export the information
    of contacts or schedules into a csv file.
 */
public class Exporter {
    public void exportContacts(List<CRMObject> lst) throws IOException {
        FileWriter csvWriter = new FileWriter("ContactsExported.csv");
        csvWriter.append("Name");
        csvWriter.append(",");
        csvWriter.append("Phone");
        csvWriter.append(",");
        csvWriter.append("Email");
        csvWriter.append(",");
        csvWriter.append("TeamName");
        csvWriter.append(",");
        csvWriter.append("Remark");
        csvWriter.append("\n");
        for (CRMObject element: lst) {
            csvWriter.append(((Contact) element).toCsv());
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }

    public void exportSchedules(List<CRMObject> lst) throws IOException {
        FileWriter csvWriter = new FileWriter("SchedulesExported.csv");
        csvWriter.append("Name");
        csvWriter.append(",");
        csvWriter.append("Time");
        csvWriter.append(",");
        csvWriter.append("Address");
        csvWriter.append(",");
        csvWriter.append("Context");
        csvWriter.append("\n");
        for (CRMObject element: lst) {
            csvWriter.append(((Schedule) element).toCsv());
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }

    // Constructor
    public Exporter() {
    }
}
