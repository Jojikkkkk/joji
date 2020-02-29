import java.util.Scanner;

public class RoomGUI {

	public boolean Roominfo() {
	      Beds be = new Beds();
	      Beds.Initializearray();
	      Scanner key = new Scanner(System.in);
	      System.out.println("This is handling for hosital Rooms");
	        while(true){
				System.out.println();
				System.out.println("Plese choose your selection");
				System.out.println("---------------------------");
				System.out.println();
				System.out.println("1)Make Reservation 2)Serch Rooms vacancy 3)Exit");
				System.out.print(">>");
				int a = key.nextInt();
				switch(a) {
				case 1:
					be.reservation();
					Roomhandling.showroom();
					break;
				case 2:
					Roomhandling.Serchroom();
					break;
				case 3:
					System.out.println("Thank you");
					return false;
				default :
					continue;
					}
				continue;
				}
	      }
}
