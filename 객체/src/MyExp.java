
public class MyExp {
	int base;
	int exp;
	public MyExp(int a, int b) {
		this.base = a;
		this.exp = b;
	}
	int getValue() {
		int res = 1;
		for(int i = 0; i < exp; i++) 
			res = res * base;
		return res;
	}

	public static void main(String[] args) {
		MyExp number1 = new MyExp(2, 3);
		System.out.println("2의 3승 = "+number1.getValue());
	}
}
