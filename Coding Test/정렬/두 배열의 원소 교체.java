import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    // N과 K를 입력받기
	    int N = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    // 배열 A와 B의 모든 원소를 입력받기
	    Integer[] A = new Integer[N];
	    Integer[] B = new Integer[N];
	    
	    StringTokenizer st1 = new StringTokenizer(br.readLine());
	    StringTokenizer st2 = new StringTokenizer(br.readLine());
	    
	    for(int i = 0; i < N; i++) {
	        A[i] = Integer.parseInt(st1.nextToken());
	        B[i] = Integer.parseInt(st2.nextToken());
	    }
	    
	    // 배열 A, B 오름차순, 내림차순 정렬 수행
	    Arrays.sort(A);
	    Arrays.sort(B, Collections.reverseOrder());
	    
	    // 첫 번째 인덱스부터 확인하며, 두 배열의 원소를 최대 K번 비교
	    for(int i = 0; i < K; i++) {
		// A의 원소가 B의 원소보다 작은 경우
	    	if(A[i] < B[i])
			// A 원소를 B 원소로 교체
	    		A[i] = B[i];
		// A의 원소가 B의 원소보다 크거나 같을 때, 반복문 탈출
	    	else break;
	    }
	    
	    // 배열 A의 모든 원소의 합을 출력
	    int ans = 0;
	    for(int i = 0; i < N; i++) {
	        ans += A[i];
	    }
	    
	    bw.write(ans + " ");
	    bw.close();
	}
}