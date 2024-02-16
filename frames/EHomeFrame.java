package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class EHomeFrame extends JFrame implements MouseListener,ActionListener
{
	JButton logoutBtn, manageEmpBtn,manageCustomerBtn,manageRoomBtn,changePasswordBtn,orderBtn;
	JPanel panel;
	
	User user;
	
	public EHomeFrame(User user)
	{
		super("HotelManagementSystem/EmployeeHome");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);


		orderBtn = new JButton("Order");
		orderBtn.setBounds(325,50,150,30);
		orderBtn.setBackground(Color.WHITE);
		orderBtn.setForeground(Color.RED);
		orderBtn.addMouseListener(this);
		orderBtn.addActionListener(this);
		panel.add(orderBtn);
		
		
		manageEmpBtn = new JButton("Manage Employee");
		manageEmpBtn.setBounds(325,100,150,30);
		manageEmpBtn.setBackground(Color.WHITE);
		manageEmpBtn.setForeground(Color.RED);
		manageEmpBtn.addMouseListener(this);
		manageEmpBtn.addActionListener(this);
		panel.add(manageEmpBtn);
		

		manageCustomerBtn = new JButton("Manage Customer");
		manageCustomerBtn.setBounds(325,150,150,30);
		manageCustomerBtn.setBackground(Color.WHITE);
		manageCustomerBtn.setForeground(Color.RED);
		manageCustomerBtn.addMouseListener(this);
		manageCustomerBtn.addActionListener(this);
		panel.add(manageCustomerBtn);
		
		
		manageRoomBtn = new JButton("Manage Room");
		manageRoomBtn.setBounds(325,200,150,30);
		manageRoomBtn.setBackground(Color.WHITE);
		manageRoomBtn.setForeground(Color.RED);
		manageRoomBtn.addMouseListener(this);
		manageRoomBtn.addActionListener(this);
		panel.add(manageRoomBtn);
		

		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(325,250,150,30);
		changePasswordBtn.setBackground(Color.WHITE);
		changePasswordBtn.setForeground(Color.RED);
		changePasswordBtn.addMouseListener(this);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);


		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(325,300,150,30);
		logoutBtn.setBackground(Color.WHITE);
		logoutBtn.setForeground(Color.RED);
		logoutBtn.addMouseListener(this);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);


		this.add(panel);
		
	}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==manageEmpBtn)
		{
			manageEmpBtn.setBackground(Color.RED);
		    manageEmpBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==manageCustomerBtn)
		{
			manageCustomerBtn.setBackground(Color.RED);
		    manageCustomerBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==manageRoomBtn)
		{
			manageRoomBtn.setBackground(Color.RED);
		    manageRoomBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==changePasswordBtn)
		{
			changePasswordBtn.setBackground(Color.RED);
		    changePasswordBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==logoutBtn)
		{
			logoutBtn.setBackground(Color.RED);
		    logoutBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==orderBtn)
		{
			orderBtn.setBackground(Color.RED);
		    orderBtn.setForeground(Color.WHITE);

		}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==manageEmpBtn)
		{
			manageEmpBtn.setBackground(Color.WHITE);
		    manageEmpBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==manageCustomerBtn)
		{
			manageCustomerBtn.setBackground(Color.WHITE);
		    manageCustomerBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==manageRoomBtn)
		{
			manageRoomBtn.setBackground(Color.WHITE);
		    manageRoomBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==changePasswordBtn)
		{
			changePasswordBtn.setBackground(Color.WHITE);
		    changePasswordBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==logoutBtn)
		{
			logoutBtn.setBackground(Color.WHITE);
		    logoutBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==orderBtn)
		{
			orderBtn.setBackground(Color.WHITE);
		    orderBtn.setForeground(Color.RED);

		}

	}
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(manageEmpBtn.getText()))
		{
			if(user.getUStatus()==1)
			{
				EmanageFrame emf = new EmanageFrame(user);
				emf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Access Denied");
			}
		}
		else if(command.equals(manageCustomerBtn.getText()))
		{
		    if(user.getUStatus()==2 || user.getUStatus()==1)
			{
				CmanageFrame cmf = new CmanageFrame(user);
				cmf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Access Denied");
			}	
		}
		else if(command.equals(manageRoomBtn.getText()))
		{
			if(user.getUStatus()==2 || user.getUStatus()==1)
			{
				RmanageFrame rmf = new RmanageFrame(user);
				rmf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Access Denied");
			}
		}
		else if(command.equals(changePasswordBtn.getText()))
		{
			ChangePassFrame echpf = new ChangePassFrame(user);
			echpf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(orderBtn.getText()))
		{
			OrderFrame of = new OrderFrame(user);
			of.setVisible(true);
			this.setVisible(false);
		}
	}
	
	
}