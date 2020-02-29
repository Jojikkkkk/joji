package ProjectMac190;
import java.util.InputMismatchException;
import java.util.Scanner;
/* This program for list patient class, doctor class, and staff class. 
 * I prepare for Object Arrays and we can save each class on it and check the class information by showing list.
 * You do not need to make instance for this class. You call showlist method any time and getlist method.
 * */

public class list {
	// You can share this object array to other class
	
	private static int Size = 10000;
	private static int index = 0;
	public static Object[] pati = new Object[Size];
	public static Object[] doct = new Object[Size];
	public static Object[] staff = new Object[Size];
	static Scanner key = new Scanner(System.in);
	
	public static boolean showlist(){
		System.out.println("This is for handling personal data for hospital wokers.");
		
		// This function is for user interface.
		while(true){
			System.out.println();
			System.out.println("Plese choose your selection");
			System.out.println("---------------------------");
			System.out.println();
			System.out.println("1)Information 2)Set information 3)Reset for the Data 4)Serch ID 5)Exit");
			System.out.print(">>");
			int a = key.nextInt();
			switch(a) {
			case 1:
				getList();
				break;
			case 2:
				setList();	
				break;
			case 3:
				resetarray();
				break;
			case 4:
				IDhandling.serchID();
				break;
			case 5:
				System.out.println("Thank you");
				return false;
				}
			continue;
			}
		}
	
	
	public static void getList() {
		//This function is for showing list by using for loop
		// You can not call this method outside of this class.
		System.out.println("Which woker would you like to check information ??");
		System.out.println("1)Patient	2)Docter	3)Staff");
		try {
		System.out.print(">>");
		int c = key.nextInt();
		switch(c) {
		case 1 :	
			showinfoPatient();
	 		break;
		case 2: 
			showinfoDocter();
	 		break;	
		case 3:
			showinfoStaff();
	 		break;
		default :
			System.out.print("This is not good.");
		 break;
		 }}catch(NullPointerException e) {
		System.out.println("----------------");
		System.out.println("End of this List");
		System.out.println("----------------");
		System.out.println("");
		System.out.println("");
		 }
	}
	
	private static void setList(){
		//This function is for setting information.
		// You can not call this method outside of this class.
		try{System.out.println("Plese choose your selection");
		System.out.println("---------------------------");
		System.out.println();
		System.out.println("1)Patient	2)Doctor	3)Staff");
		System.out.print(">>");
		int c = key.nextInt();
			switch(c) {
			case 1 :
				setinfoPatient();
		 		break;
			case 2: 
				setinfoDoctor();
		 		break;	
			case 3:
				setinfoStaff();
		 		break;
			default :
				System.out.print("This is not good");
			 break;}
			}
		catch(InputMismatchException e) {
			System.out.println("------------");
			System.out.println("System Error");
			System.out.println("------------");
			System.out.println();
			System.out.println();
			setList();
			}
		catch(NumberFormatException e) {
			System.out.println("------------");
			System.out.println("System Error");
			System.out.println("------------");
			System.out.println();
			System.out.println();
			setList();
		 }
	}
	
	private static void resetarray() {
		// This function is for reset information
		// You can not call this method outside of this class.
		System.out.println("Done!");
		 pati = new Object[Size];
		 doct = new Object[Size];
		 staff = new Object[Size];
	}
	  
	public static int getindex() {
		return index;
	}
	
	public static void setinfoPatient() {
		Patient pat = new Patient();
		pat.setInfo();
 		pati[getindex()] = (Object) pat;
 		System.out.println();
 		System.out.println("------------------");
 		pat.shoinfo();
 		System.out.println("This is  List No:"+ (index+1));
 		System.out.println("------------------");
 		System.out.println();
 		++index;
	}
	
	public static void setinfoDoctor() {
		Doctor doc = new Doctor();
		doc.setInfo();
 		doct[getindex()] = (Object) doc;
 		System.out.println();
 		System.out.println("------------------");
 		doc.shoinfo();
 		System.out.println("This is List No:"+ (index+1));
 		System.out.println("------------------");
 		System.out.println();
 		++index;
	}
	
	public static void setinfoStaff() {
		Nurse nur = new Nurse();
		nur.setInfo();
 		staff[getindex()] = (Object) nur;
 		System.out.println();
 		System.out.println("------------------");
 		nur.shoinfo();
 		System.out.println("This is List No:"+ (index+1));
 		System.out.println("------------------");
 		System.out.println();
 		++index;
	}
	
	public static void showinfoPatient() {
			System.out.println("Patient List");
			System.out.println("------------");
		for(int i = 0;i < pati.length;++i) {
			Patient pat = new Patient();
			System.out.println();
			pat = (Patient) pati[i];
			System.out.println("-----------------");
	 		pat.shoinfo();
	 		System.out.println("This is List No."+(i+1));
			System.out.println("-----------------");
			System.out.println("");
			}
	}
	
	public static void showinfoDocter() {
			System.out.println("Doctor List");
			System.out.println("-----------");
		for(int i = 0;i < doct.length;++i) {
			Doctor Doctor = new Doctor();
			System.out.println();
			System.out.println("------------------");
			Doctor = (Doctor) doct[i];
	 		Doctor.shoinfo();
	 		System.out.println("This is List No."+(i+1));
			System.out.println("------------------");
			System.out.println("");
			}
	}
	
	public static void showinfoStaff() {
			System.out.println("Staff List ");
			System.out.println("----------");
		for(int i = 0;i < staff.length;++i) {
			Nurse nur = new Nurse();
			System.out.println();
			System.out.println("------------------");
			nur = (Nurse) staff[i];
	 		nur.shoinfo();
	 		System.out.println("This is List No."+(i+1));
			System.out.println("------------------");
			System.out.println("");
			}
	}
	
}
