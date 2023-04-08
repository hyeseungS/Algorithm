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
	    int n = Integer.parseInt(br.readLine());
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    double max = 0.0;
	    int[] score = new int[n];
	    double result = 0.0;
	    
	    for(int i = 0; i < n; i++) {
	        score[i] = Integer.parseInt(st.nextToken());
	        if(score[i] > max) max = score[i];
	    }
	    
	    for(int i = 0; i < n; i++) {
	        result += score[i]/max*100;
	    }
	    
	    bw.write((result/n) + " ");
		
		bw.close();
	}
}