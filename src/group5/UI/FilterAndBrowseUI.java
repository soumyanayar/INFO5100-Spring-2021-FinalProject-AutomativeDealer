package group5.UI;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.stream.Collectors;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;


import group5.Controller.FilterAndSearchController;
import group8.Car;
import group8.Dealer;


public class FilterAndBrowseUI extends JFrame implements ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnNewButton;
    private JFrame frame;
    private JLabel  imagelabel,startlabel,year,mileagelabel1, pricelabel,makeLabel, modelLabel, typeLabel, categoryLabel, colorLabel, priceLabel,
            priceMinLabel, priceMaxLabel, yearLabel, mileageLabel,makevalue, modelvalue, yearvalue,categoryvalue, colorvalue, mileagevalue,pricevalue,space,empty;
    private JComboBox make, model, type, category, color, priceMin, priceMax, selectYear, mileage;
    private JButton clearBtn;
    private Button viewDetailBtn;
    private ArrayList<Car> completeList;
    
    
    Container container = getContentPane();
    String dealerID = "";
    FilterAndSearchController filterAndSearchController;
    

    public FilterAndBrowseUI(Dealer dealer) throws SQLException, ClassNotFoundException {
    	filterAndSearchController =new FilterAndSearchController();
    	dealerID=dealer.getDealerID();
    	completeList=filterAndSearchController.getAllCars(dealerID);
    }
    
    

    public void buildUseCase2UI() throws Exception {
        this.buildComponent();
        this.buildPanelAndFrame();
        this.addListener();
        this.frameOperations();

    }
   
    
