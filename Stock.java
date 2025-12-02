import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Stock extends JFrame implements ActionListener
{
	private JPanel p1,p2;
	private JLabel bgL,stockL,nameL,priceL,quantityL;
	private JTextField  nameTF,priceTF,quantityTF;
	private JButton homeBtn, signoutBtn, exitBtn, prevBtn,addBtn;
	private ImageIcon icon;
	private JComboBox combo;
	
	public Stock()
	{
		super("Supply Stock");
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
		p1.setBackground(Color.decode("#F1EEE7"));//	color selection
		p1.setLayout(null); //	for customization
		
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
		
		prevBtn = new JButton(new ImageIcon(getClass().getResource("/Images/back.png")));
		prevBtn.setBounds(99,410,41,41);
		prevBtn.setBackground(null);
		prevBtn.setBorder(null);
		prevBtn.addActionListener(this);
		p1.add(prevBtn);	
		
		homeBtn = new JButton(new ImageIcon(getClass().getResource("/Images/home.png")));
		homeBtn.setBounds(380,410,41,41);
		homeBtn.setBackground(null);
		homeBtn.setBorder(null);
		homeBtn.addActionListener(this);
		p1.add(homeBtn);
		
		addBtn = new JButton("ADD");
		addBtn.setBounds(550,300,90,31);
		addBtn.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		addBtn.setBackground(Color.decode("#7B1033"));
		addBtn.setForeground(Color.decode("#CEE2EA"));
		p1.add(addBtn);
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// Get medicine information
				String name = nameTF.getText();
				String price = priceTF.getText();
				String category = (String) combo.getSelectedItem(); // Get selected category
				
				// Check if the medicine already exists
				if (medicineExists(category, name)){
					JOptionPane.showMessageDialog(null, "This medicine already exists.", "Error", JOptionPane.ERROR_MESSAGE);
					// Clear text fields after adding medicine
					nameTF.setText("");
					priceTF.setText("");
					return; // Stop execution if the medicine already exists
					
				}
				// Write medicine information to a text file
				try{
					if(category == "Anti-ulcerant"){
						FileWriter fw = new FileWriter("Data File/Medicine Data/Anti-ulcerant.txt", true); // Append mode
						PrintWriter pw = new PrintWriter(fw);

						// Write medicine information in a specific format
						pw.println(name + "," + price);
						pw.close();
						JOptionPane.showMessageDialog(p1, "Medicine added Successfully!!", "Success", JOptionPane.INFORMATION_MESSAGE);
						// Clear text fields after adding medicine
						nameTF.setText("");
						priceTF.setText("");
					}
					else if(category == "Anti-emitic"){
						FileWriter fw = new FileWriter("Data File/Medicine Data/Anti-emitic.txt", true); // Append mode
						PrintWriter pw = new PrintWriter(fw);

						// Write medicine information in a specific format
						pw.println(name + "," + price);
						pw.close();
						JOptionPane.showMessageDialog(p1, "Medicine added Successfully!!", "Success", JOptionPane.INFORMATION_MESSAGE);
						// Clear text fields after adding medicine
						nameTF.setText("");
						priceTF.setText("");
					}
					else if(category == "Anti-histamin"){
						FileWriter fw = new FileWriter("Data File/Medicine Data/Anti-histamin.txt", true); // Append mode
						PrintWriter pw = new PrintWriter(fw);

						// Write medicine information in a specific format
						pw.println(name + "," + price);
						pw.close();
						JOptionPane.showMessageDialog(p1, "Medicine added Successfully!!", "Success", JOptionPane.INFORMATION_MESSAGE);
						// Clear text fields after adding medicine
						nameTF.setText("");
						priceTF.setText("");
					}
					else if(category == "Anti-pyretic"){
						FileWriter fw = new FileWriter("Data File/Medicine Data/Anti-pyretic.txt", true); // Append mode
						PrintWriter pw = new PrintWriter(fw);

						// Write medicine information in a specific format
						pw.println(name + "," + price);
						pw.close();
						JOptionPane.showMessageDialog(p1, "Medicine added Successfully!!", "Success", JOptionPane.INFORMATION_MESSAGE);
						// Clear text fields after adding medicine
						nameTF.setText("");
						priceTF.setText("");
					}
					else if(category == "Painkiller"){
						FileWriter fw = new FileWriter("Data File/Medicine Data/Painkiller.txt", true); // Append mode
						PrintWriter pw = new PrintWriter(fw);

						// Write medicine information in a specific format
						pw.println(name + "," + price);
						pw.close();
						JOptionPane.showMessageDialog(p1, "Medicine added Successfully!!", "Success", JOptionPane.INFORMATION_MESSAGE);
						// Clear text fields after adding medicine
						nameTF.setText("");
						priceTF.setText("");
					}
					else if(category == "Narcotics"){
						FileWriter fw = new FileWriter("Data File/Medicine Data/Narcotics.txt", true); // Append mode
						PrintWriter pw = new PrintWriter(fw);

						// Write medicine information in a specific format
						pw.println(name + "," + price);
						pw.close();
						JOptionPane.showMessageDialog(p1, "Medicine added Successfully!!", "Success", JOptionPane.INFORMATION_MESSAGE);
						// Clear text fields after adding medicine
						nameTF.setText("");
						priceTF.setText("");
					}
				}
				catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		});
		
		
		
		stockL = new JLabel(" Upgrade Stock Items  ");
		stockL.setFont(new Font("Serif",Font.BOLD,25));
		stockL.setForeground(Color.red);
		stockL.setBounds(250,50,300,50);
		p1.add(stockL);
		
		nameL = new JLabel("Medicine Name  :");
		nameL.setFont(new Font("Serif",Font.PLAIN,15));
		nameL.setForeground(Color.black);
		nameL.setBounds(120,150,120,30);
		p1.add(nameL);
		
		priceL = new JLabel("Price          :");
		priceL.setFont(new Font("Serif",Font.PLAIN,15));
		priceL.setForeground(Color.black);
		priceL.setBounds(120,200,150,30);
		p1.add(priceL);

        quantityL = new JLabel("Catagory :");
		quantityL.setFont(new Font("Serif",Font.PLAIN,15));
		quantityL.setForeground(Color.black);
		quantityL.setBounds(330,200,100,30);
		p1.add(quantityL);
		
		nameTF = new JTextField();
		nameTF.setBounds(250,150,280,30);
		p1.add(nameTF);
		
		priceTF = new JTextField();
		priceTF.setBounds(250,200,70,30);
		p1.add(priceTF);
		
		/*quantityTF = new JTextField();
		quantityTF.setBounds(250,250,280,30);
		p1.add(quantityTF);*/
			//ComboBox or Dropdown Box:
		String items[] = new String []{"Anti-ulcerant","Anti-emitic","Anti-histamin","Anti-pyretic","Painkiller","Narcotics"};//	additional line for JComboBox
		combo = new JComboBox(items);
		combo.setBounds(410,200, 120, 30);
		p1.add(combo);
		
		/*
		bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/BackGroundA.png")));
	    bgL.setBounds(0,0,800,500);
	    p1.add(bgL);*/
		
		this.add(p1);	
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==homeBtn){
			AdminHome h= new AdminHome();
			this.setVisible(false); // making current from invisible
			h.setVisible(true); // making next form visible
		}
		else if(ae.getSource()==signoutBtn){
			Login l = new Login();
			this.setVisible(false); // making current from invisible
			l.setVisible(true); // making next form visible
		}
		else if(ae.getSource()==prevBtn){
			AdminHome h= new AdminHome();
			this.setVisible(false); // making current from invisible
			h.setVisible(true);
		}
		else if(ae.getSource()==exitBtn){
			System.exit(0);// termination of program
		}
	}
	
	// Method to check if the medicine already exists
	private boolean medicineExists(String category, String name) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Data File/Medicine Data/" + category + ".txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				if (data.length >= 1 && data[0].equals(name)) {
					br.close();
					return true;
				}
			}
			br.close();
		} 
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return false;
	}
}