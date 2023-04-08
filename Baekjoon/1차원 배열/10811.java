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
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    
	    int[] basket = new int[n];
	    
	    for(int i = 0; i < n; i++) {
	        basket[i] = i + 1;
	    }
	    
	    for(int i = 0; i < m; i++) {
	        st = new StringTokenizer(br.readLine());
	        
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        
	        int[] origin = new int[b - a + 1];
	        int index = 0;
	        for(int j = a - 1; j < b; j++) {
	            origin[index++] = basket[j];
	        }
	        
	        for(int j = a - 1; j < b; j++) {
	            basket[j] = origin[b-j-1];
	        }
	    }
	    
	    for(int i = 0; i < n; i++) {
	        bw.write(basket[i] + " ");
	    }
		
		bw.close();
	}
}