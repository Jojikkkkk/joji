package ProjectMac190;

import java.util.Scanner;


public class Roomhandling {
	private static int index = 0;
	public  static String[]  Roominfo = new String[50];
	
	Roomhandling() {
		for(int i=0;i < Roominfo.length;++i)
		Roominfo[i] = "Vacant seat";
	}
	
	public static String getroominfo() {
		return Roominfo[getindex()];
	}
	      
    public static int getindex() {
    		return index;
    	}

	public static int increindex() {
		return ++index;
	}
	
	
	public static void showroom() {
		System.out.print("Taking your room is :");
	for(int i = 0;i < Roominfo.length;++i) {
		if(Roominfo[i]== "Vacant seat" || Roominfo[i]==null) {
			continue;
			}
		else {
			System.out.println(""+Roominfo[i]);
			}
		}
	System.out.println();
	}
	
	public static void Serchroom() {
		System.out.println("Check room vacancy");
		Beds.dispData();
		System.out.println("Put your room number");
		System.out.print(">>");
		Scanner key = new Scanner(System.in);
		String room = key.nextLine();
		for(int i = 0;i < Roominfo.length;) {
			if((Roominfo[i]).equalsIgnoreCase(room)) {
				System.out.println("This seat has been already taken.");
				break;}
			else if(!(Roominfo[i]).equalsIgnoreCase("Vacant seat") && !(Roominfo[i]).equalsIgnoreCase(room)) {
				System.out.println("This is still vacant.");
				break;}
			}
		}
	
	public static String Removeroom() {
		System.out.println("Remove your room");
		System.out.println(">>");
		Scanner key = new Scanner(System.in);
		String s = key.nextLine();
		for(int i = 0; i < Roominfo.length;++i) {
			if(s.equalsIgnoreCase(Roominfo[i]))
				return s = Roominfo[i];	
		}
		return s;
		 
	}
	}
