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
	    int[] A = new int[N];
	    for(int i = 0; i < N; i++) 
	        A[i] = Integer.parseInt(st.nextToken());
	    Arrays.sort(A);
	    
	    int M = Integer.parseInt(br.readLine()); // 문의한 부품 개수
	    // 문의한 부품 번호 입력 받기
	    st = new StringTokenizer(br.readLine());
	    int[] B = new int[M];
	    for(int i = 0; i < M; i++)
	        B[i] = Integer.parseInt(st.nextToken()); 
	    
	    // 이진 탐색 수행 결과 출력
	    for(int i = 0; i < M; i++) {
	        int result = binarySearch(A, B[i], 0, N - 1);
	        if(result == -1) {
	    	    bw.write("no ");
	        }
	        else bw.write("yes ");
	    }
	    
	    bw.close();
	}
	
	// 이진 탐색 소스코드 구현(반복문)
	public static int binarySearch(int[] array, int target, int start, int end) {
		int mid = 0;
		while(start <= end) {
			mid = (start + end) / 2;
			// 찾은 경우 중간점 인덱스 반환
			if(array[mid] == target) return mid;
			// 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
			else if(array[mid] > target) end = mid - 1;
			// 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
			else start = mid + 1;
		}
		return -1;
	}
}