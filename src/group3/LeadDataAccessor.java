package group3;
/**
 * @author  Avni
 * @date: 2021/4/14
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeadDataAccessor {
    private List<Lead> leads;
    private String filePath;
    public LeadDataAccessor(String filePath) {
        this.filePath = filePath;
    }

    public List<Lead> getLeads() {
        List<Lead> leads = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath));) {
            while (scanner.hasNextLine()) {
                leads.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return leads;
    }
    private static Lead getRecordFromLine(String line) {
        Lead lead = new Lead();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            lead.firstName = rowScanner.next();
            lead.lastName = rowScanner.next();
            lead.email = rowScanner.next();
            lead.phoneNumber = rowScanner.next();
            lead.zipCode = rowScanner.next();
            lead.carModel = rowScanner.next();
            lead.carYear = rowScanner.next();
            lead.carColor = rowScanner.next();
            lead.message = rowScanner.next();
            lead.replyMessage = rowScanner.next();
            lead.contacted = rowScanner.nextBoolean();
        }
        return lead;
    }
}

