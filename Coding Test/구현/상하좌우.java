import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int N = Integer.parseInt(br.readLine());
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int[] dx = {0, 0, -1, 1};
	    int[] dy = {-1, 1, 0, 0};
	    String[] move = {"L", "R", "U", "D"};
	    int x = 1, y = 1;
	    String dir = "";
	    
	    while(st.hasMoreTokens()) {
	        dir = st.nextToken();
	        for(int i = 0; i < 4; i++) {
	            if(dir.equals(move[i])) {
	                if(x + dx[i] < 1 || y + dy[i] < 1 || x + dx[i] > N || y + dy[i] > N) continue;
	                x += dx[i];
	                y += dy[i];
	            }
	        }
	    }
	    
	    bw.write(x + " " + y);
	    bw.close();
	}
}