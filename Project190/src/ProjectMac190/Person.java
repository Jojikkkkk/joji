package ProjectMac190;
import java.util.Scanner;

/*  This is base class for patient,staff and doctor.
 * Method as a public:
			Person.setInfo();
			Person.setID(int ID)
			Person.setName(String name);
			Person.setAge(int age);
			Person.setGender(String gender);
			Person.setAddress(String address);
			Person.getAddrees();
			Person.getGender();
			Person.getAge();
			Person.getIDnumber();
									*/
public abstract class Person {
	
		private String Name;
		private String Address;
		private String Gender;
		private int Age;
		private int IDnumber = 0;
		Scanner keyboard = new Scanner(System.in);
		abstract public void CheckID(int ID);
		
		Person(){
			Name = "No name yet";
			Address = "No Adress yet";
			Gender = null;
			Age = 0;
			
		}
		
		Person(String Name,String Adress,String Gender,int Age){
			this.Name = Name;
			this.Address = Adress;
			this.Gender = Gender;
			this.Age = Age;
			
		}
		
		
		public void setInfo(){
			String info1[] = {"Name : ","Address : ","Gender :","Age :", "IDnumber :"};
			String info[] = {"","","","",""};
			System.out.println("Fill out information");
			
				for(int i= 0;i < info1.length;++i) {
					if(i==4) {
						int x = IDhandling.IDMaker();
						if(x>0) {info[i] = String.valueOf(x);
						continue;}}
				System.out.print(info1[i]);
				info[i] = keyboard.nextLine();
			}
				
			this.Name = info[0];
			this.Address = info[1];
			this.Gender = info[2];
			this.Age = Integer.parseInt(info[3]);
			CheckID(Integer.parseInt(info[4]));
		}
		

		
		public void setID(int ID){
			IDnumber = ID;
		}
		
		public void setName(String name) {
			this.Name = name;
		}
		
		public void setAge(int age) {
			this.Age = age;
		}
		
		public void setGender(String gender) {
			this.Gender = gender;
		}
		
		public void setAddress(String address) {
			this.Address = address;
		}
		
		public  String getName() {
			return Name;
		}
		
		public  String getAddrees() {
			return Address;
		}
		public String getGender() {
			return Gender;
		}
		public  int getAge() {
			return Age;
		}
		public  int getIDnumber() {
			return IDnumber;
		}
		
		
		
}
