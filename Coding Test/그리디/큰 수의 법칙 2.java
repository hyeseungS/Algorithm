import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    int ans = 0;
	    
	    while(N != 1) {
	        if(N % K == 0) N /= K;
	        else N--;
	        ans++;
	    }
	    
	    bw.write(ans + "");
	    bw.close();
	}
}