import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int n = Integer.parseInt(br.readLine());
	    String s = br.readLine();
	    int sum = 0;
	    
	    for(int i = 0; i < n; i++) {
	        sum += s.charAt(i) - '0';
	    }
	    
	    bw.write(sum + "");
	    
	    bw.close();
	}
}