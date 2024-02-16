package interfaces;

import java.lang.*;

import entity.*;

public interface IOrderRepo {
    public void insertInDB(Order o);
	public void deleteFromDB(int roomID);
	public void updateInDB(Order o);
	public Order searchOrder(int roomID);
	public String[][] getAllOrder();
}
