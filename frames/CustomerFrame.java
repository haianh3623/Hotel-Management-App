package frames;

import java.lang.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import entity.*;
import repository.*;

public class CustomerFrame extends JFrame implements MouseListener,ActionListener {
    JButton sendBtn, clearAllBtn, backBtn, pJuiceBtn, mJuiceBtn, pMilkBtn, mMilkBtn;
    JLabel roomLabel, servicesLabel, laundryLabel, cleaningLabel, juiceLabel, milkLabel, foodLabel, numJuiceLabel, numMilkLabel;
    JTextField roomTF, commentTF;
    JPanel panel;
    JCheckBox laundryCB, cleaningCB;

    private int roomID, juice = 0, milk = 0, laundry = 0, cleaning = 0;
    private String food;

    private OrderRepo or;
    
    public CustomerFrame(){
        super("HotelManagementSystem/Login");
		
		this.setSize(800, 450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);

        
        roomLabel = new JLabel("Enter your room:");
        roomLabel.setBounds(30, 30, 150, 20);
        panel.add(roomLabel);

        
        servicesLabel = new JLabel("Services");
        servicesLabel.setBounds(380, 50, 50, 50);
        servicesLabel.setForeground(Color.RED);
        panel.add(servicesLabel);


        roomTF = new JTextField();
        roomTF.setBounds(200, 25, 100, 30);
        panel.add(roomTF);


        laundryLabel = new JLabel("Laundry");
        laundryLabel.setBounds(200, 90, 200, 30);
        panel.add(laundryLabel);


        laundryCB = new JCheckBox();
        laundryCB.setBounds(500, 90, 25, 25);
        panel.add(laundryCB);


        cleaningLabel = new JLabel("Cleaning room");
        cleaningLabel.setBounds(200, 120, 200, 30);
        panel.add(cleaningLabel);


        cleaningCB = new JCheckBox();
        cleaningCB.setBounds(500, 120, 25, 25);
        panel.add(cleaningCB);


        juiceLabel = new JLabel("Juice");
        juiceLabel.setBounds(200, 150, 200, 30);
        panel.add(juiceLabel);


        mJuiceBtn = new JButton("-");
        mJuiceBtn.setBounds(500, 150, 20, 20);
        mJuiceBtn.setBackground(Color.WHITE);
		mJuiceBtn.setForeground(Color.BLACK);
		mJuiceBtn.addMouseListener(this);
		mJuiceBtn.addActionListener(this);
		panel.add(mJuiceBtn);


        String numJ = String.valueOf(juice);
        numJuiceLabel = new JLabel(numJ);
        numJuiceLabel.setBounds(540, 150, 20, 20);
        panel.add(numJuiceLabel);


        pJuiceBtn = new JButton("+");
        pJuiceBtn.setBounds(565, 150, 20, 20);
        pJuiceBtn.setBackground(Color.WHITE);
		pJuiceBtn.setForeground(Color.BLACK);
		pJuiceBtn.addMouseListener(this);
		pJuiceBtn.addActionListener(this);
		panel.add(pJuiceBtn);


        milkLabel = new JLabel("Milk");
        milkLabel.setBounds(200, 180, 200, 30);
        panel.add(milkLabel);


        mMilkBtn = new JButton("- ");
        mMilkBtn.setBounds(500, 180, 20, 20);
        mMilkBtn.setBackground(Color.WHITE);
		mMilkBtn.setForeground(Color.BLACK);
		mMilkBtn.addMouseListener(this);
		mMilkBtn.addActionListener(this);
		panel.add(mMilkBtn);


        String numM = String.valueOf(milk);
        numMilkLabel = new JLabel(numM);
        numMilkLabel.setBounds(540, 180, 20, 20);
        panel.add(numMilkLabel);


        pMilkBtn = new JButton("+ ");
        pMilkBtn.setBounds(565, 180, 20, 20);
        pMilkBtn.setBackground(Color.WHITE);
		pMilkBtn.setForeground(Color.BLACK);
		pMilkBtn.addMouseListener(this);
		pMilkBtn.addActionListener(this);
		panel.add(pMilkBtn);


        foodLabel = new JLabel("Food");
        foodLabel.setBounds(200, 210, 200, 30);
        panel.add(foodLabel);


        commentTF = new JTextField();
        commentTF.setBounds(500, 205, 150, 30);
        panel.add(commentTF);


        sendBtn = new JButton("Send");
		sendBtn.setBounds(100, 300, 150, 50);
		sendBtn.setBackground(Color.WHITE);
		sendBtn.setForeground(Color.RED);
		sendBtn.addMouseListener(this);
		sendBtn.addActionListener(this);
		panel.add(sendBtn);


        clearAllBtn = new JButton("Clear All");
		clearAllBtn.setBounds(300, 300, 150, 50);
		clearAllBtn.setBackground(Color.WHITE);
		clearAllBtn.setForeground(Color.RED);
		clearAllBtn.addMouseListener(this);
		clearAllBtn.addActionListener(this);
		panel.add(clearAllBtn);


        backBtn = new JButton("Back");
		backBtn.setBounds(500, 300, 150, 50);
		backBtn.setBackground(Color.WHITE);
		backBtn.setForeground(Color.RED);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		panel.add(backBtn);


        this.add(panel);

    }

