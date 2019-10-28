package 도서관리프로그램;

public class Student extends Person{	
	public Student(String name, int age, String address) {
		super();
		super.status = "student";
		super.name = name;
		super.age = age;
		super.address = address;
	}
}