package crm;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/*
    This class follow the requirement that import the information
    from a csv file and creating contacts or schedules into the system.
 */
public class Importer {
    public void loadCSV(List<CRMObject> contactList, List<CRMObject> scheduleList, String filename) {
        int lineNum = 1;

        // Reading the file with error handling
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];

                // Check the type and create
                switch (type) {
                    case "Contact":
                        String nameC = parts[1];
                        String phone = parts[2];
                        String email = parts[3];
                        String teamName = parts[4];
                        String remark = parts[5];
                        contactList.add(new Contact(nameC,phone,email,teamName,remark));
                        break;
                    case "Schedule":
                        String nameS = parts[1];
                        String time = parts[2];
                        String address = parts[3];
                        String context = parts[4];
                        scheduleList.add(new Schedule(nameS,time,address,context));
                        break;
                }
                lineNum++;
            }

            // Catching errors
        } catch (IOException e) {
            System.out.println("error: file \"<" + filename + ">\" not found");
            System.exit(-1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("error: in file \"<" + filename + ">\" at line <" + lineNum + ">");
        }
    }

    // Constructor
    public Importer() {
    }
}
