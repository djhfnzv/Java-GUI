import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;
import java.time.format.*;

public class Login extends JFrame implements ActionListener
{
    private JLabel headL,subL,l1,l2,l3,bgL,adminL; //for label
	private JButton exitBtn, loginBtn ,regBtn,adminBtn ; //button
	private JPanel p1; // panel
	private JTextField usernameTF;
	private JPasswordField passPF;
	private ImageIcon icon; // image icon
	private JCheckBox showpass;
	
	
    public Login(){
	super("Login");
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
		p1.setBackground(Color.decode("#4FBDC2"));//	color selection
		p1.setLayout(null); //	for customization
		
		adminL = new JLabel("Are you an Admin?");
		adminL.setFont(new Font("Serif",Font.PLAIN,15));
		adminL.setForeground(Color.black);
		adminL.setBounds(580,50,120,20);
		p1.add(adminL);
		
		headL = new JLabel("Login to MedLife");
		headL.setFont(new Font("Serif",Font.BOLD,30));
		headL.setForeground(Color.black);
		headL.setBounds(280,70,250,50);
		p1.add(headL);
		
		subL = new JLabel("Enter Username and password to login");
		subL.setFont(new Font("Serif",Font.PLAIN,15));
		subL.setForeground(Color.red);
		subL.setBounds(280,130,250,20);
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
		
		l3 = new JLabel("Doesn't have an account ? Please Resgister first");
		l3.setFont(new Font("Serif",Font.BOLD,16));
		l3.setForeground(Color.black);
		l3.setBounds(240,310,330,20);
		p1.add(l3);
		
		//button
	   // exitBtn = new JButton("EXIT");
	    exitBtn = new JButton(new ImageIcon(getClass().getResource("/Images/exit.png")));
		exitBtn.setBackground(null);
		exitBtn.setBorder(null);
	    exitBtn.setBounds(720,5,61,41);
 	    exitBtn.addActionListener(this);
	    p1.add(exitBtn);
		
		adminBtn = new JButton("Click here");
		adminBtn.setBackground(null);
		adminBtn.setBorder(null);
		adminBtn.setForeground(Color.red);
		adminBtn.setFont(new Font("Serif",Font.BOLD,15));
	    adminBtn.setBounds(705,50,75,20);
 	    adminBtn.addActionListener(this);
	    p1.add(adminBtn);
		
		showpass = new JCheckBox("Show Password");
		showpass.setBounds(560,210,150,30);
		showpass.setForeground(Color.BLACK);
		showpass.setOpaque(false);
		showpass.addActionListener(this);
		p1.add(showpass);
		
		loginBtn = new JButton(new ImageIcon(getClass().getResource("/Images/Asset 29mdpi.png")));
	    loginBtn.setBorder(null);
	    loginBtn.setBackground(Color.decode("#FFFFFF"));
	    loginBtn.setBounds(350,250,101,31);
	    p1.add(loginBtn);
		
	    loginBtn.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent ae) {
                String username = usernameTF.getText();
                char[] password = passPF.getPassword();
                boolean loggedIn = checkLoginData(username, password);
                if (loggedIn){
                    JOptionPane.showMessageDialog(p1, "Log in successful!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
					
			        Login.this.setVisible(false);
                   	new Home();
				}			
                else{
                    JOptionPane.showMessageDialog(p1, "Incorrect username or password.", "Error",
                    JOptionPane.ERROR_MESSAGE);
                }
				
				LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String formattedDateTime = currentDateTime.format(formatter);

                loginUserData(username, password,formattedDateTime);
            }
        });

		
		regBtn = new JButton(new ImageIcon(getClass().getResource("/Images/Asset 27mdpi.png")));
	    regBtn.setBorder(null);
		regBtn.setBackground(Color.decode("#FFFFFF"));
	    regBtn.setBounds(350,340,101,31);
	    regBtn.addActionListener(this);
	    p1.add(regBtn);	
		
		bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/Login.png")));
	    bgL.setBounds(0,0,800,500);
	    p1.add(bgL);
	   
	    
		this.add(p1);
	}
	
	public boolean checkLoginData(String name, char[] password){
		try{
			File file = new File("Data File/User_registration_data.txt");
			FileReader reader = new FileReader(file);
			BufferedReader bufferReader = new BufferedReader(reader);

			String line;
			while((line = bufferReader.readLine()) != null){
				if (line.startsWith("Name")){
					String[] data = line.split(":");
					if (data.length == 2 && data[1].trim().equals(name)) {
						line = bufferReader.readLine(); // read next line (password)
						data = line.split(":");
						if(data.length == 2 && data[1].trim().equals(new String(password))){
							bufferReader.close();
							return true;
						}
					}
				}
			}
			bufferReader.close();
		}
		catch(IOException ioe){
			JOptionPane.showMessageDialog(p1, "Failed to read sign up data.", "Error", JOptionPane.ERROR_MESSAGE);
			ioe.printStackTrace();
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
		else if(ae.getSource()==regBtn){
			Registration r = new Registration();
			this.setVisible(false);
			r.setVisible(true);
		}
		else if(ae.getSource()==adminBtn){
			AdminLogin a = new AdminLogin();
			this.setVisible(false);
			a.setVisible(true);
		}
	}
	
	public void loginUserData(String username, char[] password,String formattedDateTime) {
        try {
            File file = new File("Data File/Login data/Login_User_data.txt");
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);

            bufferWriter.write("\n" + "=====     USER ACTIVITY     ====" + "\n" + "\nName          : " + username + "\nPassword      : " + new String(password) + "\nDate &Time   : " + formattedDateTime + "\n=======================================");
            bufferWriter.newLine();
            bufferWriter.close();
        } 
		catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}