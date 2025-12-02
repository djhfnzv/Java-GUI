import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.*;
import java.io.*;

public class PaymentOnline extends JFrame implements ActionListener
{
	private JPanel p1;
	private JLabel bgL  ,mobL , pinL;
	private JTextField  mobTF;
	private JPasswordField pinPF;
	private ImageIcon icon;
	private JRadioButton bkash,nagad,rocket ; //	RadioButton r
	private ButtonGroup bg; //	ButtonGroup bg
	private JButton medBtn,prevBtn,signoutBtn, exitBtn, orderBtn,cartBtn,homeBtn,porderBtn;
	
	public PaymentOnline()
	{
		super("Online Payment");
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
		
		// Radio button:
		bkash = new JRadioButton();
		bkash.setBounds(67, 120, 181, 81);
		bkash.setBackground(null);
		bkash.setOpaque(false);
		p1.add(bkash);
		
		nagad = new JRadioButton();
		nagad.setBounds(309, 120, 181, 81);
		nagad.setBackground(null);
		nagad.setOpaque(false);
		p1.add(nagad);
		
		rocket = new JRadioButton();
		rocket.setBounds(551, 120, 181, 81);
		rocket.setBackground(null);
		rocket.setOpaque(false);
		p1.add(rocket);
		
		// using Button group to make only one RadioButton to be selectable
		bg = new ButtonGroup();
		bg.add(bkash);
		bg.add(nagad);
		bg.add(rocket);		

		mobL = new JLabel("Account Number	:");
		mobL.setFont(new Font("Serif",Font.BOLD,15));
		mobL.setForeground(Color.black);
		mobL.setBounds(190,260,130,30);
		p1.add(mobL);
		
		mobTF = new JTextField();
		mobTF.setBounds(320,260,280,30);
		new TextPrompt("    Account (01XXXX-XXXXX)", 	mobTF);
		p1.add(mobTF);
		
		//label for confirm password
		pinL = new JLabel("	Enter PIN		:");
		pinL.setFont(new Font("Serif",Font.BOLD,15));
		pinL.setForeground(Color.black);
		pinL.setBounds(190,300,130,30);
		p1.add(pinL);
		
		pinPF = new JPasswordField();
		pinPF.setBounds(320,300,280,30);
		new TextPrompt("    Enter the PIN",pinPF);
		p1.add(pinPF);
		
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
		
		porderBtn = new JButton(new ImageIcon(getClass().getResource("/Images/placeorder.png")));
		porderBtn.setBounds(629,410,101,41);
		porderBtn.setBackground(null);
		porderBtn.setBorder(null);
		p1.add(porderBtn);
		porderBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String accNumber = mobTF.getText();
                String pin = pinPF.getText();
                String platform = null;
                if (bkash.isSelected()) {
                    platform = "Bkash";
                }
				else if (nagad.isSelected()) {
                    platform = "Nagad";
                }
				else if (rocket.isSelected()) {
                    platform = "Rocket";
                }

                if (accNumber.isEmpty()|| accNumber.isEmpty() || platform == null) {
                    JOptionPane.showMessageDialog(p1, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String formattedDateTime = currentDateTime.format(formatter);

                paymentDetails(accNumber,platform, formattedDateTime);
				
				ThankYou t = new ThankYou();
				PaymentOnline.this.setVisible(false); // making current from invisible
				t.setVisible(true);
            }
        });
		
		bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/onlinepay.png")));
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
		else if(ae.getSource()==prevBtn){
			PaymentMethod p = new PaymentMethod();
			this.setVisible(false); // making current from invisible
			p.setVisible(true);
		}
		else if(ae.getSource()==exitBtn){
			System.exit(0);// termination of program
		}
	}
	
	public void paymentDetails(String accNumber, String platform,String formattedDateTime) {
        try {
            File file = new File("Data File/Order/Order_slip_list.txt");
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);

            bufferWriter.write(String.format("\n=====    Payment    =====\nType: Online Banking\nAccount Number     : %s\nPlatform      : %s\nDate & Time   : %s\n=======================================", accNumber, platform, formattedDateTime));
           
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