import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Medicine extends JFrame implements ActionListener
{
	private JPanel p1; //	JPanel p;
	private JButton medBtn,aboutusBtn, signoutBtn , exitBtn, orderBtn,cartBtn, homeBtn ,prevBtn, aBtn, bBtn, cBtn, dBtn, eBtn, fBtn ;// button name need to upload 
	private JLabel  bgL,aL,bL,cL,dL,eL,fL;// in pannel 2 1st corner 
	private ImageIcon icon;
	
	public Medicine(){
		super("Medicine Catagory");
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
		p1.setBackground(Color.decode("#E8FAFA"));//	color selection
		p1.setLayout(null); //	for customization
	   
	   // this.setFont(new Font("Serif",Font.BOLD,20));
		
		medBtn = new JButton(new ImageIcon(getClass().getResource("/Images/MedLife1.gif")));
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
		
		aBtn = new JButton(new ImageIcon(getClass().getResource("/Images/a.png")));
		aBtn.setBackground(null);
		aBtn.setBorder(null);
		aBtn.setBounds(102,60,129, 129);
		aBtn.addActionListener(this);
		p1.add(aBtn);
		
		bBtn = new JButton(new ImageIcon(getClass().getResource("/Images/b.png")));
		bBtn.setBackground(null);
		bBtn.setBorder(null);
		bBtn.setBounds(333,60,129, 129);
		bBtn.addActionListener(this);
		p1.add(bBtn);
		
		cBtn = new JButton(new ImageIcon(getClass().getResource("/Images/c.png")));
		cBtn.setBackground(null);
		cBtn.setBorder(null);
		cBtn.setBounds(564,60,129, 129);
		cBtn.addActionListener(this);
		p1.add(cBtn);
		
		dBtn = new JButton(new ImageIcon(getClass().getResource("/Images/d.png")));
		dBtn.setBackground(null);
		dBtn.setBorder(null);
		dBtn.setBounds(102,240,129, 129);
		dBtn.addActionListener(this);
		p1.add(dBtn);
		
		eBtn = new JButton(new ImageIcon(getClass().getResource("/Images/e.png")));
		eBtn.setBackground(null);
		eBtn.setBorder(null);
		eBtn.setBounds(333,240,129, 129);
		eBtn.addActionListener(this);
		p1.add(eBtn);
		
		fBtn = new JButton(new ImageIcon(getClass().getResource("/Images/f.png")));
		fBtn.setBackground(null);
		fBtn.setBorder(null);
		fBtn.setBounds(564,240,129, 129);
		fBtn.addActionListener(this);
		p1.add(fBtn);
		
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
		/// lebel for medicine name :
		aL = new JLabel("Anti-ulcerant ");
		aL.setFont(new Font("Serif",Font.BOLD,20));
		aL.setForeground(Color.black);
		aL.setBounds(110,175,200,50);
		p1.add(aL);
		
		bL = new JLabel("Anti-emitic");
		bL.setFont(new Font("Serif",Font.BOLD,20));
		bL.setForeground(Color.black);
		bL.setBounds(351,175,200,50);
		p1.add(bL);
		
		cL = new JLabel("Anti-histamin");
		cL.setFont(new Font("Serif",Font.BOLD,20));
		cL.setForeground(Color.black);
		cL.setBounds(574,175,200,50);
		p1.add(cL);
		
		dL = new JLabel("Anti-pyretic");
		dL.setFont(new Font("Serif",Font.BOLD,20));
		dL.setForeground(Color.black);
		dL.setBounds(110,355,200,50);
		p1.add(dL);
		
		eL = new JLabel("Painkiller");
		eL.setFont(new Font("Serif",Font.BOLD,20));
		eL.setForeground(Color.black);
		eL.setBounds(351,355,200,50);
		p1.add(eL);
		
		fL = new JLabel("Narcotics");
		fL.setFont(new Font("Serif",Font.BOLD,20));
		fL.setForeground(Color.black);
		fL.setBounds(590,355,200,50);
		p1.add(fL);
		
		bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/MedicineBG.png")));
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
			MedA a = new MedA();
			this.setVisible(false); // making current from invisible
			a.setVisible(true); // making next form visible
		}
		else if(ae.getSource()==bBtn){
			MedB b = new MedB();
			this.setVisible(false); // making current from invisible
			b.setVisible(true); // making next form visible
		}
		else if(ae.getSource()==cBtn){
			MedC c = new MedC();
			this.setVisible(false); // making current from invisible
			c.setVisible(true); // making next form visible
		}
		else if(ae.getSource()==dBtn){
			MedD d = new MedD();
			this.setVisible(false); // making current from invisible
			d.setVisible(true); // making next form visible
		}
		else if(ae.getSource()==eBtn){
			MedE e = new MedE();
			this.setVisible(false); // making current from invisible
			e.setVisible(true); // making next form visible
		}
		else if(ae.getSource()==fBtn){
			MedF f = new MedF();
			this.setVisible(false); // making current from invisible
			f.setVisible(true); // making next form visible
		}
		else if(ae.getSource()==exitBtn){
			System.exit(0);// termination of program
		}
	}
}
