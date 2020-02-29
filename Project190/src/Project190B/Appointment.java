package Project190B;


	public class Appointment {
		private Doctor d = new Doctor();
		private Patient p = new Patient();
		
		public Appointment() {
			d.setName("Unoccupied");
			p.setName("Unoccupied");
		}
		public Appointment(Doctor d1, Patient p1) {
			d.setName(d1.getName());
			p.setName(p1.getName());
		}
		public void writeAppointment() {
			System.out.println(d.getName());
			System.out.println(p.getName());
		}
		public boolean checkVacancy() {
			if (p.getName()=="Unoccupied") return true;
			else return false;
		}
	}

