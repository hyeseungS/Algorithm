import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int[] number = new int[42];
	    int result = 0;
	    
	    for(int i = 0; i < 10; i++) {
	        number[Integer.parseInt(br.readLine()) % 42]++;
	    }
	    
	    for(int i = 0; i < 42; i++) {
	        if(number[i] == 0) continue;
	        result++;
	    }
	    
	    bw.write(result + "");
		
		bw.close();
	}
}