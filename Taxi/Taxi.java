package Taxi;
import java.util.*;
public class Taxi {
    static int taxicount=0;
    int id;
    boolean booked;
    char currentspot;
    int freetime;
    int totalearnings;
    List<String> trips;
    public Taxi()
    {
    	booked=false;
    	currentspot='A';
    	freetime=6;
    	totalearnings=0;
    	trips=new ArrayList<String>();
    	taxicount=taxicount+1;
    	id=taxicount;
    }
    public void setDetails(boolean booked,char currentspot,int freetime,int totalearnings, String tripdetails)
    {
    	this.booked=booked;
    	this.currentspot=currentspot;
    	this.freetime=freetime;
    	this.totalearnings=totalearnings;
    	this.trips.add(tripdetails);
    }
    public void printDetails()
    {
    	System.out.println("Taxi - "+this.id+" Total Earnings - "+this.totalearnings);
    	System.out.println("TaxiID   BookingID   CustomerID   From   To  PickupTime   DropTime   Amount");
    	for(String trip:trips)
    	{
    		System.out.println(trip);
    	}
    	System.out.println("*****************************************************************");
    }
}
