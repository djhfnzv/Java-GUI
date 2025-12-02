import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserAct extends JFrame implements ActionListener
{
	private JPanel p1,p2;
	private JLabel bgL,searL;
	private JButton homeBtn, signoutBtn, exitBtn, prevBtn, searBtn;
	private ImageIcon icon;
	private JTextField nameTF;
	
	public UserAct()
	{
		super(" User Activity ");
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
		
		searBtn = new JButton(new ImageIcon(getClass().getResource("/Images/search.png")));
		searBtn.setBounds(605,57,41,41);
		searBtn.setBackground(null);
		searBtn.setBorder(null);
		searBtn.addActionListener(this);
		p1.add(searBtn);
		
		searL = new JLabel(" Search For User");
		searL.setFont(new Font("Serif",Font.BOLD,20));
		searL.setForeground(Color.red);
		searL.setBounds(150,50,250,50);
		p1.add(searL);
		
		nameTF = new JTextField();
		nameTF.setBounds(300,60,300,30);
		p1.add(nameTF);
		
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
}