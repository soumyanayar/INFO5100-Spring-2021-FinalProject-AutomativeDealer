package group3;
/**
 * @author  Zhehui Yang
 * @date: 2021/4/15
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class LeadForm extends JComponent implements MouseListener {
    private JPanel mainPanel;
    private JFrame mainFrame;
    private Lead lead;
    private JTextField fn;
    private JTextField ln;
    private JTextField em;
    private JTextField phone;
    private JTextField zipCode;
    private JTextField carModel;
    private JTextField carColor;
    private JTextField carStock;
    private JTextArea setMessage;
    private JLabel firstName;
    private JLabel lastNameLabel;
    private JButton respondButton;
    private JLabel message;
    private JLabel carModelLabel;
    private JLabel colorLabel;
    private JButton respondShort;
    private JLabel emailLabel;
    private JLabel phoneLabel;
    private JLabel zipCodeLabel;
    private JTextField carVinTextField;
    private JLabel carVINLabel;
    private JLabel carStockLabel;

    private boolean isExpanded;

    public void init(JFrame mainFrame,Lead lead) {
        isExpanded = true;
        this.lead = lead;
        this.mainFrame = mainFrame;
        firstName.addMouseListener(this);
        mouseClicked(null);
        setText();
        implementRespond();
    }
    public void setText( ){
        fn.setText(lead.getFirstName());
        ln.setText(lead.getLastName());
        em.setText(lead.getEmail());
        phone.setText(lead.getPhoneNumber());
        zipCode.setText(lead.getZipCode());
        carModel.setText(lead.getCarModel());
        carColor.setText(lead.getCarColor());
        carVinTextField.setText(lead.getCarVin());
        carStock.setText(lead.getCarStock());
        setMessage.setText(lead.getMessage());
    }
    public void implementRespond(){
        respondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RespondDetailsUI r = new RespondDetailsUI(lead);
                r.buildGUI();
            }
        });
        respondShort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RespondDetailsUI r = new RespondDetailsUI(lead);
                r.buildGUI();
            }
        });
    }
    @Override
    public void setVisible(boolean isVisible){
        super.setVisible(isVisible);
        if (isVisible == true) {
            isExpanded = false;
            fn.setVisible(true);
            ln.setVisible(true);
            firstName.setVisible(true);
            lastNameLabel.setVisible(true);
            mouseClicked(null);
            return;
        }
        fn.setVisible(false);
        ln.setVisible(false);
        em.setVisible(false);
        phone.setVisible(false);
        zipCode.setVisible(false);
        carModel.setVisible(false);
        carColor.setVisible(false);
        carStock.setVisible(false);
        setMessage.setVisible(false);
        firstName.setVisible(false);
        lastNameLabel.setVisible(false);
        respondButton.setVisible(false);
        message.setVisible(false);
        carModelLabel.setVisible(false);
        colorLabel.setVisible(false);
        respondShort.setVisible(false);
        emailLabel.setVisible(false);
        phoneLabel.setVisible(false);
        zipCodeLabel.setVisible(false);
        carVinTextField.setVisible(false);
        carVINLabel.setVisible(false);
        carStockLabel.setVisible(false);
        return;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        isExpanded = !isExpanded;
        zipCodeLabel.setVisible(isExpanded);
        carModelLabel.setVisible(isExpanded);
        carStockLabel.setVisible(isExpanded);
        carVINLabel.setVisible(isExpanded);
        colorLabel.setVisible(isExpanded);
        carVinTextField.setVisible(isExpanded);
        message.setVisible(isExpanded);
        zipCode.setVisible(isExpanded);
        carModel.setVisible(isExpanded);
        carColor.setVisible(isExpanded);
        carStock.setVisible(isExpanded);
        setMessage.setVisible(isExpanded);
        respondButton.setVisible(isExpanded);
        respondShort.setVisible(!isExpanded);
        if (isExpanded == false) {
            //mainPanel.setSize(700, 100);
            if (mainFrame != null) {
                mainFrame.setSize(750, -300);
            }
        } else {
            //mainPanel.setSize(700, 400);
            if (mainFrame != null) {
                mainFrame.setSize(750, 300);
            }
        }
        mainPanel.updateUI();
    }
    public JTextField getFirstName() {
        return fn;
    }

    public JTextField getLastName() {
        return ln;
    }
    public JTextField getEmail() {
        return em;
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }


}
