package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import entity.*;
import repository.*;

public class LoginFrame extends JFrame implements MouseListener,ActionListener
{
	JLabel title, userLabel, passLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn,backBtn,showPassBtn;
	JPanel panel;
	
	public LoginFrame()
	{
		super("HotelManagementSystem/Login");
		
		this.setSize(800, 450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		title = new JLabel("Hotel Management System");
		title.setBounds(300, 50, 350, 50);
		title.setForeground(Color.RED);
		panel.add(title);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(300, 100, 60, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(370, 100, 100, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(300, 150, 70, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(370, 150, 100, 30);
		passPF.setEchoChar('*');
		panel.add(passPF);
		
		showPassBtn = new JButton("Show");
		showPassBtn.setBounds(470,150,80,30);
		showPassBtn.setBackground(Color.WHITE);
		showPassBtn.setForeground(Color.RED);
		showPassBtn.addMouseListener(this);
		panel.add(showPassBtn);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(300, 200, 80, 30);
		loginBtn.setBackground(Color.WHITE);
		loginBtn.setForeground(Color.RED);
		loginBtn.addMouseListener(this);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(390, 200, 80, 30);
		backBtn.setBackground(Color.WHITE);
		backBtn.setForeground(Color.RED);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		this.add(panel);
	}
	
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==loginBtn)
		{
			loginBtn.setBackground(Color.RED);
		    loginBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==showPassBtn)
		{
			showPassBtn.setBackground(Color.RED);
		    showPassBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==backBtn)
		{
			backBtn.setBackground(Color.RED);
		    backBtn.setForeground(Color.WHITE);

		}
		else
		{

		}
	}

	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==loginBtn)
		{
			loginBtn.setBackground(Color.WHITE);
		    loginBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==showPassBtn)
		{
			showPassBtn.setBackground(Color.WHITE);
		    showPassBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==backBtn)
		{
			backBtn.setBackground(Color.WHITE);
		    backBtn.setForeground(Color.RED);
		}
		else
		{
			
		}
	}
	
	public void mouseClicked(MouseEvent me){}
	
	public void mousePressed(MouseEvent me)
	{
		passPF.setEchoChar((char)0);
	}
	
	public void mouseReleased(MouseEvent me)
	{
		passPF.setEchoChar('*');
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		System.out.println(command);
		
		if(command.equals(loginBtn.getText()))
		{
			UserRepo ur=new UserRepo();
			User user = ur.getUser(userTF.getText(),passPF.getText());
			
			if(user !=null)
			{
				EHomeFrame ehf = new EHomeFrame(user);
				ehf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Invaild Id or Password");
			}
			
		}
		else if(command.equals(backBtn.getText()))
		{
			WelcomeFrame wc = new WelcomeFrame();
			wc.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
} 