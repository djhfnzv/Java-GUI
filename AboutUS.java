import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AboutUS extends JFrame implements ActionListener
{
    private JLabel headL,subL,l1,l2,l3,bgL,adminL; //for label
	private JButton exitBtn,prevBtn , medBtn; //button
	private JPanel p1; // panel
	private JTextField usernameTF;
	private JPasswordField passPF;
	private ImageIcon icon; // image icon
	private JTextArea TA; // image icon
	
	
    public AboutUS(){
	super("About us");
		this.setSize(800,500);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.setLocationRelativeTo(null);
		//icon
		icon = new ImageIcon(getClass().getResource("/images/Logo1.png"));
        this.setIconImage(icon.getImage());
		
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
		
		l1 = new JLabel("About us");
		l1.setFont(new Font("Serif",Font.BOLD,20));
		l1.setForeground(Color.black);
		l1.setBounds(325,50,150,20);
		p1.add(l1);
		
		exitBtn = new JButton(new ImageIcon(getClass().getResource("/Images/exit.png")));
		exitBtn.setBackground(null);
		exitBtn.setBorder(null);
	    exitBtn.setBounds(720,5,61,41);
 	    exitBtn.addActionListener(this);
	    p1.add(exitBtn);
		
		prevBtn = new JButton(new ImageIcon(getClass().getResource("/Images/back.png")));
		prevBtn.setBounds(60,410,41,41);
		prevBtn.setBackground(null);
		prevBtn.setBorder(null);
		prevBtn.addActionListener(this);
		p1.add(prevBtn);
		

		bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/Abtus.png")));
	    bgL.setBounds(0,0,800,500);
	    p1.add(bgL);
	   
	    
		this.add(p1);	
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==exitBtn){
			System.exit(0);// termination of program 
		}
		else if(ae.getSource()==prevBtn){
			Home h = new Home();
			this.setVisible(false);
			h.setVisible(true); 
		}
	}
}