import java.util.Scanner;

class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int t = in.nextInt();
        int[] result = new int[t];
		for(int i = 0; i < t; i++) {
		    int a = in.nextInt();
		    int b = in.nextInt();
		    result[i] = a + b;
		}
		
		for(int i = 0; i < t; i++) {
		    System.out.println(result[i]);
		}
	}
}