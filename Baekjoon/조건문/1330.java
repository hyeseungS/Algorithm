import java.util.Scanner;

class Main {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int a = in.nextInt();
	    int b = in.nextInt();
	    if(a > b) System.out.print(">");
	    else if(a < b) System.out.print("<");
	    else System.out.print("==");
	}
}