package Project190B;

public class Demo {
		public static void main(String[] args) {
			Week Mon02172020 = new Week();
			Doctor jonesMD= new Doctor("Dr. Jones, MD");
			Patient bates01= new Patient("Simon Bates");
			Mon02172020.makeAppointment(jonesMD, bates01);
			Mon02172020.getDailySchedule();
			Mon02172020.writeAppointmentInfo();
		}
}
