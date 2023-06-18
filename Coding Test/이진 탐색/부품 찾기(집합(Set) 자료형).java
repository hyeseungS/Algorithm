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
	    // 집합(Set) 정보를 처리하기 위한 HashSet 라이브러리
	    HashSet<Integer> s = new HashSet<>();
	    for(int i = 0; i < N; i++) 
	        s.add(Integer.parseInt(st.nextToken()));
	    
	    int M = Integer.parseInt(br.readLine()); // 문의한 부품 개수
	    // 문의한 부품 번호 입력 받기
	    st = new StringTokenizer(br.readLine());
	    int[] targets = new int[M];

	    for(int i = 0; i < M; i++) {
	    	targets[i] = Integer.parseInt(st.nextToken());
	    }
	    // 손님이 확인 요청한 부품 번호를 하나씩 확인
	    for(int i = 0; i < M; i++) {
	    	// 해당 부품 존재하는지 확인
	        if(s.contains(targets[i])) bw.write("yes "); 
	        else bw.write("no ");
	    }
	    
	    bw.close();
	}
}