/*
 * this method creates all the UI components required for search and sort
 */
	public void buildComponent() throws SQLException {
    	
    	 frame = new JFrame();
         // frame.pack();
          frame.setSize(1800, 1800);
    	
    	textField = new JTextField();
    	textField.setSize(542, 60);
		//textField.setBounds(320, 106, 800, 70);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		//btnNewButton.addActionListener(new ActionListener() {
		btnNewButton.setBounds(920, 120, 102, 33);
		//frame.getContentPane().add(btnNewButton);
    	
		
		make = new JComboBox(filterAndSearchController.getValidOption("make",completeList));
		//System.out.println(getValidOption("make",completeList).toString());
    	
       // type = new JComboBox(filterAndSearchController.getValidOption("type",completeList));
        
        category = new JComboBox(filterAndSearchController.getValidOption("category",completeList));
        
        color = new JComboBox(filterAndSearchController.getValidOption("color",completeList));
        
        mileage = new JComboBox(new String[]{"0-2000", "2000-3000", "3000-5000", "5000-6000"});
        
        model = new JComboBox(filterAndSearchController.getValidOption("model",completeList));
        
        priceMin = new JComboBox(new String[]{"0", "1000", "2000", "3000", "4000", "5000"});
        priceMax = new JComboBox(new String[]{"15000", "25000", "35000", "45000", "55000", "65000"});
        selectYear = new JComboBox(new String[]{"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019","2020","2021"});
        reset();
        clearBtn = new JButton("Reset");

        make.setEditable(false);
        //type.setEditable(false);
        category.setEditable(false);
        color.setEditable(false);
        priceMin.setEditable(false);
        priceMax.setEditable(false);
        selectYear.setEditable(false);
        mileage.setEditable(false);

        startlabel=new JLabel("***NEW/USED VEHICLES***");
        makeLabel = new JLabel("  make");
        modelLabel = new JLabel("  Model");
        //typeLabel = new JLabel("  Type");
        categoryLabel = new JLabel("  Category");
        colorLabel = new JLabel("  Color");
        priceLabel = new JLabel("  Price");
        priceMinLabel = new JLabel("Min");
        priceMaxLabel = new JLabel("Max");
        yearLabel = new JLabel("  Year");
        mileageLabel = new JLabel("  Mileage");

        Font font1 = new Font("Courier", Font.BOLD, 16);
        Font font2 = new Font("Courier", Font.BOLD, 22);
        makeLabel.setFont(font1);
        modelLabel.setFont(font1);
        //typeLabel.setFont(font1);
        categoryLabel.setFont(font1);
        colorLabel.setFont(font1);
        priceLabel.setFont(font1);
        priceMinLabel.setFont(font1);
        priceMaxLabel.setFont(font1);
        yearLabel.setFont(font1);
        mileageLabel.setFont(font1);
        startlabel.setFont(font2);

    }

    
    
    

	/*
     * this method creates the panel for the UI components and adds it to the frame
     */
    public void buildPanelAndFrame() throws IOException, SQLException {
    	
    	JLabel imageLabel=new JLabel();
        BufferedImage image = null;
        image = ImageIO.read( ClassLoader.getSystemResource( "\\download.jfif" ) );
        ImageIcon icon = new ImageIcon(image);
        imageLabel.setIcon(icon);
        //imageLabel.setText("");
    	
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(1500,10));
        JPanel p1 = new JPanel();
        p1.setBackground(Color.white);
        p.setBackground(Color.LIGHT_GRAY);
        p1.setPreferredSize(new Dimension(1500, 120));
        
        JPanel p2 = new JPanel(); 
        JPanel p3 = new JPanel(); 
        p3.setPreferredSize(new Dimension(1500, 80));
        p3.setBackground(Color.WHITE);
        p1.add(imageLabel);
        p1.add(startlabel);
        p1.add(textField);
        p1.add(btnNewButton);
        p.add(makeLabel);
        p.add(make);
        p.add(modelLabel);
        p.add(model);
        //p.add(typeLabel);
       // p.add(type);
        p.add(categoryLabel);
        p.add(category);
        p.add(colorLabel);
        p.add(color);
        p.add(mileageLabel);
        p.add(mileage);
        p.add(priceLabel);
        p.add(p2);
        p2.add(priceMinLabel);
        p2.add(priceMin);
        p2.add(priceMaxLabel);
        p2.add(priceMax);
        p.add(yearLabel);
        p.add(selectYear);
        p.add(clearBtn);
        //p.setBounds(0,600,1000,1000);
        p.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        p2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        displayAllData(container,this.completeList);
        frame.add(p3, BorderLayout.NORTH);
        frame.add(p, BorderLayout.WEST);
        frame.add(p1, BorderLayout.NORTH);
    }
    
    /*
     * This method displays all the vehicle details on UI
     */
    public void displayAllData(Container container,ArrayList<Car> completeList) throws SQLException {
    	container.revalidate();
     frame.add(container, BorderLayout.SOUTH);
       // ArrayList<VehicleDetails> list = filterAndSearchController.getAllCars();
  // Set the Bounds for container
  	container.setPreferredSize(new Dimension(500,600));
   frame.add(container, BorderLayout.SOUTH);
     // ArrayList<VehicleDetails> list = filterAndSearchController.getAllCars();
      JPanel basepanel = new JPanel();
      basepanel.setBackground(Color.DARK_GRAY);;
 //     BoxLayout bl = new BoxLayout(basepanel, BoxLayout.PAGE_AXIS);
      container.add(basepanel);
      JScrollPane sp = new JScrollPane(basepanel);
      container.add(sp);
      //basepanel.setLayout(new GridBagLayout());
      basepanel.setLayout(new WrapLayout());
      //basepanel.setPreferredSize(new Dimension(100, 100));
       

        if (completeList.size() == 0) {
            JPanel panelempty = new JPanel();
            panelempty.setLayout(new FlowLayout(FlowLayout.CENTER));
            this.empty = new JLabel("Not Available");
            panelempty.add(empty);
            basepanel.add(panelempty);

        }
        for (int i = 0; i < completeList.size(); i++) {
            Car car = completeList.get(i);
            JPanel panel = new JPanel();
            FlowLayout fl = new FlowLayout();
            //BoxLayout bl2 = new BoxLayout(basepanel, BoxLayout.PAGE_AXIS);
            panel.setLayout(fl);
            buildSortedComponent(panel, car, i);
            panel.setBorder(BorderFactory.createBevelBorder(1));
           // panel.setPreferredSize(new Dimension(200, 300));
            basepanel.add(panel);
            basepanel.add(Box.createVerticalStrut(15));

        }
    }

    /*
     * This method displays only the sorted vehicle details on UI
     */
    public void displaySortedData(Container filtered, HashMap<String, String> result) {

        ArrayList<Car> list = filterAndSearchController.getFilteredData(result, this.completeList);
        displayListToView(filtered,list);
    }
    
    public void displaySeachData(String searchKeyWord) {
    	container.removeAll();
    	ArrayList<Car> result=filterAndSearchController.getSearchedData(searchKeyWord,this.completeList);
        displayListToView(container ,result);   
    }
    
    public void displayListToView(Container filtered, ArrayList<Car> list) {
    	JPanel basePanel = new JPanel();
        BoxLayout bl = new BoxLayout(basePanel, BoxLayout.Y_AXIS);
        filtered.add(basePanel);
        //Set Dimension of Container
        filtered.setPreferredSize(new Dimension(500,600));
        basePanel.setBackground(Color.DARK_GRAY);
        JScrollPane sp = new JScrollPane(basePanel);
        filtered.add(sp);
        basePanel.setLayout(new WrapLayout());
        
        if (list.size() == 0) {
            JPanel panelempty = new JPanel();
            panelempty.setLayout(new FlowLayout(FlowLayout.CENTER));
            this.empty = new JLabel("No Results, Please Try Again.");
            panelempty.add(empty);
            basePanel.add(panelempty);
        }
        for (int i = 0; i < list.size(); i++) {
            Car car = list.get(i);
            JPanel panel = new JPanel();
            FlowLayout fl = new FlowLayout();
            panel.setLayout(fl);
            buildSortedComponent(panel, car, i);
            panel.setBorder(BorderFactory.createBevelBorder(1));
            basePanel.add(panel);
            basePanel.add(Box.createVerticalStrut(15));
        }
        container.revalidate();
    }

         
         
	public void buildSortedComponent(JPanel panel, Car car, int i) {
		
        this.makevalue = new JLabel(car.getMake() + "  - ");
        this.modelvalue = new JLabel(car.getModel() + "                    ");
        this.year = new JLabel("Year : ");
        this.yearvalue = new JLabel(String.valueOf(car.getYear()) + "                ");
        this.categoryvalue = new JLabel(car.getCarCategory() + "                 ");
        this.colorvalue = new JLabel(car.getColor() + "\n\n\n");
        this.mileagelabel1 = new JLabel("Mileage: ");
        this.mileagevalue = new JLabel(String.valueOf(car.getMileage()) + "                       ");
        this.pricelabel = new JLabel("Price:");
        this.pricevalue = new JLabel(String.valueOf("$" + car.getMSRP()) + "0" + "         ");
        this.viewDetailBtn = new Button("View Detail");
       viewDetailBtn.setBackground(Color.LIGHT_GRAY);
       viewDetailBtn.setFont(new Font("Courier", Font.BOLD, 16));
       viewDetailBtn.setForeground(Color.BLUE);
        this.space = new JLabel("");

        JPanel jp = new JPanel();
        BoxLayout bl1 = new BoxLayout(jp, BoxLayout.Y_AXIS);
        jp.setLayout(bl1);
        createPanel2(jp, makevalue, modelvalue);
        createPanel1(jp, categoryvalue);
        createPanel2(jp, year, yearvalue);
        createPanel2(jp, mileagelabel1, mileagevalue);
        panel.add(jp);
        
        
        JPanel jp1 = new JPanel();
        BoxLayout bl2 = new BoxLayout(jp1, BoxLayout.Y_AXIS);
        jp1.setLayout(bl2);
        createPanel1(jp1, colorvalue);
        createPanel1(jp1, space);
        createPanel2(jp1, pricelabel, pricevalue);
        createPanel1(jp1, space);
        jp1.add(viewDetailBtn);
        viewDetailBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                	//System.out.println(vehicle.getImage());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        panel.add(jp1);
        panel.setPreferredSize(new Dimension(350, 200));
    }

	/*
	 * This method creates panel for the sorted details (color, category)
	 */
    public void createPanel1(JPanel panel, JLabel value) {
        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
        jp2.add(value);
        panel.add(jp2);
    }

    /*
	 * This method creates panel for the sorted details (make,mileage,price)
	 */
    public void createPanel2(JPanel panel, JLabel value1, JLabel value2) {
        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
        jp2.add(value1);
        jp2.add(value2);
        panel.add(jp2);
    }

    public void addListener() {
        make.addItemListener(this);
        make.addItemListener(this);
        model.addItemListener(this);
        //type.addItemListener(this);
        color.addItemListener(this);
        category.addItemListener(this);
        priceMin.addItemListener(this);
        priceMax.addItemListener(this);
        selectYear.addItemListener(this);
        mileage.addItemListener(this);
        btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String wordSearch= textField.getText();
				displaySeachData(wordSearch);
				
			}
		});
        clearBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					reset();
					getSelectedOption().clear();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
            }
        });
    }
    
    @Override
    public void itemStateChanged(ItemEvent event) {
        if (event.getStateChange() == ItemEvent.SELECTED) {
            changeData();

        }
    }

