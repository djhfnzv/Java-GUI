import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

public class Order extends JFrame implements ActionListener
{
	private JPanel p1,p2;
	private JLabel bgL,orderL, l1, l2,l3,l4,l5,l6;;
	private JButton homeBtn, signoutBtn, exitBtn, prevBtn;
	private ImageIcon icon;
	private String line1,line2,line3,line4,line5,line6;
	
	public Order()
	{
		super("Orders");
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
		
		l1 = new JLabel();
        l1.setFont(new Font("Serif",Font.PLAIN | Font.BOLD,20));
        l1.setForeground(Color.black);
        l1.setBounds(190,110,550,30);
        p1.add(l1);
		
		l2 = new JLabel();
        l2.setFont(new Font("Serif",Font.PLAIN | Font.BOLD,20));
        l2.setForeground(Color.black);
        l2.setBounds(190,150,550,30);
        p1.add(l2);
		
		l3 = new JLabel();
        l3.setFont(new Font("Serif",Font.PLAIN | Font.BOLD,20));
        l3.setForeground(Color.black);
        l3.setBounds(190,190,550,30);
        p1.add(l3);
		
		l4 = new JLabel();
        l4.setFont(new Font("Serif",Font.PLAIN | Font.BOLD,20));
        l4.setForeground(Color.black);
        l4.setBounds(190,230,550,30);
        p1.add(l4);
		
		l5 = new JLabel();
        l5.setFont(new Font("Serif",Font.PLAIN | Font.BOLD,20));
        l5.setForeground(Color.black);
        l5.setBounds(190,270,550,30);
        p1.add(l5);
		
		l6 = new JLabel();
        l6.setFont(new Font("Serif",Font.PLAIN | Font.BOLD,20));
        l6.setForeground(Color.black);
        l6.setBounds(190,310,550,30);
        p1.add(l6);
		
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
		
		this.add(p1);	
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader("Data File/Order/Order_slip_list.txt"));
            reader.close();
			
     
			line1 = Files.readAllLines(Paths.get("Data File/Order/Order_slip_list.txt")).get(2);
			line2 = Files.readAllLines(Paths.get("Data File/Order/Order_slip_list.txt")).get(3);
			line3 = Files.readAllLines(Paths.get("Data File/Order/Order_slip_list.txt")).get(4);
			line4 = Files.readAllLines(Paths.get("Data File/Order/Order_slip_list.txt")).get(6);
			line5 = Files.readAllLines(Paths.get("Data File/Order/Order_slip_list.txt")).get(8);
			line6 = Files.readAllLines(Paths.get("Data File/Order/Order_slip_list.txt")).get(9);
			
			l1.setText(line1);
			l2.setText(line2);
			l3.setText(line3);
			l4.setText(line4);
			l5.setText(line5);
			l6.setText(line6);
        }
        catch(IOException ioe){
			ioe.printStackTrace();
		}
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
		else if(ae.getSource()==exitBtn){
			System.exit(0);// termination of program
		}	
	}
}