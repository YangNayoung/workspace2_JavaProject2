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
		Person p = new Student("ȫ�浿");//��ĳ���� �߻�
		Student s;
		
		s = (Student)p;//�ٿ� ĳ����
		
		System.out.println(s.name);//���� ����
		s.grade = "A";//��������
		
	}
}