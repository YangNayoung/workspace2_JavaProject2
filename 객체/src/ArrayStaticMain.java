
public class ArrayStaticMain {
	public static void main(String[] args) {
		int [] array1 = {1, 5, 7, 9};
		ArrayStatic.print(array1);
		int [] array2 = {3, 6, -1, 100, 77};
		ArrayStatic.print(array2);
		int [] array3 = ArrayStatic.concat(array1, array2);
		ArrayStatic.print(array3);
	}
}