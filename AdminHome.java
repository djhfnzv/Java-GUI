import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AdminHome extends JFrame implements ActionListener
{
	private JPanel p1,p2;
	private JLabel bgL, l1, l2,orderL,stockL,actL;
	private JButton medBtn,homeBtn,aboutusBtn,myprofileBtn,signoutBtn, exitBtn, orderBtn, stockBtn , actBtn, dataBtn;
	private ImageIcon icon;
	
	public AdminHome()
	{
		super("Admin Home");
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
		
		orderBtn = new JButton(new ImageIcon(getClass().getResource("/Images/order.png")));
		orderBtn.setBounds(65,131,181,134);
		orderBtn.setBackground(null);
		orderBtn.setBorder(null);
		orderBtn.addActionListener(this);
		p1.add(orderBtn);
		
		stockBtn = new JButton(new ImageIcon(getClass().getResource("/Images/stock.png")));
		stockBtn.setBounds(310,150,181,115);
		stockBtn.setBackground(null);
		stockBtn.setBorder(null);
		stockBtn.addActionListener(this);
		p1.add(stockBtn);
		
		actBtn = new JButton(new ImageIcon(getClass().getResource("/Images/act.png")));
		actBtn.setBounds(555,154,161,111);
		actBtn.setBackground(null);
		actBtn.setBorder(null);
		actBtn.addActionListener(this);
		p1.add(actBtn);
		
		
		homeBtn = new JButton(new ImageIcon(getClass().getResource("/Images/home.png")));
		homeBtn.setBounds(380,410,41,41);
		homeBtn.setBackground(null);
		homeBtn.setBorder(null);
		homeBtn.addActionListener(this);
		p1.add(homeBtn);
		
		orderL = new JLabel(" Track Order ");
		orderL.setFont(new Font("Serif",Font.BOLD,20));
		orderL.setForeground(Color.red);
		orderL.setBounds(80,255,200,50);
		p1.add(orderL);
		
		stockL = new JLabel("Supply Stock ");
		stockL.setFont(new Font("Serif",Font.BOLD,20));
		stockL.setForeground(Color.red);
		stockL.setBounds(330,255,200,50);
		p1.add(stockL);
		
		actL = new JLabel(" User Activity ");
		actL.setFont(new Font("Serif",Font.BOLD,20));
		actL.setForeground(Color.red);
		actL.setBounds(565,255,200,50);
		p1.add(actL);
		
		
		dataBtn = new JButton("USER INFO");
		dataBtn.setBounds(555,300,161,35);
		dataBtn.setFont(new Font("Serif",Font.BOLD,25));
		dataBtn.setBackground(Color.decode("#801414"));
		dataBtn.setForeground(Color.decode("#F4F89A"));
		dataBtn.setBorder(null);
		dataBtn.addActionListener(this);
		p1.add(dataBtn);
		
		
		/*bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/BackGroundA.png")));
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
		else if(ae.getSource()==stockBtn ){
			Stock s = new Stock();
			this.setVisible(false); // making current from invisible
			s.setVisible(true); // making next form visible
		}
		else if(ae.getSource()==signoutBtn){
			Login l = new Login();
			this.setVisible(false); // making current from invisible
			l.setVisible(true); // making next form visible
		}
		else if(ae.getSource()==signoutBtn){
			Login l = new Login();
			this.setVisible(false); // making current from invisible
			l.setVisible(true); // making next form visible
		}
		else if(ae.getSource()==exitBtn){
			System.exit(0);// termination of program
		}	
		else if(ae.getSource()==actBtn){
			openNotepad1();
		}
		else if(ae.getSource()==orderBtn ){
			openNotepad2();
		}
		else if(ae.getSource()==dataBtn){
			openNotepad3();
		}
	}
	
	public void openNotepad1(){
		String filePath = "Data File/Login Data/Login_User_data.txt";
		// Check if Desktop is supported
        if (!Desktop.isDesktopSupported()) {
            JOptionPane.showMessageDialog(this, "Desktop is not supported on this platform.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the Desktop instance
        Desktop desktop = Desktop.getDesktop();

        // Check if the file exists
        File file = new File(filePath);
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "File does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Open the file with Notepad
        try {
            desktop.edit(file);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not open the file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void openNotepad2(){
		String filePath = "Data File/Order/Order_slip_list.txt";
		// Check if Desktop is supported
        if (!Desktop.isDesktopSupported()) {
            JOptionPane.showMessageDialog(this, "Desktop is not supported on this platform.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the Desktop instance
        Desktop desktop = Desktop.getDesktop();

        // Check if the file exists
        File file = new File(filePath);
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "File does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Open the file with Notepad
        try {
            desktop.edit(file);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not open the file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void openNotepad3(){
		String filePath = "Data File/User_registration_data.txt";
		// Check if Desktop is supported
        if (!Desktop.isDesktopSupported()) {
            JOptionPane.showMessageDialog(this, "Desktop is not supported on this platform.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the Desktop instance
        Desktop desktop = Desktop.getDesktop();

        // Check if the file exists
        File file = new File(filePath);
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "File does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Open the file with Notepad
        try {
            desktop.edit(file);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not open the file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminHome frame = new AdminHome();
            frame.setVisible(true);
        });
    }
}