/*
 * This method takes the user seletcted options and puts it in hashmap. ex- make,BMW
 */
    public HashMap<String, String> getSelectedOption() {
        HashMap<String, String> selectedOption = new HashMap<>();
        if (!(make.getSelectedItem() == null)) {
        	selectedOption.put("make", (String) make.getSelectedItem());
        }
        if (!(model.getSelectedItem() == null)) {
        	selectedOption.put("model", (String) model.getSelectedItem());
        }
		/*
		 * if (!(type.getSelectedItem() == null)) { selectedOption.put("type", (String)
		 * type.getSelectedItem()); }
		 */
        if (!(category.getSelectedItem() == null)) {
        	selectedOption.put("category", (String) category.getSelectedItem());
        }
        if (!(color.getSelectedItem() == null)) {
        	selectedOption.put("color", (String) color.getSelectedItem());
        }
        if (!(selectYear.getSelectedItem() == null)) {
        	selectedOption.put("year", (String) selectYear.getSelectedItem());
        }
        if (!(priceMin.getSelectedItem() == null)) {
        	selectedOption.put("priceMin", (String) priceMin.getSelectedItem());
        }
        if (!(priceMax.getSelectedItem() == null)) {
        	selectedOption.put("priceMax", (String) priceMax.getSelectedItem());
        }
        if (!(mileage.getSelectedItem() == null)) {
        	selectedOption.put("mileage", (String) mileage.getSelectedItem());
        }
        return selectedOption;
    }

    /*
     * This method updates the display data after the sort
     */
    public void changeData() {
    	container.removeAll();
        HashMap<String, String> result = getSelectedOption();
        displaySortedData(container, result);
    }

/*
 * This method does the frame operations such as setting size, visibility, and closing
 */
    public void frameOperations() {
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /*
     * This method resets all the fields and options selected by the user
     */
    public void reset() throws SQLException {
        make.setSelectedItem(null);
       // type.setSelectedItem(null);
        category.setSelectedItem(null);
        color.setSelectedItem(null);
        mileage.setSelectedItem(null);
        model.setSelectedItem(null);
        priceMin.setSelectedItem(null);
        priceMax.setSelectedItem(null);
        selectYear.setSelectedItem(null);
        container.removeAll();
        displayAllData(container,this.completeList);
    }
    
    
    
}