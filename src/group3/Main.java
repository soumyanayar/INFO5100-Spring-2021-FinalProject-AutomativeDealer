package group3;

public class Main {
    public static void main(String[] args){
        LeadForms frame = new LeadForms("Leads List");
        LeadDataAccessor lda = new LeadDataAccessor("LEAD.csv");
        frame.init(lda.getLeads());
    }

}
