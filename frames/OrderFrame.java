package frames;

import java.lang.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import entity.*;
import repository.*;

public class OrderFrame extends JFrame implements MouseListener,ActionListener {

    JLabel roomIDLabel, foodRqLabel;
    JButton loadBtn, getAllBtn, deleteBtn, backBtn;
    JTextField roomIDTF;
    JTextArea foodTA;
    JTable orderTable;
    JScrollPane orderTableSP;
    JPanel panel;

    private User user;
	private OrderRepo or = new OrderRepo();

    public OrderFrame(User user) {

        super("HotelManagementSystem/EmployeeHome/ManageEmployee");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.user = user;


        panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);


        String data[][]={{"","","","","",""}};
		String head[]={"RoomNumber", "Laundry", "Cleaning", "Juice","Milk","Food"};


        orderTable = new JTable(data,head);
		orderTableSP = new JScrollPane(orderTable);
		orderTableSP.setBounds(350, 50, 400, 230);
		orderTable.setEnabled(false);
		panel.add(orderTableSP);


        roomIDLabel = new JLabel("Enter room number:");
        roomIDLabel.setBounds(50, 50, 150, 30);
        panel.add(roomIDLabel);


        roomIDTF = new JTextField();
        roomIDTF.setBounds(200, 50, 100, 30);
        panel.add(roomIDTF);


        foodRqLabel = new JLabel("Food request:");
        foodRqLabel.setBounds(50, 100, 150, 30);
        panel.add(foodRqLabel);


        foodTA = new JTextArea();
        foodTA.setBounds(50, 150, 250, 150);
        foodTA.setText("welcome");
        panel.add(foodTA);


        loadBtn = new JButton("Load");
		loadBtn.setBounds(115,300,90,30);
		loadBtn.setBackground(Color.WHITE);
		loadBtn.setForeground(Color.RED);
		loadBtn.addMouseListener(this);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);


        deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(275,300,90,30);
		deleteBtn.setBackground(Color.WHITE);
		deleteBtn.setForeground(Color.RED);
		deleteBtn.addMouseListener(this);
		deleteBtn.addActionListener(this);
		panel.add(deleteBtn);


        getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(435,300,90,30);
		getAllBtn.setBackground(Color.WHITE);
		getAllBtn.setForeground(Color.RED);
		getAllBtn.addMouseListener(this);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);


        backBtn = new JButton("Back");
		backBtn.setBounds(595,300,90,30);
		backBtn.setBackground(Color.WHITE);
		backBtn.setForeground(Color.RED);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		panel.add(backBtn);


        this.add(panel);


		deleteBtn.setEnabled(false);
    }


    public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==loadBtn)
		{
			loadBtn.setBackground(Color.RED);
		    loadBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==deleteBtn)
		{
			deleteBtn.setBackground(Color.RED);
		    deleteBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==getAllBtn)
		{
			getAllBtn.setBackground(Color.RED);
		    getAllBtn.setForeground(Color.WHITE);

		}
        else if(me.getSource()==backBtn)
		{
			backBtn.setBackground(Color.RED);
		    backBtn.setForeground(Color.WHITE);

		}
	}

	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==loadBtn)
		{
			loadBtn.setBackground(Color.WHITE);
		    loadBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==deleteBtn)
		{
			deleteBtn.setBackground(Color.WHITE);
		    deleteBtn.setForeground(Color.RED);
		}
		else if(me.getSource()==getAllBtn)
		{
			getAllBtn.setBackground(Color.WHITE);
		    getAllBtn.setForeground(Color.RED);
		}
        else if(me.getSource()==backBtn)
		{
			backBtn.setBackground(Color.WHITE);
		    backBtn.setForeground(Color.RED);
		}
	}
	
	public void mouseClicked(MouseEvent me){}
	
	public void mousePressed(MouseEvent me) {}
	
	public void mouseReleased(MouseEvent me) {}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		System.out.println(command);

        if(command.equals(backBtn.getText())){
            EHomeFrame ef = new EHomeFrame(user);
            ef.setVisible(true);
            this.setVisible(false);
        } else if(command.equals(getAllBtn.getText())){
			String data[][] = or.getAllOrder();
			String head[]={"RoomNumber", "Laundry", "Cleaning", "Juice","Milk","Food"};

			panel.remove(orderTableSP);

			orderTable = new JTable(data, head);
			orderTable.setEnabled(false);
			orderTableSP = new JScrollPane(orderTable);
			orderTableSP.setBounds(350, 50, 400, 230);
			panel.add(orderTableSP);

			panel.revalidate();
			panel.repaint();
		} else if(command.equals(deleteBtn.getText())){
			if(roomIDTF.getText().equals("")){
				JOptionPane.showMessageDialog(this, "Please enter room number!");
			} else {
				int room = Integer.parseInt(roomIDTF.getText());
				or.deleteFromDB(room);
				roomIDTF.setText("");

				getAllBtn.doClick();
				deleteBtn.setEnabled(false);
				foodTA.setText("welcome!");
			}
		} else if(command.equals(loadBtn.getText())){
			if(roomIDTF.getText().equals("")){
				JOptionPane.showMessageDialog(this, "Please enter room number!");
			} else{
				int room = Integer.parseInt(roomIDTF.getText());
				Order o = new Order();
				o = or.searchOrder(room);
				if(o.getRoomID() == 0){
					JOptionPane.showMessageDialog(this, "Could not find room number!");
				} else{
					String head[]={"RoomNumber", "Laundry", "Cleaning", "Juice","Milk","Food"};
					String[][] data = new String[1][6];
					data[0][0] = String.valueOf(o.getRoomID());
					data[0][1] = String.valueOf(o.getLaundry());
					data[0][2] = String.valueOf(o.getCleaning());
					data[0][3] = String.valueOf(o.getJuice());
					data[0][4] = String.valueOf(o.getMilk());
					data[0][5] = o.getFood();
					panel.remove(orderTableSP);

					orderTable = new JTable(data, head);
					orderTable.setEnabled(false);
					orderTableSP = new JScrollPane(orderTable);
					orderTableSP.setBounds(350, 50, 400, 230);
					panel.add(orderTableSP);

					panel.revalidate();
					panel.repaint();

					foodTA.setText(o.getFood());
					deleteBtn.setEnabled(true);
				}
			}
		}
		
	}


    
}
