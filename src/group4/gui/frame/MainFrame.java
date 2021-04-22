package group4.gui.frame;

import group4.gui.panel.AddPanel;
import group4.gui.panel.TablePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    JPanel contentPane;
    JPanel panelBottom;
    private JButton btnDel;

    private AddPanel add;
    private TablePanel query;
    JTabbedPane tabs;

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
        panelBottom = new JPanel();
        query=new TablePanel();
        panelBottom.add(query,BorderLayout.CENTER);
        panelBottom.updateUI();

        add=new AddPanel();
        panelBottom.add(add,BorderLayout.CENTER);
        panelBottom.updateUI();

        tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        tabs.addTab("Get Data", query);
        tabs.addTab("Add Stock",add);
        tabs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JTabbedPane pane = (JTabbedPane) e.getSource();
                int tabIndex = pane.getSelectedIndex();
                if(tabIndex==0){
                    query.loadData();
                }
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 500, 1500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        contentPane.add(tabs, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        btnDel = new JButton("Delete Selected");

        panel.add(btnDel);
        btnDel.setActionCommand("del");
        contentPane.add(panel, BorderLayout.SOUTH);

        panelBottom = new JPanel();
        panelBottom.setBackground(Color.LIGHT_GRAY);
        contentPane.add(panelBottom, BorderLayout.CENTER);
        panelBottom.setLayout(new BorderLayout(0,0));

        btnDel.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        System.out.println(command);
      if(command.equals("del")){
            if(query==null){
                JOptionPane.showMessageDialog(null, "No data");
                return;
            }
            query.del();
        }

    }

}