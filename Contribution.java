import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Contribution  extends JFrame implements ActionListener
{
    
	private JButton exitBtn,prevBtn,medBtn ; //button
	private JPanel p1; // panel
	private ImageIcon icon; // image icon
	private JLabel bgL;
	
	
    public Contribution(){
	super("Contribution");
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
		

		bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/Contribution1.png")));
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