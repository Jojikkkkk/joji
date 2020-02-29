package ProjectMac190;
import java.util.Scanner;


public class test {
	
	public static void main(String[] args)  {
		boolean i = true;      
		Scanner key = new Scanner(System.in);
			        while(i == true){
						System.out.println();
						System.out.println("Plese choose your selection");
						System.out.println("---------------------------");
						System.out.println();
						System.out.println("1)Handling personal data for hospital wokers.");
						System.out.println("2)Handling for hosital Rooms.");
						System.out.println("3)Exit");
						System.out.print(">>");
						int a = key.nextInt();
						System.out.println();
						switch(a) {
						case 1:
							list.showlist();
							break;
						case 2:
							RoomGUI gui = new RoomGUI();
							gui.Roominfo();
							break;
						case 3:
							System.out.println("Thank you");
							i = false;
						default :
							continue;
							}
						}
			        System.out.println("Done!");
					
	}
		
		}
