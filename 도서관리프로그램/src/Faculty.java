package 도서관리프로그램;

public class Faculty extends Person{ 

	public Faculty(String name, int age, String address) {
		super();
		super.status = "Faculty";
		super.name = name;
		super.age = age;
		super.address = address;
	}
}