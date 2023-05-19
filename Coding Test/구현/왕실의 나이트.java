import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    String move = br.readLine();
	    
	    int[][] dir = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1 ,2}, {-1, 2}, {1, -2}, {-1, -2}};
	    int x = move.charAt(0) - 'a', y = move.charAt(1) - '1';
    	int ans = 0;
    	
    	for(int i = 0; i < 8; i++) {
    	    if(x + dir[i][0] < 0 || x + dir[i][0] > 7 || y + dir[i][1] < 0 || y + dir[i][1] > 7) continue;
    	    ans++;
    	}
	    
	    bw.write(ans + "");
	    bw.close();
	}
}