package Taxi;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		TaxiBooking t=new TaxiBooking();
		Taxi t1=new Taxi();
		List<Taxi> taxi=t.createTaxi(4);
		int id=1;
		while(true)
		{
			System.out.println("1->book taxi");
			System.out.println("2->book taxi");
			System.out.println("Enter your choice");
			byte choice=sc.nextByte();
			switch(choice)
			{
			case 1:
				int customerID=1;
				System.out.println("Enter your pickup point");
				char pickup=sc.next().charAt(0);
				System.out.println("Enter your drop point");
				char drop=sc.next().charAt(0);
				System.out.println("Enter the pickup time");
				int time=sc.nextInt();
				if(pickup<'A' || pickup>'F' || drop<'A' || drop>'F')
				{
					System.out.println("Invalid pickup and dropPoint");
					return;
				}
				List<Taxi> freetaxi=t.getFreeTaxi(taxi,time,pickup);
				if(freetaxi.size()==0)
				{
					System.out.print("sorry no taxi are available");
					return;
				}
				Collections.sort(freetaxi,(a,b)->a.totalearnings-b.totalearnings);
				t.bookTaxi(id,pickup,drop,time,freetaxi);
				id++;
				break;
			case 2:
				for(Taxi t2:taxi)
				{
					t2.printDetails();
				}
				break;	
			default:return;
			}
		}
	}
}
