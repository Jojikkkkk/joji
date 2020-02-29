package ProjectMac190;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

/*Method :	IDhandling.setIDpatient(int id);
 * 			IDhandling.getIDpatient();
 * 			IDhandling.setIDDoctor(int id);
 * 			IDhandling.getIDDoctor();
 * 			IDhandling.setIDStaff(int id);
 * 			IDhandling.getIDStaff();
 * 			IDhandling.reMakeID();
 * 			IDhandling.checkID(int Id);
 * 			IDhandling.IDMaker();
 */

public class IDhandling {
	private final static int Size = 100000;
	private static int[] IDPatient = new int[Size];
	private static int[] IDDoctor = new int[Size];
	private static int[] IDStaff = new int[Size];
	private static int[] ID = new int[Size];
	static Scanner key = new Scanner(System.in);
	
	
	public static void setIDpatient(int id) {
		ID=IDPatient;
		while(checkID(id) == false || id == 0) {
			id = reMakeID();
			}
		IDPatient[list.getindex()] = id;
	}
	
	
	public static int getIDpatient() {
		return IDPatient[list.getindex()];
	}
	
	
	public static void setIDDoctor(int id) {
		ID=IDDoctor;
		while(checkID(id) == false || id == 0) {
			id = reMakeID();
			}
		IDDoctor[list.getindex()] = id;
	}
	
	
	public static int getIDDoctor() {
		return IDDoctor[list.getindex()];
	}
	
	 
	public static void setIDStaff(int id) {
		ID=IDStaff;
		while(checkID(id) == false || id == 0) {
			id = reMakeID();
			}
		IDStaff[list.getindex()] = id;
	}
	
	public static int getIDStaff() {
		return IDStaff[list.getindex()];
	}
	
	private static int reMakeID() {
			System.out.println("There is same ID or ID can not be 0");
			System.out.print("Make new ID >>");
			int id = key.nextInt();
			return id;	
	}
	
	
	private static boolean checkID(int Id) {
			for(int index = 0;index < Size; ++index) {
				if (Id == ID[index])
					return false;
			}
		return true;
	}
	
	public static int IDgenerater() {
			Random rnd = new Random();
			return rnd.nextInt(Size+1);
	}
	
	public static int IDMaker() {
			System.out.println("Would you like to set your ID Randmly?? YES >> 1, NO >> 0");
			if(key.nextInt() == 1)
			return IDgenerater();
			else
			return 0;
	}
	
	public static void serchID() throws InputMismatchException,NumberFormatException,NullPointerException{
		
		System.out.println("Serch ID");
		System.out.print(">>");
		int IDnum = key.nextInt();
		for(int index = 0;index < Size;++index) {		
			if(IDnum == IDDoctor[index]&&IDStaff[index]!=IDnum) {
				//
				System.out.println("Doctor Name is "+ ((Doctor) list.doct[index]).getName());
				break;
				}
			else if(IDnum == IDStaff[index]&&IDDoctor[index]!= IDnum) {
				System.out.println("Staff Name is "+ (((Nurse) list.staff[index]).getName()));
				break;
				}
			else if(IDDoctor[index]== IDnum && IDStaff[index]==IDnum)
			{
				System.out.println("Doctor Name is "+ ((Doctor) list.doct[index]).getName());
				System.out.println("Staff Name is "+  ((Nurse) list.staff[index]).getName());
				break;
			}
			else if(IDnum != IDDoctor[index] && IDnum != IDStaff[index] && index == Size-1)
				System.out.println("There is no name");
		}

	}
	

}


