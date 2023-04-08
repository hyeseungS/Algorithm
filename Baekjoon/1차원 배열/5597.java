import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        boolean[] student = new boolean[30];
        
        for(int i = 0; i < 28; i++) {
            
            student[Integer.parseInt(br.readLine()) - 1] = true;
            
        }
        
        for(int i = 0; i < 30; i++) {
            if(!student[i]) 
                bw.write((i + 1) + "\n");
        }
        
        bw.close();
    }
}