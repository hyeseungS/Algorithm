import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int t = Integer.parseInt(br.readLine());
	    
	    for(int i = 0; i < t; i++) {
	        st = new StringTokenizer(br.readLine());
	        int count = Integer.parseInt(st.nextToken());
	        String s = st.nextToken();
	        for(int j = 0; j < s.length(); j++) {
	            for(int k = 0; k < count; k++) {
	                bw.write(s.charAt(j));
	            }
	        }
	        bw.write("\n");
	    }
	    
	    bw.close();
	}
}