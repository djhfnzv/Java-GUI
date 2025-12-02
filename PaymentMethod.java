import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.*;
import java.io.*;

public class PaymentMethod extends JFrame implements ActionListener
{
	private JPanel p1,p2;
	private JLabel bgL,l1,l2;
	private JButton medBtn,signoutBtn, exitBtn,ckoutBtn ,orderBtn,prcdBtn,nextBtn,cartBtn,homeBtn,prevBtn,medicineBtn,instrumentsBtn, cardBtn, ObBtn ,codBtn;
	private ImageIcon icon;
	//private JRadioButton r1 ,r2,r3 ;
	private ButtonGroup bg; 
	
	public PaymentMethod()
	{
		super("Check Out 1");
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
		
		cardBtn = new JButton("Credit/Debit Card");
		cardBtn.setBackground(null);
		cardBtn.setBorder(null);
	    cardBtn.setBounds(120,270,151,30);
 	    cardBtn.addActionListener(this);
	    p1.add(cardBtn);
		
		ObBtn  = new JButton("Online Banking");
		ObBtn .setBackground(null);
		ObBtn .setBorder(null);
	    ObBtn .setBounds(340,270,151,30);
 	    ObBtn .addActionListener(this);
	    p1.add(ObBtn );
		
		codBtn  = new JButton("Cash On Delivery ");
		codBtn.setBackground(null);
		codBtn .setBorder(null);
	    codBtn .setBounds(560,270,151,30);
		p1.add(codBtn);
 	    codBtn .addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String formattedDateTime = currentDateTime.format(formatter);

                paymentDetails(formattedDateTime);
				
				ThankYou t = new ThankYou();
				PaymentMethod.this.setVisible(false); // making current from invisible
				t.setVisible(true);
            }
        });
	    
		
		l1 = new JLabel("Choose Payment Method");
		l1.setFont(new Font("Serif",Font.BOLD,20));
		l1.setForeground(Color.red);
		l1.setBounds(300,55,250,40);
		p1.add(l1);

		l2 = new JLabel("For cash on delivery additional 10tk will be included with the bill");
		l2.setFont(new Font("Serif",Font.BOLD,14));
		l2.setForeground(Color.red);
		l2.setBounds(220,350,500,30);
		p1.add(l2);
		
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
		p1.add(orderBtn);
		//orderBtn.addActionListener(this);
		
		
		prevBtn = new JButton(new ImageIcon(getClass().getResource("/Images/back.png")));
		prevBtn.setBounds(99,410,41,41);
		prevBtn.setBackground(null);
		prevBtn.setBorder(null);
		prevBtn.addActionListener(this);
		p1.add(prevBtn);	
		
		bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/PayME3.png")));
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
		else if(ae.getSource()==cartBtn){
			Cart c = new Cart();
			this.setVisible(false); // making current from invisible
			c.setVisible(true);
		}
		else if(ae.getSource()==exitBtn){
			System.exit(0);// termination of program
		}
		else if(ae.getSource()==prevBtn){
			Cart c = new Cart();
			this.setVisible(false); // making current from invisible
			c.setVisible(true);
		}
		else if(ae.getSource()==ObBtn){
			PaymentOnline p= new PaymentOnline();
			this.setVisible(false); // making current from invisible
			p.setVisible(true);
		}
		else if(ae.getSource()==cardBtn){
			cardPay p= new cardPay();
			this.setVisible(false); // making current from invisible
			p.setVisible(true);
		}
	}
	
	public void paymentDetails(String formattedDateTime) {
        try {
            File file = new File("Data File/Order/Order_slip_list.txt");
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);

            bufferWriter.write(String.format("\n=====    Payment    =====\nType: COD\nAccount Number     : N/A\nPlatform      : COD\nDate & Time   : \n=======================================",formattedDateTime));
           
   		    System.out.println("Payment slip generated successfully.");
			
			bufferWriter.newLine();
            bufferWriter.close();
            JOptionPane.showMessageDialog(p1, "Transaction successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
			
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(p1, "Failed to save sign up data.", "Error", JOptionPane.ERROR_MESSAGE);
            ioe.printStackTrace();
        }
    }
} 