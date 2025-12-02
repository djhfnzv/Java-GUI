import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ThankYou extends JFrame implements ActionListener
{
	private JPanel p1,p2;
	private JLabel bgL,l1,l2;
	private JButton medBtn,signoutBtn, exitBtn,contBtn ,orderBtn,nextBtn,cartBtn,homeBtn,previousBtn,medicineBtn,instrumentsBtn;
	private ImageIcon icon;
	
	public ThankYou()
	{
		super("Thank You");
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
		
		l1 = new JLabel("Your order has been placed");
		l1.setFont(new Font("Serif",Font.BOLD,20));
		l1.setForeground(Color.red);
		l1.setBounds(300,55,250,40);
		p1.add(l1);
		
		contBtn = new JButton(new ImageIcon(getClass().getResource("/Images/continue.png")));
		contBtn.setBounds(629,410,101,41);
		contBtn.setBackground(null);
		contBtn.setBorder(null);
		contBtn.addActionListener(this);
		p1.add(contBtn);
		
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
		
		l2 = new JLabel(new ImageIcon(getClass().getResource("/Images/end.png")));
	    l2.setBounds(235,90,330,301);
	    p1.add(l2);
		
		bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/BackGround (2).png")));
	    bgL.setBounds(0,0,800,500);
	    p1.add(bgL);
		
		this.add(p1);	
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==homeBtn || ae.getSource()==contBtn){
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
		else if(ae.getSource()==exitBtn){
			System.exit(0);// termination of program
		}
	}
}