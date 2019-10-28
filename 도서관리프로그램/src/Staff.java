package 도서관리프로그램;

public class Staff extends Person{
	public Staff(String name, int age, String address) {
		super();
		super.status = "staff";
		super.name = name;
		super.age = age;
		super.address = address;
	}

}