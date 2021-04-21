package group4.gui.frame;

import group4.gui.panel.AddPanel;
import group4.gui.panel.TablePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    JPanel contentPane;
    JPanel panelBottom;
    private JButton btnDel;
    private JButton btnAdd;
    private AddPanel add;
    private TablePanel query;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 500, 1500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnLoadData = new JButton("Get Data");
        btnLoadData.setActionCommand("loaddata");
        panel.add(btnLoadData);

        btnDel = new JButton("Delet Selected");
        panel.add(btnDel);
        btnDel.setActionCommand("del");

        btnAdd = new JButton("Add Stock");
        panel.add(btnAdd);
        btnAdd.setActionCommand("add");

        panelBottom = new JPanel();
        panelBottom.setBackground(Color.LIGHT_GRAY);
        contentPane.add(panelBottom, BorderLayout.CENTER);
        panelBottom.setLayout(new BorderLayout(0,0));

        btnDel.addActionListener(this);
        btnLoadData.addActionListener(this);
        btnAdd.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        System.out.println(command);
        if(command.equals("add")){
            panelBottom.removeAll();
            add=new AddPanel();
            panelBottom.add(add,BorderLayout.CENTER);
            panelBottom.updateUI();
        }else if(command.equals("loaddata")){
            panelBottom.removeAll();
            query=new TablePanel();
            panelBottom.add(query,BorderLayout.CENTER);
            panelBottom.updateUI();
        }else if(command.equals("del")){
            if(query==null){
                JOptionPane.showMessageDialog(null, "No data");
                return;
            }
            query.del();
        }

    }

}