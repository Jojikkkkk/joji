package Project190B;
import java.util.Scanner;

public class Week {
	

		public static final int ROOMS = 4;
		public static final int DAYS = 7;
		public static final int BLOCKS = 26;
		private Appointment[][][] schedule = new Appointment[ROOMS][DAYS][BLOCKS];
		
		public Week() {
			for (int i=0; i<ROOMS; i++){
			      for (int j=0; j<DAYS; j++){
			        for (int n=0; n<BLOCKS; n++){
			          schedule[i][j][n] = new Appointment();
			        	}
			      }
			}
		}
		public void makeAppointment(Doctor doctor, Patient patient) {
			Scanner entry = new Scanner (System.in);
			System.out.println("Please select the number for the day of the week you would like to make an appointment. ");
			System.out.println("1. Monday\n2. Tuesday\n3. Wednesday\n4. Thursday\n5. Friday\n6. Saturday\n7. Sunday");
			int dayNumber=entry.nextInt();
			System.out.println("Please select the time that you would like the appointment to start.");
			System.out.println("1. 7:00am\t2. 7:30am\t3. 8:00am\t4. 8:30am\t5. 9:00am\t6. 9:30am");
			System.out.println("7. 10:00am\t8. 10:30am\t9. 11:00am\t10. 11:30am\t11. 12:00pm\t12. 12:30pm");
			System.out.println("13. 1:00pm\t14. 1:30pm\t15. 2:00pm\t16. 2:30pm\t17. 3:00pm\t18. 3:30pm");
			System.out.println("19. 4:00pm\t20. 4:30pm\t21. 5:00pm\t22. 5:30pm\t23. 6:00pm\t24. 6:30pm");
			System.out.println("25. 7:00pm\t26. 7:30pm\t");
			int blockNumber=entry.nextInt();
			System.out.println("How long will the appointment be?\n1. 30 minutes\n2. 1 hour\n3. 1 hour 30 minutes\n4. 2 hours");
			int duration=entry.nextInt();
			System.out.println("Which room would you like? (Please enter 1, 2, 3, or 4)");
			int roomNumber=entry.nextInt();
			for (int i=0; i<duration; i++) {
				if (schedule[roomNumber-1][dayNumber-1][blockNumber-1+i].checkVacancy()) {
					schedule[roomNumber-1][dayNumber-1][blockNumber-1+i]=new Appointment(doctor, patient);
				}
			}
		}
		public void writeAppointmentInfo() {
			Scanner entry=new Scanner (System.in);
			System.out.println("Please select the number for the day of the week for the appointment you are seeking. ");
			System.out.println("1. Monday\n2. Tuesday\n3. Wednesday\n4. Thursday\n5. Friday\n6. Saturday\n7. Sunday");
			int dayNumber=entry.nextInt();
			System.out.println("What time does the appointment start?");
			System.out.println("1. 7:00am\t2. 7:30am\t3. 8:00am\t4. 8:30am\t5. 9:00am\t6. 9:30am");
			System.out.println("7. 10:00am\t8. 10:30am\t9. 11:00am\t10. 11:30am\t11. 12:00pm\t12. 12:30pm");
			System.out.println("13. 1:00pm\t14. 1:30pm\t15. 2:00pm\t16. 2:30pm\t17. 3:00pm\t18. 3:30pm");
			System.out.println("19. 4:00pm\t20. 4:30pm\t21. 5:00pm\t22. 5:30pm\t23. 6:00pm\t24. 6:30pm");
			System.out.println("25. 7:00pm\t26. 7:30pm\t");
			int blockNumber=entry.nextInt();
			System.out.println("Which room is the appointment in? (Please enter 1, 2, 3, or 4)");
			int roomNumber=entry.nextInt();
			System.out.println("The doctor and patient in this appointment are :");
			schedule[roomNumber-1][dayNumber-1][blockNumber-1].writeAppointment();
		}
		public void getDailySchedule() {
			Scanner entry　=new Scanner (System.in);
			System.out.println("Please enter the number for the day of the week you would like. ");
			System.out.println("1. Monday\n2. Tuesday\n3. Wednesday\n4. Thursday\n5. Friday\n6. Saturday\n7. Sunday");
			int dayNumber = entry.nextInt();
			System.out.println("The daily schedule for "+getDay(dayNumber)+" is as follows.");
			System.out.println("TIME\tROOM 1\tROOM 2\tROOM 3\tROOM 4");
			for (int i=0; i<BLOCKS; i++) {
				System.out.print(getBlockTime(i));
				for (int j=0; j<ROOMS; j++) {
					if (schedule[j][dayNumber-1][i].checkVacancy()) {
						System.out.print("\t______");
					}
					else System.out.print("\tFull");
				}
				System.out.println();
			}	
		}
		public void getFullSchedule() {
			for (int n=0; n<DAYS; n++) {
				System.out.println("The daily schedule for "+getDay(n+1)+" is as follows.");
				System.out.println("TIME\tROOM 1\tROOM 2\tROOM 3\tROOM 4");
				for (int i=0; i<BLOCKS; i++) {
					System.out.print(getBlockTime(i));
					for (int j=0; j<ROOMS; j++) {
						if (schedule[j][n][i].checkVacancy()) {
							System.out.print("\t______");
						}
						else System.out.print("\tFull");
					}
					System.out.println();
				}
				System.out.println();
			}
		}
		public void getRoomSchedule() {
			Scanner entry=new Scanner (System.in);
			System.out.println("Please enter the room's number (1, 2, 3, or 4): ");
			int roomNumber = entry.nextInt();
			System.out.println("The weekly schedule for room "+roomNumber+" is as follows.");
			System.out.println("TIME\tMON\tTUE\tWED\tTHU\tFRI\tSAT\tSUN");
			for (int i=0; i<BLOCKS; i++) {
				System.out.print(getBlockTime(i));
				for (int j=0; j<DAYS; j++) {
					if (schedule[roomNumber-1][j][i].checkVacancy()) {
						System.out.print("\t______");
					}
					else System.out.print("\tFull");
				}
				System.out.println();
			}	
		}
		private String getBlockTime(int input) {
			switch(input) {
			case 0:
				return "7:00am";
			case 1:
				return "7:30am";
			case 2:
				return "8:00am";
			case 3:
				return "8:30am";
			case 4:
				return "9:00am";
			case 5:
				return "9:30am";
			case 6:
				return "10:00am";
			case 7:
				return "10:30am";
			case 8:
				return "11:00am";
			case 9:
				return "11:30am";
			case 10:
				return "12:00pm";
			case 11:
				return "12:30pm";
			case 12:
				return "1:00pm";
			case 13:
				return "1:30pm";
			case 14:
				return "2:00pm";
			case 15:
				return "2:30am";
			case 16:
				return "3:00pm";
			case 17:
				return "3:30pm";
			case 18:
				return "4:00pm";
			case 19:
				return "4:30pm";
			case 20:
				return "5:00pm";
			case 21:
				return "5:30pm";
			case 22:
				return "6:00pm";
			case 23:
				return "6:30pm";
			case 24:
				return "7:00pm";
			case 25:
				return "7:30pm";
			case 26:
				return "8:00pm";
			default:
				return "00:00";
			}
		}
		private String getDay(int day) {
			switch(day) {
			case 1:
				return "Monday";
			case 2:
				return "Tuesday";
			case 3:
				return "Wednesday";
			case 4:
				return "Thursday";
			case 5:
				return "Friday";
			case 6:
				return "Saturday";
			case 7:
				return "Sunday";
			default:
				return "Unknown Day";
				}
			}
	}

