package Taxi;
import java.util.*;
public class TaxiBooking {
    
	public List<Taxi> createTaxi(int n)
	{
		List<Taxi> taxi=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			Taxi t=new Taxi();
			taxi.add(t);
		}
		return taxi;
	}

	public List<Taxi> getFreeTaxi(List<Taxi> taxi,int pickupTime,char pickupPoint) {
		List<Taxi> freetaxi=new ArrayList<>();
		for(Taxi t:taxi)
		{
			if(t.freetime<=pickupTime&& (Math.abs((t.currentspot-'0')-(pickupPoint-'0'))<=pickupTime-t.freetime))
			{
				freetaxi.add(t);
			}
			
		}
		return freetaxi;
	}
    public void bookTaxi(int id,char pickupPoint,char dropPoint,int pickupTime,List<Taxi> freetaxi)
    {
    	int min=Integer.MAX_VALUE;
    	int freetime=0;
    	int distancebetweenpickupanddrop=0;
    	int earnings=0;
    	char spot='z';
    	Taxi bookedTaxi=null;
    	String tripDetails="";
    	for(Taxi t:freetaxi)
    	{
    		int distacebetweencustomerandtaxi=Math.abs((t.currentspot-'0')-(pickupPoint-'0'))*15;
    		if(distacebetweencustomerandtaxi<min)
    		{
    			bookedTaxi=t;
    			distancebetweenpickupanddrop=Math.abs((dropPoint-'0')-(pickupPoint-'0'))*15;
    			earnings=(distancebetweenpickupanddrop-5)*10+100;
    			int droptime=pickupTime+distancebetweenpickupanddrop/15;
    			freetime=droptime;
    			spot=dropPoint;
    			tripDetails=id+"         "+id+"              "+pickupPoint+"             "+dropPoint+"             "+pickupTime+"          "+droptime+"       "+earnings;
    		}
    		
    	}
    	bookedTaxi.setDetails(true, spot, freetime, bookedTaxi.totalearnings+earnings, tripDetails);
		System.out.println("Taxi "+bookedTaxi.id+" booked");
    	
    }
	
}