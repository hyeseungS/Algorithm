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
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            sum += (s.charAt(i) - 'A') / 3 + 3;
            if((s.charAt(i) - 'A' == 18) || (s.charAt(i) - 'A' == 21) || (s.charAt(i) - 'A' >= 24))
                sum--;
        }
        
        bw.write(sum + "");
        bw.close();
    }
}