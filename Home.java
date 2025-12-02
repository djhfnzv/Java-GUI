import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener
{
	private JPanel p1,p2;
	private JLabel bgL, l1, l2;
	private JButton medBtn,aboutusBtn,myprofileBtn,signoutBtn, exitBtn, orderBtn,nextBtn,cartBtn,homeBtn,previousBtn,medicineBtn,instrumentsBtn;
	private ImageIcon icon;
	
	public Home()
	{
		super("Home");
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
		p1.setBackground(Color.decode("#D5F4AD"));//	color selection
		p1.setLayout(null); //	for customization
		
		medBtn = new JButton(new ImageIcon(getClass().getResource("/Images/mediBhome1.gif")));
		medBtn.setBackground(null);
		medBtn.setBorder(null);
		medBtn.setBounds(5,5,210,41);
		medBtn.addActionListener(this);
		p1.add(medBtn);
		
		myprofileBtn = new JButton(new ImageIcon(getClass().getResource("/Images/profile.png")));
		myprofileBtn.setBounds(630,5,41,41);
		myprofileBtn.setBackground(null);
		myprofileBtn.setBorder(null);
		myprofileBtn.addActionListener(this);
		p1.add(myprofileBtn);
		
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
		
		medicineBtn = new JButton(new ImageIcon(getClass().getResource("/Images/Medicine.png")));
		medicineBtn.setBackground(null);
		medicineBtn.setBorder(null);
	    medicineBtn.setBounds(105,130,191,191);
 	    medicineBtn.addActionListener(this);
	    p1.add(medicineBtn);
		
		l1 = new JLabel("Medicine");
		l1.setFont(new Font("Serif",Font.BOLD,20));
		l1.setForeground(Color.black);
		l1.setBounds(155,331,100,20);
		p1.add(l1);
		
		instrumentsBtn = new JButton(new ImageIcon(getClass().getResource("/Images/Instrument.png")));
		instrumentsBtn.setBackground(null);
		instrumentsBtn.setBorder(null);
	    instrumentsBtn.setBounds(505,130,191,191);
 	    instrumentsBtn.addActionListener(this);
	    p1.add(instrumentsBtn);		
		
		l2 = new JLabel("Instrument");
		l2.setFont(new Font("Serif",Font.BOLD,20));
		l2.setForeground(Color.black);
		l2.setBounds(555,331,100,20);
		p1.add(l2);
		
		aboutusBtn = new JButton(new ImageIcon(getClass().getResource("/Images/contribute.png")));
		aboutusBtn.setBackground(null);
		aboutusBtn.setBorder(null);
		aboutusBtn.setBounds(99,410,41,41);
		aboutusBtn.addActionListener(this);
		p1.add(aboutusBtn);
		
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
		orderBtn.addActionListener(this);
		p1.add(orderBtn);
		
		bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/HomePage.png")));
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
		else if(ae.getSource()==medicineBtn){
			Medicine m = new Medicine();
			this.setVisible(false); // making current from invisible
			m.setVisible(true);
		}
		else if(ae.getSource()==instrumentsBtn){
			Instrument i = new Instrument();
			this.setVisible(false); // making current from invisible
			i.setVisible(true);
		}
		else if(ae.getSource()==cartBtn){
			Cart c = new Cart();
			this.setVisible(false); // making current from invisible
			c.setVisible(true);
		}
		else if(ae.getSource()==medBtn){
			AboutUS c = new AboutUS();
			this.setVisible(false); // making current from invisible
			c.setVisible(true);
		}
		else if(ae.getSource()==exitBtn){
			System.exit(0);// termination of program
		}
		else if(ae.getSource()==myprofileBtn){
			userProfile c = new userProfile();
			this.setVisible(false); // making current from invisible
			c.setVisible(true);
		}	
		else if(ae.getSource()==aboutusBtn){
			Contribution c = new Contribution();
			this.setVisible(false); // making current from invisible
			c.setVisible(true);
		}
		else if(ae.getSource()==orderBtn){
			Order c = new Order();
			this.setVisible(false); // making current from invisible
			c.setVisible(true);
		}
	}
}