package ProjectMac190;

import java.util.Scanner;
public class Beds {

	    static Scanner input = new Scanner(System.in);
	    public static String arrS[][] = new String[10][5];
	    static String cName[] = {"A","B","C","D","E","F","G","H","I","J"};


	    static int i, j;            // Loop Control Variables

	    static void dispData() {    // Method that will display the array content
	        for (i=0; i<10; ++i) {
	            for (j=0; j<5; ++j) {
	                System.out.print(arrS[i][j] + "\t");
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }


	    static boolean chkData(String vData) {  // Method that will check for reservation availability
	        for (i=0; i<10; ++i) {
	            for (j=0; j<5; ++j) {
	                if ((arrS[i][j]).equalsIgnoreCase(vData)) {
	                	Roomhandling.Roominfo[Roomhandling.getindex()] = vData;
	                	Roomhandling.increindex();
	                    arrS[i][j]="X";
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

	    static boolean chkFull() {  // Method that will check if all reservations were occupied
	        for (i=0; i<10; ++i) {
	            for (j=0; j<5; ++j) {
	                if (!(arrS[i][j]).equals("X")) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }


	    public static void Initializearray() {
	    	for (i=0; i<10; ++i) {                                   // Initialized array with constant data
	            for (j=0; j<5; ++j) {
	                arrS[i][j] = new String((i+1) + cName[j]);
	            }
	        }
	    }

	    public void reservation() {
	    	String inData = new String("");
	    	int inp = 0;
	    	do {				// Loop until user press X to exit
	            dispData();

	            if (chkFull()){
	                System.out.println("Reservation is FULL");
	                inData="X";
	            }
	            else {
	                System.out.print("Enter the room number for Beds Reservation: ");
	                inData = input.next();
	                if (chkData(inData)) {
	                    System.out.println("Reservation Successful!");
	                	System.out.println();
	                	dispData();
	                	}
	                else {
	                    System.out.println("Occupied Seat!");
	                	System.out.println();
	                }
	             }

	          System.out.println("Keep continue?? 1:Yes 0:No");
                inp = input.nextInt();
                if((inp == 0 || inp > 1))
	                  break;
                Roomhandling.showroom();
	        } while (!inData.equalsIgnoreCase("X"));
	    }

	}

	// Beds booking by Kaori
