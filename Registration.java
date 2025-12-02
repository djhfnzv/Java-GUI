import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;
import java.time.format.*;

public class Registration extends JFrame implements ActionListener {
    private JPanel p1;
    private JLabel genderL, headL, nameL, ageL, mobL, mailL, addL, epassL, conpassL, bgL, l;
    private JTextField nameTF, ageTF, mobTF, mailTF, addTF;
    private JPasswordField epassPF, conpassPF;
    private JButton regBtn, exitBtn, prevBtn;
    private ImageIcon icon;
    private JRadioButton male, female;
    private ButtonGroup bg;
    private JCheckBox showpass;

    public Registration() {
        super("Registration");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setVisible(true);
        this.setResizable(false);
        
        icon = new ImageIcon(getClass().getResource("/images/Logo1.png"));
        this.setIconImage(icon.getImage());

        p1 = new JPanel();
        p1.setSize(new Dimension(800, 500));
        p1.setBackground(Color.decode("#B3CDC7"));
        p1.setLayout(null);

        headL = new JLabel("Creating a new account");
        headL.setFont(new Font("Serif", Font.BOLD, 30));
        headL.setForeground(Color.black);
        headL.setBounds(250, 20, 500, 50);
        p1.add(headL);

        exitBtn = new JButton(new ImageIcon(getClass().getResource("/Images/exit.png")));
        exitBtn.setBackground(null);
        exitBtn.setBorder(null);
        exitBtn.setBounds(720, 5, 61, 41);
        exitBtn.addActionListener(this);
        p1.add(exitBtn);
		
		prevBtn = new JButton(new ImageIcon(getClass().getResource("/Images/back.png")));
		prevBtn.setBounds(99,410,41,41);
		prevBtn.setBackground(null);
		prevBtn.setBorder(null);
		prevBtn.addActionListener(this);
		p1.add(prevBtn);

        nameL = new JLabel("Name:");
        nameL.setFont(new Font("Serif", Font.BOLD, 15));
        nameL.setForeground(Color.black);
        nameL.setBounds(190, 80, 130, 30);
        p1.add(nameL);

        nameTF = new JTextField();
        nameTF.setBounds(320, 80, 280, 30);
        new TextPrompt("    Enter Name", nameTF);
        p1.add(nameTF);

        l = new JLabel("** Your name is your UserName **");
        l.setFont(new Font("Serif", Font.PLAIN, 12));
        l.setForeground(Color.red);
        l.setBounds(610, 80, 190, 50);
        p1.add(l);

        genderL = new JLabel("Gender:");
        genderL.setFont(new Font("Serif", Font.BOLD, 15));
        genderL.setForeground(Color.black);
        genderL.setBounds(190, 115, 130, 30);
        p1.add(genderL);

        male = new JRadioButton("Male");
        male.setBounds(320, 115, 100, 30);
        male.setBackground(null);
        male.setOpaque(false);
        p1.add(male);

        female = new JRadioButton("Female");
        female.setBounds(500, 115, 100, 30);
        female.setBackground(null);
        female.setOpaque(false);
        p1.add(female);

        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        ageL = new JLabel("Age:");
        ageL.setFont(new Font("Serif", Font.BOLD, 15));
        ageL.setForeground(Color.black);
        ageL.setBounds(190, 150, 130, 30);
        p1.add(ageL);

        ageTF = new JTextField();
        ageTF.setBounds(320, 150, 280, 30);
        new TextPrompt("    Registration under age of 18 is prohibited !!", ageTF);
        p1.add(ageTF);

        mobL = new JLabel("Mobile Number:");
        mobL.setFont(new Font("Serif", Font.BOLD, 15));
        mobL.setForeground(Color.black);
        mobL.setBounds(190, 190, 130, 30);
        p1.add(mobL);

        mobTF = new JTextField();
        mobTF.setBounds(320, 190, 280, 30);
        new TextPrompt("    Enter Mobile Number: (+8801*********)", mobTF);
        p1.add(mobTF);

        mailL = new JLabel("Mail:");
        mailL.setFont(new Font("Serif", Font.BOLD, 15));
        mailL.setForeground(Color.black);
        mailL.setBounds(190, 230, 130, 30);
        p1.add(mailL);

        mailTF = new JTextField();
        mailTF.setBounds(320, 230, 280, 30);
        new TextPrompt("    Enter Mail: ****@*****.com", mailTF);
        p1.add(mailTF);

        addL = new JLabel("Address:");
        addL.setFont(new Font("Serif", Font.BOLD, 15));
        addL.setForeground(Color.black);
        addL.setBounds(190, 270, 130, 30);
        p1.add(addL);

        addTF = new JTextField();
        addTF.setBounds(320, 270, 280, 30);
        new TextPrompt("    Enter Address", addTF);
        p1.add(addTF);

        epassL = new JLabel("Enter Password:");
        epassL.setFont(new Font("Serif", Font.BOLD, 15));
        epassL.setForeground(Color.black);
        epassL.setBounds(190, 310, 130, 30);
        p1.add(epassL);

        epassPF = new JPasswordField();
        epassPF.setBounds(320, 310, 280, 30);
        new TextPrompt("    Enter a password", epassPF);
        p1.add(epassPF);

        conpassL = new JLabel("Confirm Password:");
        conpassL.setFont(new Font("Serif", Font.BOLD, 15));
        conpassL.setForeground(Color.black);
        conpassL.setBounds(190, 350, 130, 30);
        p1.add(conpassL);

        conpassPF = new JPasswordField();
        conpassPF.setBounds(320, 350, 280, 30);
        new TextPrompt("    Re-enter Password", conpassPF);
        p1.add(conpassPF);

        showpass = new JCheckBox("Show Password");
        showpass.setBounds(610, 310, 150, 30);
        showpass.setForeground(Color.BLACK);
        showpass.setOpaque(false);
        showpass.addActionListener(this);
        p1.add(showpass);

        regBtn = new JButton(new ImageIcon(getClass().getResource("/Images/Asset 27mdpi.png")));
        regBtn.setBorder(null);
        regBtn.setBackground(null);
        regBtn.setBounds(350, 390, 101, 31);
        regBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String name = nameTF.getText();
                char[] password = conpassPF.getPassword();
                String gender = null;
                if (male.isSelected()) {
                    gender = "Male";
                } else if (female.isSelected()) {
                    gender = "Female";
                }
                String age = ageTF.getText();
                String mobile = mobTF.getText();
                String email = mailTF.getText();
                String address = addTF.getText();

                if (name.isEmpty() || password.length == 0 || mobile.isEmpty() || email.isEmpty() || address.isEmpty() || gender == null) {
                    JOptionPane.showMessageDialog(p1, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String formattedDateTime = currentDateTime.format(formatter);

                registerUserData(name, password, gender, age, mobile, email, address, formattedDateTime);
            }
        });
        p1.add(regBtn);

        bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/RegistrationPage.png")));
        bgL.setBounds(0, 0, 800, 500);
        p1.add(bgL);

        this.add(p1);
    }

    public void registerUserData(String name, char[] password, String gender, String age, String mobile, String email, String address, String formattedDateTime) {
        try {
            File file = new File("Data File/User_registration_data.txt");
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);

            bufferWriter.write("\n" + "		USER LOGIN DATA		" + "\n" + "\nName          : " + name + "\nPassword      : " + new String(password) + "\nGender        : " + gender + "\nAge           : " + age + "\nMobile Number : " + mobile + "\nEmail Address : " + email + "\nAddress       : " + address + "\nDate & Time   : " + formattedDateTime + "\n=======================================");
            bufferWriter.newLine();
            bufferWriter.close();
            JOptionPane.showMessageDialog(p1, "Sign up successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

            Registration.this.setVisible(false);
            new Login();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(p1, "Failed to save sign up data.", "Error", JOptionPane.ERROR_MESSAGE);
            ioe.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == showpass) {
            if (showpass.isSelected()) {
                epassPF.setEchoChar((char) 0);
                conpassPF.setEchoChar((char) 0);
            } else {
                epassPF.setEchoChar('•');
                conpassPF.setEchoChar('•');
            }
        } else if (ae.getSource() == exitBtn) {
            System.exit(0);
        } else if (ae.getSource() == prevBtn) {
            Login l = new Login();
            this.setVisible(false);
            l.setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Registration();
    }
}
