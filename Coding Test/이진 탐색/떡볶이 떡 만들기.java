import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    // 떡의 개수(N)와 요청한 떡의 길이(M)을 입력받기
	    int N = Integer.parseInt(st.nextToken()); 
	    int M = Integer.parseInt(st.nextToken());
	    
	    // 각 떡의 개별 높이 정보를 입력받기
	    st = new StringTokenizer(br.readLine());
	    int[] len = new int[N];
	    for(int i = 0; i < N; i++) {
	    	len[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    // 이진 탐색 수행 결과 출력
	    int ans = binarySearch(len, M, 0, (int) 1e9);
	    bw.write(ans + "");
	    
	    bw.close();
	}
	
	// 이진 탐색 수행 (반복문)
	public static int binarySearch(int[] array, int target, int start, int end) {
		int ans = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			long sum = 0;
			for(int i = 0; i < array.length; i++) {
				// 잘랐을 때의 떡의 양 계산
				if(array[i] > mid) 
					sum += array[i] - mid;
			}
			// 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
			if(sum < target) {
				end = mid - 1;
			}
			// 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색)
			else {
				ans = mid; // 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록
				start = mid + 1;
			}
		}
		
		return ans;
	}
}