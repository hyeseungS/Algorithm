import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken()); // 원소의 개수
	    int target = Integer.parseInt(st.nextToken()); // 찾고자 하는 값
	    
	    // 전체 원소 입력 받기
	    st = new StringTokenizer(br.readLine());
	    
	    int[] array = new int[n];
	    for(int i = 0; i < n; i++) {
	        array[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    // 이진 탐색 수행 결과 출력
	    int result = binarySearch(array, target, 0, n - 1);
	    if(result == -1) {
	    	bw.write("원소가 존재하지 않습니다.");
	    }
	    else bw.write(result + 1 + "");
	    
	    bw.close();
	}
	
	// 이진 탐색 소스코드 구현(재귀 함수)
	public static int binarySearch(int[] array, int target, int start, int end) {
	    if(start > end) {
	        return -1;
	    }
	    int mid = (start + end) / 2;
	    // 찾은 경우 중간점 인덱스 반환
	    if(array[mid] == target) return mid;
	    // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
	    else if(array[mid] > target) return binarySearch(array, target, start, mid - 1);
	    // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
	    else return binarySearch(array, target, mid + 1, end);
	}
}