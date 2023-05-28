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
	    
	    int ans = (M / (K + 1)) * (K * arr[N - 1] + arr[N - 2]) + (M % (K + 1)) * arr[N - 1];
	    
	    // 최종 답안 출력
	    bw.write(ans + "");
	    bw.close();
	}
}