package repository;

import java.awt.Stroke;
import java.lang.*;
import java.util.ArrayList;

import entity.*;
import interfaces.*;

public class OrderRepo implements IOrderRepo {

    DatabaseConnection dbc;

    public OrderRepo() {
        dbc = new DatabaseConnection();
    }

    public void insertInDB(Order o){
        String query = "INSERT INTO cusOrder VALUES ('"+String.valueOf(o.getRoomID())+"','"+String.valueOf(o.getLaundry())+"','"+String.valueOf(o.getCleaning())+"','"+String.valueOf(o.getJuice())+"','"+String.valueOf(o.getMilk())+"','"+o.getFood()+"');";
        try{
            dbc.openConnection();
            dbc.st.execute(query);
            dbc.closeConnection();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void deleteFromDB(int roomID){
		String query = "DELETE from cusOrder WHERE roomID='" + String.valueOf(roomID) + "';";
        try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
    }

    public void updateInDB(Order o){
    }

    public Order searchOrder(int roomID){
        Order o = new Order();
        String query = "SELECT `roomID`, `laundry`, `cleaning`, `juice`, `milk`, `food` FROM `cusOrder` WHERE `roomID`='"+roomID+"';";
        try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				o.setRoomID(roomID);
                o.setLaundry(dbc.result.getInt("laundry"));
                o.setCleaning(dbc.result.getInt("cleaning"));
                o.setJuice(dbc.result.getInt("juice"));
                o.setMilk(dbc.result.getInt("milk"));
                o.setFood(dbc.result.getString("food"));

			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		dbc.closeConnection();
		return o;
    }

    public String[][] getAllOrder(){
        ArrayList<Order> ar = new ArrayList<>();
        String query = "SELECT * FROM cusOrder";
        try{
            dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			while(dbc.result.next())
			{
				Order o = new Order();
				o.setRoomID(dbc.result.getInt("roomID"));
                o.setLaundry(dbc.result.getInt("laundry"));
                o.setCleaning(dbc.result.getInt("cleaning"));
                o.setJuice(dbc.result.getInt("juice"));
                o.setMilk(dbc.result.getInt("milk"));
                o.setFood(dbc.result.getString("food"));
                ar.add(o);
			}
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        dbc.closeConnection();


        Object obj[] = ar.toArray();
		String data[][] = new String[ar.size()][6];
		
		for(int i=0;i<obj.length;i++)
		{
			data[i][0] = Integer.toString(((Order)obj[i]).getRoomID());
			data[i][1] = Integer.toString(((Order)obj[i]).getLaundry());
			data[i][2] = Integer.toString(((Order)obj[i]).getCleaning());
			data[i][3] = Integer.toString(((Order)obj[i]).getJuice());
 			data[i][4] = Integer.toString(((Order)obj[i]).getMilk());
            data[i][5] = ((Order)obj[i]).getFood() + "";
		}
		return data;
    }

}
