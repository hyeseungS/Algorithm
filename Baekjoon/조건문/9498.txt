import java.util.Scanner;

class Main {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int a = in.nextInt();
	    if(a >= 90) System.out.print("A");
	    else if(a >= 80) System.out.print("B");
	    else if(a >= 70) System.out.print("C");
	    else if(a >= 60) System.out.print("D");
	    else System.out.print("F");
	}
}