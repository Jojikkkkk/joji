public class Patient extends Person{


	public void shoinfo() {
		System.out.println("Name is :" + getName());
		System.out.println("Adress is :"+ getAddrees());
		System.out.println("Gender is :"+ getAge());
		System.out.println("Age is :"+ getGender());
		System.out.println("IDnumber is :"+ getIDnumber());
	}

	public void CheckID(int ID) {
		  IDhandling.setIDpatient(ID);
		   setID(IDhandling.getIDpatient());
	}


}
