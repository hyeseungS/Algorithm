import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    String s = br.readLine();
	    int i = Integer.parseInt(br.readLine());
	    
	    bw.write(s.charAt(i - 1));
	    
	    bw.close();
	}
}