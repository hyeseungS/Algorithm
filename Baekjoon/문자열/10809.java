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
	    int location[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	    
	    for(int i = 0; i < s.length(); i++) {
	       if(location[s.charAt(i) - 'a'] == -1) {
	                location[s.charAt(i) - 'a'] = i;
	       }
	    }
	    
	    for(int i = 0; i < 26; i++) {
	        bw.write(location[i] + " ");
	    }
	    
	    bw.close();
	}
}