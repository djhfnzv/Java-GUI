import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.*;
import java.io.*;
 
public class MedB extends JFrame implements ActionListener
{
	private JPanel p1; //	JPanel p;
	private JButton medBtn,aboutusBtn, signoutBtn ,addBtn, exitBtn, orderBtn,cartBtn, homeBtn ,prevBtn ;// button name need to upload 
	private JLabel  bgL;// in pannel 2 1st corner 
	private ImageIcon icon;
	private JTable table;
	private DefaultTableModel model;
	private BufferedReader reader;
	
	public MedB(){
		super("Anti-emitic");
		this.setSize(800,500); //	Setting the size
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setVisible(true);
		this.setResizable(false); // false for disable resize option
		//icon
		icon = new ImageIcon(getClass().getResource("/images/Logo1.png"));
        this.setIconImage(icon.getImage());
		// first we have to create panel
		//for panel 1:
		
		p1 = new JPanel();
		p1.setSize(new Dimension(800,500)); //	setting the panel Size
		p1.setBackground(Color.decode("#CEE2EA"));//	color selection
		p1.setLayout(null); //	for customization
		
		medBtn = new JButton(new ImageIcon(getClass().getResource("/Images/MedLife.gif")));
		medBtn.setBackground(null);
		medBtn.setBorder(null);
		medBtn.setBounds(5,5,200,41);
		//medBtn.addActionListener(this);
		p1.add(medBtn);
		
		signoutBtn = new JButton(new ImageIcon(getClass().getResource("/Images/signout.png")));
		signoutBtn.setBounds(675,5,41,41);
		signoutBtn.setBackground(null);
		signoutBtn.setBorder(null);
		signoutBtn.addActionListener(this);
		p1.add(signoutBtn);
		
		exitBtn = new JButton(new ImageIcon(getClass().getResource("/Images/exit.png")));
		exitBtn.setBackground(null);
		exitBtn.setBorder(null);
	    exitBtn.setBounds(720,5,61,41);
	    exitBtn.addActionListener(this);
	    p1.add(exitBtn);
		
		homeBtn = new JButton(new ImageIcon(getClass().getResource("/Images/home.png")));
		homeBtn.setBounds(380,410,41,41);
		homeBtn.setBackground(null);
		homeBtn.setBorder(null);
		homeBtn.addActionListener(this);
		p1.add(homeBtn);
		
		cartBtn = new JButton(new ImageIcon(getClass().getResource("/Images/cart.png")));
		cartBtn.setBounds(519,410,41,41);
		cartBtn.setBackground(null);
		cartBtn.setBorder(null);
		cartBtn.addActionListener(this);
		p1.add(cartBtn);
		
		orderBtn = new JButton(new ImageIcon(getClass().getResource("/Images/Orders.png")));
		orderBtn.setBounds(239,410,41,41);
		orderBtn.setBackground(null);
		orderBtn.setBorder(null);
		//orderBtn.addActionListener(this);
		p1.add(orderBtn);
		
		prevBtn = new JButton(new ImageIcon(getClass().getResource("/Images/back.png")));
		prevBtn.setBounds(99,410,41,41);
		prevBtn.setBackground(null);
		prevBtn.setBorder(null);
		prevBtn.addActionListener(this);
		p1.add(prevBtn);
		
		addBtn = new JButton(new ImageIcon(getClass().getResource("/Images/add2c.png")));
		addBtn.setBounds(650,415,101,31);
		addBtn.setBackground(null);
		addBtn.setBorder(null);
		p1.add(addBtn);
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String name = (String) model.getValueAt(selectedRow, 0);
                    String price = (String) model.getValueAt(selectedRow, 1);
                    
					Cart c = new Cart();
					c.setVisible(false);
                    c.addToCart(name, "1", price);
                    JOptionPane.showMessageDialog(p1, "Medicine added to cart", "MedLife", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(p1, "Please select a medicine to add to cart", "MedLife", JOptionPane.WARNING_MESSAGE);
                }
            }
		});
		
		
		// Set up the table
        model = new DefaultTableModel();
        model.addColumn("Medicine List");
        model.addColumn("Price");
		
		// Initialize table
        table = new JTable(model);
		table.setBackground(Color.decode("#FADFD6"));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // ADDED: make rows selectable
        // Read medicine details from file and add to table
        try{
			reader = new BufferedReader(new FileReader("Data File/Medicine Data/Anti-emitic.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                model.addRow(parts);
            }
        } 
		catch (IOException ioe) {
            ioe.printStackTrace();
        }
		finally {
            if (reader != null) {
                try {
                    reader.close();
                } 
				catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
		}

        // Set up the column header font
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Serif", Font.BOLD, 20));
        header.setForeground(Color.white);
        header.setBackground(Color.decode("#952442"));

        // Create a scroll pane to hold the table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 55, 780, 345);
        p1.add(scrollPane);
		
		bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/BackGround (2).png")));
	    bgL.setBounds(0,0,800,500);
	    p1.add(bgL);
		this.add(p1);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==prevBtn){
			Medicine m= new Medicine();
			this.setVisible(false); // making current from invisible
			m.setVisible(true); // making next form visible
		}
		else if(ae.getSource()==signoutBtn){
			Login l = new Login();
			this.setVisible(false); // making current from invisible
			l.setVisible(true); // making next form visible
		}
		else if(ae.getSource()==homeBtn){
			Home h= new Home();
			this.setVisible(false); // making current from invisible
			h.setVisible(true);
		}
		else if(ae.getSource()==cartBtn){
			Cart c = new Cart();
			this.setVisible(false); // making current from invisible
			c.setVisible(true);
		}
		else if(ae.getSource()==exitBtn){
			System.exit(0);// termination of program
		}
	}
}