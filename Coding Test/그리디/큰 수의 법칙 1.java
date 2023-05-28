import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    // N, M, K를 공백으로 구분하여 입력받기
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    
	    // N개 수를 공백으로 구분하여 입력받기
	    int[] arr = new int[N];
	    for(int i = 0; i < N; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    // 입력 받은 수들 정렬하기
	    Arrays.sort(arr);
	    
	    int ans = 0;
	    while(true) {
	        for(int i = 0; i < K; i++) { // 가장 큰 수 K번 더하기
	            if(M == 0) { // M이 0이면 반복문 탈출
	                break;
	            }
	            ans += arr[N - 1];
	            M--; // 더할 때마다 1씩 빼기
	        }
	        if(M == 0) { // M이 0이라면 반복문 탈출
	            break;
	        }
	        ans += arr[N - 2]; // 두 번째로 큰 수 한 번 더하기
	        M--; // 더할 때마다 1씩 빼기
	    }
	    
	    // 최종 답안 출력
	    bw.write(ans + "");
	    bw.close();
	}
}