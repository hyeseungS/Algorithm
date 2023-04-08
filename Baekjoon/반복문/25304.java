import java.util.Scanner;

class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int n = in.nextInt();
		
		int result = 0;
		
		for(int i = 0; i < n; i++) {
		    int a = in.nextInt();
		    int b = in.nextInt();
		    
		    result += a*b;
		}
		
		if(x == result) System.out.print("Yes");
		else System.out.print("No");
		
	}
}