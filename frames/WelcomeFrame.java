package frames;

import java.lang.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import entity.*;
import repository.*;

public class WelcomeFrame extends JFrame implements MouseListener,ActionListener {
    
    JLabel title;
    JButton loginBtn, customerBtn;
    JPanel panel;


    public WelcomeFrame(){
        super("HotelManagementSystem");

        this.setSize(800, 450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		title = new JLabel("Hotel Management System");
		title.setBounds(300, 50, 350, 30);
		title.setForeground(Color.RED);
		panel.add(title);

		

        loginBtn = new JButton("Login");
		loginBtn.setBounds(200, 200, 150, 50);
		loginBtn.setBackground(Color.WHITE);
		loginBtn.setForeground(Color.RED);
		loginBtn.addMouseListener(this);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		
		customerBtn = new JButton("Customer");
		customerBtn.setBounds(390, 200, 150, 50);
		customerBtn.setBackground(Color.WHITE);
		customerBtn.setForeground(Color.RED);
		customerBtn.addMouseListener(this);
		customerBtn.addActionListener(this);
		panel.add(customerBtn);

        this.add(panel);
    }

    public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==loginBtn)
		{
			loginBtn.setBackground(Color.RED);
		    loginBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==customerBtn)
		{
			customerBtn.setBackground(Color.RED);
		    customerBtn.setForeground(Color.WHITE);

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
		else if(me.getSource()==customerBtn)
		{
			customerBtn.setBackground(Color.WHITE);
		    customerBtn.setForeground(Color.RED);
		}
		else
		{
			
		}
	}
	
	public void mouseClicked(MouseEvent me){}
	
	public void mousePressed(MouseEvent me) {}
	
	public void mouseReleased(MouseEvent me) {}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		System.out.println(command);
		
		if(command.equals(loginBtn.getText()))
		{

            LoginFrame lg = new LoginFrame();
            lg.setVisible(true);
            this.setVisible(false);
			
		}
		else if(command.equals(customerBtn.getText()))
		{
			CustomerFrame cf = new CustomerFrame();
			cf.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
}
