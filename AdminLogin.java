import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AdminLogin extends JFrame implements ActionListener
{
    private JLabel headL,subL,l1,l2,l3,bgL,adminL; //for label
	private JButton exitBtn, loginBtn ,prevBtn,adminBtn ; //button
	private JPanel p1; // panel
	private JTextField usernameTF;
	private JPasswordField passPF;
	private ImageIcon icon; // image icon
	private JCheckBox showpass;
	
    public AdminLogin(){
	super("Admin Login");
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
		
		headL = new JLabel("Login to MedLife");
		headL.setFont(new Font("Serif",Font.BOLD,30));
		headL.setForeground(Color.black);
		headL.setBounds(280,70,250,50);
		p1.add(headL);
		
		subL = new JLabel("Enter as ADMIN");
		subL.setFont(new Font("Serif",Font.PLAIN,15));
		subL.setForeground(Color.red);
		subL.setBounds(330,130,150,20);
		p1.add(subL);
		
		l1 = new JLabel("Username :");
		l1.setFont(new Font("Serif",Font.BOLD,16));
		l1.setForeground(Color.black);
		l1.setBounds(250,160,80,20);
		p1.add(l1);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(340,160,210,30);
		new TextPrompt("    Enter Username", usernameTF);
		p1.add(usernameTF);
		
		l2 = new JLabel("Password :");
		l2.setFont(new Font("Serif",Font.BOLD,16));
		l2.setForeground(Color.black);
		l2.setBounds(250,210,80,20);
		p1.add(l2);
		
		passPF = new JPasswordField();
		passPF.setBounds(340,210,210,30);
		new TextPrompt("    Enter Password", passPF);
		p1.add(passPF);
		
		showpass = new JCheckBox("Show Password");
		showpass.setBounds(560,210,150,30);
		showpass.setForeground(Color.BLACK);
		showpass.setOpaque(false);
		showpass.addActionListener(this);
		p1.add(showpass);
		
		//button
	   // exitBtn = new JButton("EXIT");
	    exitBtn = new JButton(new ImageIcon(getClass().getResource("/Images/exit.png")));
		exitBtn.setBackground(null);
		exitBtn.setBorder(null);
	    exitBtn.setBounds(720,5,61,41);
 	    exitBtn.addActionListener(this);
	    p1.add(exitBtn);
		
		loginBtn = new JButton(new ImageIcon(getClass().getResource("/Images/Asset 29mdpi.png")));
	    loginBtn.setBorder(null);
	    loginBtn.setBackground(null);
	    loginBtn.setBounds(350,250,101,31);
	    p1.add(loginBtn);
		loginBtn.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent ae){
                String username = usernameTF.getText();
                char[] password = passPF.getPassword();
				if(username.isEmpty() || password.length == 0 ){
					JOptionPane.showMessageDialog(p1, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
                boolean loggedIn = checkLoginData(username, password);
                if(loggedIn){
                    JOptionPane.showMessageDialog(p1, "Welcome back Admin!", "MedLife - Admin",
					JOptionPane.INFORMATION_MESSAGE);

					AdminLogin.this.setVisible(false);
					new AdminHome();
				}
				else{
                    JOptionPane.showMessageDialog(p1, "Incorrect username or password.", "Error",
					JOptionPane.ERROR_MESSAGE);
                }
            }
        });
			
			
		
		prevBtn = new JButton(new ImageIcon(getClass().getResource("/Images/back.png")));
		prevBtn.setBounds(99,410,41,41);
		prevBtn.setBackground(null);
		prevBtn.setBorder(null);
		prevBtn.addActionListener(this);
		p1.add(prevBtn);
		
		bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/BackGround (2).png")));
	    bgL.setBounds(0,0,800,500);
	    p1.add(bgL);
	   
	    
		this.add(p1);	
	}
	
	public boolean checkLoginData(String username, char[] password){
		try{
			File file = new File("Data File/Admin_data.txt");
			FileReader reader = new FileReader(file);
			BufferedReader bufferReader = new BufferedReader(reader);

			String line;
			while ((line = bufferReader.readLine()) != null) {
				if (line.startsWith("Username")){
					String[] data = line.split(":");
					if (data.length == 2 && data[1].trim().equals(username)) {
						line = bufferReader.readLine(); // read next line (password)
						data = line.split(":");
						if (data.length == 2 && data[1].trim().equals(new String(password))) {
							bufferReader.close();
							return true;
						}
					}
				}
			}

			bufferReader.close();
		} 
		catch (IOException e){
        JOptionPane.showMessageDialog(p1, "Failed to read sign up data.", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
		}

		return false;
	}

	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==exitBtn){
			System.exit(0);// termination of program 
		}
		else if (ae.getSource() == showpass) {
			if (showpass.isSelected()) {
				passPF.setEchoChar((char) 0);
			}
			else{
				passPF.setEchoChar('•');
			}
		}
		else if(ae.getSource()==prevBtn){
			Login l = new Login();
			this.setVisible(false);
			l.setVisible(true);
		}
	}
}