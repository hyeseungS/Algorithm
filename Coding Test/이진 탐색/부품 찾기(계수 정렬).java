import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int N = Integer.parseInt(br.readLine()); // 부품의 개수
	    // 부품 번호 입력 받기
	    st = new StringTokenizer(br.readLine());
	    int[] A = new int[1000001];
	    for(int i = 0; i < N; i++) 
	        A[Integer.parseInt(st.nextToken())] = 1;
	    
	    int M = Integer.parseInt(br.readLine()); // 문의한 부품 개수
	    // 문의한 부품 번호 입력 받기
	    st = new StringTokenizer(br.readLine());
	    // 손님이 확인 요청한 부품 번호를 하나씩 확인
	    for(int i = 0; i < M; i++) {
	    	// 해당 부품 존재하는지 확인
	        if(A[Integer.parseInt(st.nextToken())] == 1) bw.write("yes "); 
	        else bw.write("no ");
	    }
	    
	    bw.close();
	}
}