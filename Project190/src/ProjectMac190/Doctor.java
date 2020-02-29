package ProjectMac190;

public class Doctor extends Person {
		Doctor(){
 		super();
			}
	 	
	 	public void CheckID(int ID) {
			  IDhandling.setIDDoctor(ID);
			   setID(IDhandling.getIDDoctor());}

	 	
	 	public void shoinfo() {
	 		System.out.println("Name is :" +getName());
			System.out.println("Adress is :"+getAddrees());
			System.out.println("Gender is :"+getAge());
			System.out.println("Age is :"+getGender());
			System.out.println("IDnumber is :"+getIDnumber());
	 }
}