    public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==sendBtn)
		{
			sendBtn.setBackground(Color.RED);
		    sendBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==clearAllBtn)
		{
			clearAllBtn.setBackground(Color.RED);
		    clearAllBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==backBtn)
		{
			backBtn.setBackground(Color.RED);
		    backBtn.setForeground(Color.WHITE);

		} else
		{

		}
	}

	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==sendBtn)
		{
			sendBtn.setBackground(Color.WHITE);
		    sendBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==clearAllBtn)
		{
			clearAllBtn.setBackground(Color.WHITE);
		    clearAllBtn.setForeground(Color.RED);
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
	
	public void mousePressed(MouseEvent me) {}
	
	public void mouseReleased(MouseEvent me) {}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		System.out.println(command);
		
		if(command.equals(backBtn.getText()))
		{
            WelcomeFrame wf = new WelcomeFrame();
            wf.setVisible(true);
            this.setVisible(false);			
		}
        else if(command.equals(mJuiceBtn.getText())){
            if(juice > 0){
                juice -= 1;
                String numJ = String.valueOf(juice);
                numJuiceLabel.setText(numJ);
            }
        } 
        else if(command.equals(pJuiceBtn.getText())){
            juice += 1;
            String numJ = String.valueOf(juice);
            numJuiceLabel.setText(numJ);
        }
        else if(command.equals(mMilkBtn.getText())){
            if(milk > 0){
                milk -= 1;
                String numM = String.valueOf(milk);
                numMilkLabel.setText(numM);
            }
        } 
        else if(command.equals(pMilkBtn.getText())){
            milk += 1;
            String numM = String.valueOf(milk);
            numMilkLabel.setText(numM);
        }
        else if(command.equals(clearAllBtn.getText())){
            CustomerFrame cf = new CustomerFrame();
            cf.setVisible(true);
            this.setVisible(false);
        } else if(command.equals(sendBtn.getText())){
            or = new OrderRepo();
            Order o = new Order();
            if(roomTF.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please enter your room number");
            }else{
                String id = roomTF.getText();
                o.setRoomID(Integer.parseInt(id));
                if(laundryCB.isSelected() == true){
                    laundry = 1;
                }else{
                    laundry = 0;
                }
                if(cleaningCB.isSelected() == true){
                    cleaning = 1;
                }else{
                    cleaning = 0;
                }
                o.setLaundry(laundry);
                o.setCleaning(cleaning);
                o.setJuice(Integer.parseInt(numJuiceLabel.getText()));
                o.setMilk(Integer.parseInt(numMilkLabel.getText()));
                o.setFood(commentTF.getText());
                or.insertInDB(o);

                JOptionPane.showMessageDialog(this, "Your resquest was sent. Thank you!");
                clearAllBtn.doClick();
            }
        }	
	}

}
