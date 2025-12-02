import java.lang.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class Cart extends JFrame implements ActionListener
{
	private JPanel p1,p2;
	private JLabel bgL,l1;
	private JButton medBtn,signoutBtn, exitBtn,ckoutBtn ,orderBtn,nextBtn,rmvBtn,cartBtn,homeBtn,previousBtn,medicineBtn,instrumentsBtn;
	private ImageIcon icon;
	private static List<String[]> cartContents = new ArrayList<>();
	private DefaultTableModel model;
	private JTable table;
	private JTextField totalTF;
	private static int count ;
	
	public Cart()
	{
		super("Cart");
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

		// Set up the table
        model = new DefaultTableModel();
        model.addColumn("Items");
        model.addColumn("Quantity");
        model.addColumn("Price");
        table = new JTable(model);
        table.setFont(new Font("Serif", Font.PLAIN, 15)); // Increase font size of table contents
        table.setRowHeight(20);
        table.setBackground(Color.decode("#DAF0EA"));

        // Set up the column header font
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Serif", Font.BOLD, 20));
        header.setForeground(Color.black);
        header.setBackground(Color.decode("#8AC1B2"));

        // Create a scroll pane to hold the table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 55, 780, 315);
        p1.add(scrollPane);
		
		l1 = new JLabel(" Total      : ");
		l1.setFont(new Font("Serif",Font.BOLD,20));
		l1.setForeground(Color.black);
		l1.setBounds(480,375,100,30);
		p1.add(l1);
		
		totalTF = new JTextField();
		totalTF = new JTextField();
        totalTF.setBounds(580, 375, 200, 30);
        p1.add(totalTF);
		
		ckoutBtn = new JButton(new ImageIcon(getClass().getResource("/Images/checkout.png")));
		ckoutBtn.setBounds(629,410,101,41);
		ckoutBtn.setBackground(null);
		ckoutBtn.setBorder(null);
		ckoutBtn.addActionListener(this);
		p1.add(ckoutBtn);
		
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
		
		rmvBtn = new JButton(new ImageIcon(getClass().getResource("/Images/remove.png")));
		rmvBtn.setBounds(49,410,100,41);
		rmvBtn.setBackground(null);
		rmvBtn.setBorder(null);
		rmvBtn.addActionListener(this);
		p1.add(rmvBtn);
		
		bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/BackGround (2).png")));
	    bgL.setBounds(0,0,800,500);
	    p1.add(bgL);
		
		this.add(p1);	
		this.setVisible(true); // Set visibility here after adding components
		showCartContents();
		
		// Add TableModelListener to detect changes in the table
        model.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    if (column == 1) { // Quantity column
                        updatePrice(row);
                    }
                }
            }
        });
		updateTotalPrice(); // Update total price after removing item
	}
	
	public void addToCart(String items, String amount, String price) {
        String[] item = new String[]{items, amount, price};
        cartContents.add(item);
        model.addRow(item);
		updateTotalPrice(); // Update total price after removing item
    }

    private void showCartContents() {
        for (String[] items : cartContents) {
            model.addRow(items);
        }
		updateTotalPrice(); // Update total price after removing item
    }

    public static List<String[]> getCartContents() {
        return cartContents;
    }
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==homeBtn){
			Home h= new Home();
			this.setVisible(false); // making current from invisible
			h.setVisible(true); // making next form visible
		}
		else if(ae.getSource()==signoutBtn){
			Login l = new Login();
			this.setVisible(false); // making current from invisible
			l.setVisible(true); // making next form visible
		}
		else if(ae.getSource()==cartBtn){
			Cart c = new Cart();
			this.setVisible(false); // making current from invisible
			c.setVisible(true);
		}
		else if(ae.getSource()==ckoutBtn){
			checkCart();
		}
		else if(ae.getSource()==rmvBtn){
			removeSelectedRow();
		}
		else if(ae.getSource()==exitBtn){
			System.exit(0);// termination of program
		}
	}
	
	private void removeSelectedRow(){
        int selectedRow = table.getSelectedRow();
        if(selectedRow != -1){ // Ensure a row is selected
            model.removeRow(selectedRow); // Remove the row from the table model
            cartContents.remove(selectedRow); // Remove the row from the cart contents
			updateTotalPrice(); // Update total price after removing item
        } 
		else{
            JOptionPane.showMessageDialog(this, "Please select a row to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	private void updatePrice(int row) {
    try {
			int quantity = Integer.parseInt((String) model.getValueAt(row, 1));
			String[] item = cartContents.get(row);
			double unitPrice = Double.parseDouble(item[2]) / Integer.parseInt(item[1]); // Original unit price
			double totalPrice = unitPrice * quantity;
			model.setValueAt(String.format("%.2f", totalPrice), row, 2); // Update the price in the model
			item[1] = String.valueOf(quantity); // Update the quantity in the cartContents
			item[2] = String.format("%.2f", totalPrice); // Update the price in the cartContents
			updateTotalPrice();
		} 
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Invalid quantity entered. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
    // Method to update the total price in the totalTF text field
	private void updateTotalPrice() {
		double total = 0.0;
		for (int i = 0; i < model.getRowCount(); i++) {
			try {
				double price = Double.parseDouble((String) model.getValueAt(i, 2));
				total += price;
			}
			catch (NumberFormatException ex) {
				// Handle invalid format, if necessary
				ex.printStackTrace();
			}
		}
    totalTF.setText(String.format("%.2f", total)); // Update the total price in the text field
	}
	
	private void writeOrderSlipToFile(){
		try{
			File file = new File("Data File/Order/Order_slip_list.txt");
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
			count++;
			writer.write("\n\n======      Order Slip   "+count+"  ======"+"\n==Items ----- Quantity ----- Price==\n");
			for (String[] item : cartContents) {
                String line =item[0] + "\t" + item[1] + "\t" + item[2] + "\n";
				writer.write(line);
            }
			writer.write("----------------------------------"+"\nTotal: " + totalTF.getText() + "\n");
			System.out.println("Order slip generated successfully.");
			
			writer.close();
			clearCart();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while writing the order slip.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void checkCart(){
		if (cartContents == null || cartContents.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Cart is empty. Add items to cart first!!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else{
			writeOrderSlipToFile();
			PaymentMethod p = new PaymentMethod();
			this.setVisible(false); // making current from invisible
			p.setVisible(true);
		}
	}
	public void clearCart(){
		model.setRowCount(0);
		cartContents.clear();
	}
	
}