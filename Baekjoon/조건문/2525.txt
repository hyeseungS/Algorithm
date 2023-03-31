import java.util.Scanner;

class Main {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int a = in.nextInt();
	    int b = in.nextInt();
	    int c = in.nextInt();
	    
	    a += c / 60;
	    b += c % 60;
	    
	    if(b >= 60) {
	        a++;
	        b -= 60;
	    }
	    
	    System.out.printf("%d %d", a >= 24? a % 24 : a, b);
	}
}