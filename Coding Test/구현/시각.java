import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    // N 입력받기
	    int N = Integer.parseInt(br.readLine());
	    
	    int ans = 0;
	    
	    for(int i = 0; i <= N; i++) {
	        for(int j = 0; j < 60; j++) {
	            for(int k = 0; k < 60; k++) {
	                // 매 시각 안에 '3'이 포함되어 있다면 카운트 증가
	                if((String.valueOf(i) + String.valueOf(j) + String.valueOf(k)).contains("3")) {
	                    ans++;
	                }
	            }
	        }
	    }
	    
	    // 최종 답안 출력
	    bw.write(ans + "");
	    bw.close();
	}
}