package entity;
import java.lang.*;

public class Order {
    private int roomID, laundry, cleaning, juice, milk;
    private String food;

    public Order(){
        
    }

    public void setRoomID(int roomID){
        this.roomID = roomID;
    }
    public void setLaundry(int laundry){
        this.laundry = laundry;
    }
    public void setCleaning(int cleaning){
        this.cleaning = cleaning;
    }
    public void setJuice(int juice){
        this.juice = juice;
    }
    public void setMilk(int milk){
        this.milk = milk;
    }
    public void setFood(String food){
        this.food = food;
    }

    public int getRoomID(){
        return roomID;
    }   
    public int getLaundry(){
        return laundry;
    }
    public int getCleaning(){
        return cleaning;
    }
    public int getJuice(){
        return juice;
    }
    public int getMilk(){
        return milk;
    }
    public String getFood(){
        return food;
    }
}
