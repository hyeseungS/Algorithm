import java.util.Scanner;

class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int result = 0;
		
		for(int i = 1; i <= n; i++) {
		    result += i;
		}
		
		System.out.print(result);
	}
}