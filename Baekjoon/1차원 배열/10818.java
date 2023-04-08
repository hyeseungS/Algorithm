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
        
        int n = Integer.parseInt(br.readLine());
        int max = -1000000;
        int min = 1000000;
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            min = number < min ? number : min;
            max = number > max ? number : max;
        }
        
        bw.write(min + " " + max);
        
        bw.close();
    }
}