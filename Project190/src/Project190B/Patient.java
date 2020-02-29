package Project190B;

public class Patient {
		private String name;
		
		public Patient() {
			name="No name yet";
		}
		public Patient(String pName) {
			name=pName;
		}
		public void setName(String pName){
			name=pName;
		}
		public String getName() {
			return name;
		}
	}
