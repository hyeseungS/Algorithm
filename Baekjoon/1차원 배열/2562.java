import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = 1;
        int max = 0;
        
        for(int i = 1; i < 10; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number > max) {
                max = number;
                n = i;
            }
        }
        
        bw.write(max + "\n" + n);
        
        bw.close();
    }
}