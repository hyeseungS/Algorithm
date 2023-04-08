import java.util.Scanner;

class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		for(int i = 1; i < 10; i++) {
		    System.out.printf("%d * %d = %d\n", a, i, a * i);   
		}
	}
}