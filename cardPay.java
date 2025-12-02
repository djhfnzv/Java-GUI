import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.*;
import java.io.*;

public class cardPay extends JFrame implements ActionListener
{
	private JPanel p1;
	private JLabel bgL  ,cardNumL , pinL, codeL;
	private JTextField  cardTF;
	private JPasswordField pinPF, codePF;
	private ImageIcon icon;
	private JButton medBtn,prevBtn,myprofileBtn,signoutBtn, exitBtn ,homeBtn,porderBtn,orderBtn,cartBtn;
	private ButtonGroup bg;
	private JRadioButton visa,master,discover,amexp;
	
	public cardPay()
	{ super("Card payment");
		this.setSize(800,500); //	Setting the size
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setVisible(true);
		this.setResizable(false); // false for disable resize option
		//icon
		icon = new ImageIcon(getClass().getResource("/images/Logo1.png"));
        this.setIconImage(icon.getImage());
		
		// panel
		p1 = new JPanel();
		p1.setSize(new Dimension(800,500)); //	setting the panel Size
		p1.setBackground(Color.decode("#EED5C7"));//	color selection
		p1.setLayout(null); //	for customization
		
		medBtn = new JButton(new ImageIcon(getClass().getResource("/Images/medLife2.gif")));
		medBtn.setBackground(null);
		medBtn.setBorder(null);
		medBtn.setBounds(5,5,200,41);
		//medBtn.addActionListener(this);
		p1.add(medBtn);
		
		exitBtn = new JButton(new ImageIcon(getClass().getResource("/Images/exit.png")));
		exitBtn.setBackground(null);
		exitBtn.setBorder(null);
	    exitBtn.setBounds(720,5,61,41);
 	    exitBtn.addActionListener(this);
	    p1.add(exitBtn);
		
		homeBtn = new JButton(new ImageIcon(getClass().getResource("/Images/home.png")));
		homeBtn.setBounds(380,410,41,41);
		homeBtn.setBackground(null);
		homeBtn.setBorder(null);
		homeBtn.addActionListener(this);
		p1.add(homeBtn);
		
		// Radio button:
		visa = new JRadioButton();
		visa.setBounds(85, 83, 150, 100);
		visa.setBackground(null);
		visa.setOpaque(false);
		p1.add(visa);
		
		master = new JRadioButton();
		master.setBounds(262, 83, 150, 100);
		master.setBackground(null);
		master.setOpaque(false);
		p1.add(master);
		
		discover = new JRadioButton();
		discover.setBounds(420, 83, 150, 100);
		discover.setBackground(null);
		discover.setOpaque(false);
		p1.add(discover);
		
		amexp = new JRadioButton();
		amexp.setBounds(590, 83, 150, 100);
		amexp.setBackground(null);
		amexp.setOpaque(false);
		p1.add(amexp);
		
		// using Button group to make only one RadioButton to be selectable
		bg = new ButtonGroup();
		bg.add(visa);
		bg.add(master);
		bg.add(discover);
		bg.add(amexp);
		
		prevBtn = new JButton(new ImageIcon(getClass().getResource("/Images/back.png")));
		prevBtn.setBounds(99,410,41,41);
		prevBtn.setBackground(null);
		prevBtn.setBorder(null);
		prevBtn.addActionListener(this);
		p1.add(prevBtn);
		
		signoutBtn = new JButton(new ImageIcon(getClass().getResource("/Images/signout.png")));
		signoutBtn.setBounds(675,5,41,41);
		signoutBtn.setBackground(null);
		signoutBtn.setBorder(null);
		signoutBtn.addActionListener(this);
		p1.add(signoutBtn);
		
		porderBtn = new JButton(new ImageIcon(getClass().getResource("/Images/placeorder.png")));
		porderBtn.setBounds(629,410,101,41);
		porderBtn.setBackground(null);
		porderBtn.setBorder(null);
		p1.add(porderBtn);
		porderBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String cardNum = cardTF.getText();
                String platform = null;
                if (visa.isSelected()) {
                    platform = "Visa";
                }
				else if (master.isSelected()) {
                    platform = "MasterCard";
                }
				else if (discover.isSelected()) {
                    platform = "Discover Network";
                }
				else if (amexp.isSelected()) {
                    platform = "American Express";
                }

                if (cardNum.isEmpty()||  platform == null) {
                    JOptionPane.showMessageDialog(p1, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String formattedDateTime = currentDateTime.format(formatter);

                paymentDetails(cardNum,platform, formattedDateTime);
				
				ThankYou t = new ThankYou();
				cardPay.this.setVisible(false); // making current from invisible
				t.setVisible(true);
            }
        });
		
		
		orderBtn = new JButton(new ImageIcon(getClass().getResource("/Images/Orders.png")));
		orderBtn.setBounds(239,410,41,41);
		orderBtn.setBackground(null);
		orderBtn.setBorder(null);
		//orderBtn.addActionListener(this);
		p1.add(orderBtn);
		
		cartBtn = new JButton(new ImageIcon(getClass().getResource("/Images/cart.png")));
		cartBtn.setBounds(519,410,41,41);
		cartBtn.setBackground(null);
		cartBtn.setBorder(null);
		cartBtn.addActionListener(this);
		p1.add(cartBtn);
		
		//label
		cardNumL = new JLabel("Card Number :");
		cardNumL.setFont(new Font("Serif",Font.BOLD,15));
		cardNumL.setForeground(Color.black);
		cardNumL.setBounds(190,250,260,30);
		p1.add(cardNumL);
		
		pinL = new JLabel("Pin :");
		pinL.setFont(new Font("Serif",Font.BOLD,15));
		pinL.setForeground(Color.black);
		pinL.setBounds(190,300,60,30);
		p1.add(pinL);
		
		codeL = new JLabel("Code :");
		codeL.setFont(new Font("Serif",Font.BOLD,15));
		codeL.setForeground(Color.black);
		codeL.setBounds(385,300,130,30);
		p1.add(codeL);
		
		//text field 
		cardTF = new JTextField();
		cardTF.setBounds(300,250,280,30);
		new TextPrompt("    Enter Card Number",cardTF);
		p1.add(cardTF);
		
		pinPF = new JPasswordField();
		pinPF.setBounds(240,300,140,30);
		new TextPrompt("    Enter PIN",pinPF);
		p1.add(pinPF);
		
		codePF = new JPasswordField();
		codePF.setBounds(440,300,140,30);
		new TextPrompt("   CVV Code",codePF);
		p1.add(codePF);
		
		bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/card1.png")));
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
		else if(ae.getSource()==porderBtn){
			ThankYou t = new ThankYou();
			this.setVisible(false); // making current from invisible
			t.setVisible(true);
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
	
	public void paymentDetails(String cardNum, String platform,String formattedDateTime) {
        try {
            File file = new File("Data File/Order/Order_slip_list.txt");
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);

            bufferWriter.write(String.format("\n=====    Payment    =====\nType: CARD\nAccount Number     : %s\nPlatform      : %s\nDate & Time   : %s\n=======================================", cardNum, platform, formattedDateTime));
            
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