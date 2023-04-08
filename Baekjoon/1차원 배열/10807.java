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
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int v = Integer.parseInt(br.readLine());
        int result = 0;
        
        for(int i = 0; i < n; i++) {
            if(Integer.parseInt(st.nextToken()) == v) {
                result++;
            }
        }
        
        bw.write(result + "");
        
        bw.close();
    }
}