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
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        a = (a % 10) * 100 + ((a % 100) / 10) * 10 + (a / 100); 
        b = (b % 10) * 100 + ((b % 100) / 10) * 10 + (b / 100); 
        bw.write((a > b ? a : b) + "");
        bw.close();
    }
}