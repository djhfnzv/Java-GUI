import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FaceMask extends JFrame implements ActionListener
{
	private JPanel p1; //	JPanel p;
	private JButton medBtn,addBtn, signoutBtn , exitBtn, orderBtn,cartBtn, homeBtn ,prevBtn, aBtn, bBtn, cBtn, dBtn, eBtn, fBtn ,gBtn , hBtn;// button name need to upload 
	private JLabel  bgL, catagL;// in pannel 2 1st corner 
	private ImageIcon icon;
	
	public FaceMask(){
		super("Face-Mask");
		this.setSize(800,500); //	Setting the size
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setVisible(true);
		this.setResizable(false); // false for disable resize option
		//icon
		icon = new ImageIcon(getClass().getResource("/images/Logo1.png"));
        this.setIconImage(icon.getImage());
		
		p1 = new JPanel();
		p1.setSize(new Dimension(800,500)); //	setting the panel Size
		p1.setBackground(Color.decode("#B3CDC7"));//	color selection
		p1.setLayout(null);
		
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
		addBtn.addActionListener(this);
		p1.add(addBtn);
		
		bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/Face-Mask.png")));
	    bgL.setBounds(0,0,800,500);
	    p1.add(bgL);
		
		this.add(p1);
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
		else if(ae.getSource()==addBtn){
			JOptionPane.showMessageDialog(this, "Face Mask has been added to your cart","MedLife",-1);
			
			this.setVisible(false);
			Cart c = new Cart();
			c.addToCart("Beximco Surgical Mask", "1" , "400");
			c.setVisible(false);
			new Instrument();
		}
		else if(ae.getSource()==prevBtn){
			Instrument h= new Instrument();
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