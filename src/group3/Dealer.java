package group3;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;



public class Dealer {

	
		public static void main(String[] args) {
			
			JFrame frame = new JFrame("LEADS LIST");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 400);

	       
	        // Set Layout
	        frame.setLayout(new BorderLayout());
	        JPanel twinPane = new JPanel();
	        frame.add(twinPane, BorderLayout.CENTER);
            twinPane.setLayout(new GridLayout(1,2));
            twinPane.add(drawForm());
           // twinPane.add(drawInfo());
	      
	        
	        
	        //Creating the MenuBar and adding components
	        JMenuBar mb = new JMenuBar();
	        JMenu m1 = new JMenu("FILTER BY");
	        JMenu m2 = new JMenu("SORTED BY");
	        mb.add(m1);
	        mb.add(m2);
	        JMenuItem m11 = new JMenuItem("READ");
	        JMenuItem m22 = new JMenuItem("UREAD");
	        JMenuItem b = new JMenuItem("DESCENDING");
	        JMenuItem c = new JMenuItem("ASCENDING");
	        m1.add(m11);
	        m1.add(m22);
	        m2.add(b);
	        m2.add(c);    

	    
	     
	       
	       frame.getContentPane().add(BorderLayout.PAGE_START, mb);     
	     
	       frame.setVisible(true);
	    }

		public static Component  drawForm() {
			//Set panel with layout and border
	        JPanel panel = new JPanel();
	        panel.setBorder(BorderFactory.createTitledBorder("LIST"));
	        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	      
	        //Create field and labels for  panel and add data to panel
	       
	        JLabel label = new JLabel("FIRST NAME");
	        JTextField tf = new JTextField(10); // accepts upto 10 characters
	      
	        panel.add(label); 
	        panel.add(tf);
	        
	        JLabel lable1 = new JLabel("LAST NAME");
	        JTextField tf1 = new JTextField(10);
	        panel.add(lable1);
	        panel.add(tf1);
	          
	        JLabel lable2 = new JLabel("PHONE NUMBER");
		    JTextField tf2 = new JTextField(10);
		    panel.add(lable2);
		    panel.add(tf2);
		         
		    JLabel lable3 = new JLabel("ZIP CODE");
		    JTextField tf3 = new JTextField(10);
		    panel.add(lable2);
		    panel.add(tf2);
		    
		    JLabel lable5= new JLabel("E-MAIL");
		    JTextField tf5= new JTextField(20);
		    panel.add(lable5);
		    panel.add(tf5);
		     
		    JLabel lable4 = new JLabel("CAR NAME");
		    JTextField tf4 = new JTextField(10);
		    panel.add(lable4);
		    panel.add(tf4);
		        
		    JLabel lable6 = new JLabel("MODEL");
		    JTextField tf6 = new JTextField(10);
		    panel.add(lable6);
		    panel.add(tf6);
	      
		    JLabel lable7 = new JLabel("YEAR");
	        JTextField tf7 = new JTextField(10);
	        panel.add(lable7);	
	        panel.add(tf7);
				          	          
	        JLabel lable8 = new JLabel("DEALER ID");
	        JTextField tf8 = new JTextField(10);
	        panel.add(lable8);
	        panel.add(tf8);
					          
	        JLabel lable9 = new JLabel("MESSAGE");
	        JTextField tf9 = new JTextField(35);
	        panel.add(lable9);
	        panel.add(tf9);
	       
	        JButton resp = new JButton("respond");
	        panel.add(resp);
	        //Set return
	        return panel;
		}

		
	}

	
		

	


