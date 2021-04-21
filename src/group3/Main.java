package group3;




import javax.swing.JFrame;


public class Main {
	
	
	
	public static void main(String[] args) {
		 JFrame frame = new JFrame("Leads List");
	        LeadForm leadForm = new LeadForm();
	        leadForm.init(null, null);
	        frame.setContentPane(leadForm.getMainPanel());
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.pack();
	        frame.setSize(750, 500);
	        frame.setVisible(true);

	}

}
