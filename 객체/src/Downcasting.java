class Person {
	String name;
	String id;
	
	public Person(String name) {
		this.name = name;
	}
}
class Student extends Person {
	String grade;
	String department;
	
	public Student(String name) {
		super(name);
	}
}

public class Downcasting {
	public static void main(String[] args) {
		Person p = new Student("홍길동");//업캐스팅 발생
		Student s;
		
		s = (Student)p;//다운 캐스팅
		
		System.out.println(s.name);//오류 없음
		s.grade = "A";//오류없음
		
	}
}