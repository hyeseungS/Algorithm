import java.util.Scanner;

class Main {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int a = in.nextInt();
	    int b = in.nextInt();
	    int c = in.nextInt();
	    int prize;
	    
	    if(a == b) {
	        if(b == c) {
	            prize = 10000 + a * 1000;   
	        }
	        else {
	            prize = 1000 + a * 100;
	        }
	    }
	    
	    else if (a == c || b == c) {
	        prize = 1000 + c * 100;
	    }
	    
	    else {
	        int max = a;
	        if(b > max) max = b;
	        if(c > max) max = c;
	        prize = max * 100;
	    }
	    
	    System.out.print(prize);
	}
}