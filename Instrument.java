import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Instrument extends JFrame implements ActionListener
{
	private JPanel p1; //	JPanel p;
	private JButton medBtn,aboutusBtn, signoutBtn , exitBtn, orderBtn,cartBtn, homeBtn ,prevBtn, aBtn, bBtn, cBtn, dBtn, eBtn, fBtn ,gBtn , hBtn;// button name need to upload 
	private JLabel  bgL;// in pannel 2 1st corner 
	private ImageIcon icon;
	
	public Instrument(){
		super("Instruments");
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
		p1.setBackground(Color.decode("#B3CDC7"));//	color selection
		p1.setLayout(null); //	for customization
		
		medBtn = new JButton(new ImageIcon(getClass().getResource("/Images/mediBinstu1.gif")));
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
		
		aBtn = new JButton(" Bandage ");
		aBtn.setBackground(Color.decode("#ECDCB9"));
		aBtn.setBorder(null);
	    aBtn.setBounds(70,185,80,31);
 	    aBtn.addActionListener(this);
	    p1.add(aBtn);
		
		bBtn = new JButton("Stethoscope ");
		bBtn.setBackground(Color.decode("#ECDCB9"));
		bBtn.setBorder(null);
	    bBtn.setBounds(260,185,80,31);
 	    bBtn.addActionListener(this);
	    p1.add(bBtn);
		
		cBtn = new JButton("Bp Machine ");
		cBtn.setBackground(Color.decode("#ECDCB9"));
		cBtn.setBorder(null);
	    cBtn.setBounds(475,185,80,31);
 	    cBtn.addActionListener(this);
	    p1.add(cBtn);
		
		dBtn = new JButton("Glucometer");
		dBtn.setBackground(Color.decode("#ECDCB9"));
		dBtn.setBorder(null);
	    dBtn.setBounds(650,185,80,31);
 	    dBtn.addActionListener(this);
	    p1.add(dBtn);
		
		eBtn = new JButton("Thermometer");
		eBtn.setBackground(Color.decode("#ECDCB9"));
		eBtn.setBorder(null);
	    eBtn.setBounds(70,360,80,31);
 	    eBtn.addActionListener(this);
	    p1.add(eBtn);
		
		fBtn = new JButton("syringe");
		fBtn.setBackground(Color.decode("#ECDCB9"));
		fBtn.setBorder(null);
	    fBtn.setBounds(260,360,80,31);
 	    fBtn.addActionListener(this);
	    p1.add(fBtn);
		
		gBtn = new JButton("Face Mask");
		gBtn.setBackground(Color.decode("#ECDCB9"));
		gBtn.setBorder(null);
	    gBtn.setBounds(475,360,80,31);
 	    gBtn.addActionListener(this);
	    p1.add(gBtn);
		
		hBtn = new JButton("Gloves ");
		hBtn.setBackground(Color.decode("#ECDCB9"));
		hBtn.setBorder(null);
	    hBtn.setBounds(650,360,80,31);
 	    hBtn.addActionListener(this);
	    p1.add(hBtn);
		
		homeBtn = new JButton(new ImageIcon(getClass().getResource("/Images/home.png")));
		homeBtn.setBounds(380,410,61,41);
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
		
		bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/instu.png")));
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
		else if(ae.getSource()==prevBtn){
			Home h= new Home();
			this.setVisible(false); // making current from invisible
			h.setVisible(true);
		}
		else if(ae.getSource()==cartBtn){
			Cart c = new Cart();
			this.setVisible(false); // making current from invisible
			c.setVisible(true);
		}
		
		else if(ae.getSource()==aBtn){
			Bandage b = new Bandage();
			this.setVisible(false); // making current from invisible
			b.setVisible(true);
		}
		else if(ae.getSource()==bBtn){
			Stethoscope c = new Stethoscope();
			this.setVisible(false); // making current from invisible
			c.setVisible(true);
		}
		else if(ae.getSource()==cBtn){
			BpMachine m = new BpMachine();
			this.setVisible(false); // making current from invisible
			m.setVisible(true);
		}
		else if(ae.getSource()==dBtn){
			Glucometer g = new Glucometer();
			this.setVisible(false); // making current from invisible
			g.setVisible(true);
		}
		
		else if(ae.getSource()==eBtn){
			Thermometer c = new Thermometer();
			this.setVisible(false); // making current from invisible
			c.setVisible(true);
		}
		else if(ae.getSource()==fBtn){
			Syringe c = new Syringe();
			this.setVisible(false); // making current from invisible
			c.setVisible(true);
		}
		else if(ae.getSource()==gBtn){
			FaceMask m = new FaceMask();
			this.setVisible(false); // making current from invisible
			m.setVisible(true);
		}
		else if(ae.getSource()==hBtn){
			HandGloves c = new HandGloves();
			this.setVisible(false); // making current from invisible
			c.setVisible(true);
		}
		else if(ae.getSource()==exitBtn){
			System.exit(0);// termination of program
		}
	}
}