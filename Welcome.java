import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Welcome extends JFrame implements ActionListener
{
    private JLabel bgL; //for label
	private JButton conBtn; //button
	private JPanel p1; // panel
	private ImageIcon icon; // image icon
	
	
    public Welcome (){
        super(" Welcome ");
		this.setSize(800,500);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.setLocationRelativeTo(null);
		
		//panel
		p1 = new JPanel();
		p1.setSize(new Dimension(800,500));
		p1.setBackground(Color.decode("#AFB2AD"));
		p1.setLayout(null);
		
		//icon & background
		icon = new ImageIcon(getClass().getResource("/images/Logo1.png"));
        this.setIconImage(icon.getImage());
		
		
		//button
	    conBtn = new JButton(new ImageIcon(getClass().getResource("/Images/getStarted.png")));
	    conBtn.setFont(new Font("Serif",Font.BOLD,25));
	    conBtn.setBackground(null);
	    conBtn.setBorder(null);
	    conBtn.setBounds(265,400,270,60);
	    conBtn.addActionListener(this);
	    p1.add(conBtn);
		
		bgL = new JLabel(new ImageIcon(getClass().getResource("/Images/Hello!.gif")));
		bgL.setBounds(0,0,800,500);
		p1.add(bgL);
		
        this.add(p1);
    }
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==conBtn){
			Login l = new Login();
			this.setVisible(false); // making current from invisible
			l.setVisible(true); // making next form visible
		}
	}
}