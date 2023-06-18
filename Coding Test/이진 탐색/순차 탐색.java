import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    System.out.println("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요.");
	    st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken()); // 원소의 개수
	    String target = st.nextToken(); // 찾고자 하는 문자열
	    
	    System.out.println("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸으로 합니다.");
	    st = new StringTokenizer(br.readLine());
	    
	    String[] array = new String[n];
	    for(int i = 0; i < n; i++) {
	        array[i] = st.nextToken();
	    }
	    
	    // 순차 탐색 수행 결과 출력
	    int result = sequentialSearch(n, target, array);
	    if(result == -1) {
	    	bw.write("None");
	    }
	    else bw.write(result + "");
	    
	    bw.close();
	}
	
	// 순차 탐색 소스코드 구현
	public static int sequentialSearch(int n, String target, String[] array) {
	    // 각 원소를 하나씩 확인하며
	    for(int i = 0; i < n; i++) {
	        // 현재의 원소가 찾고자 하는 원소와 동일한 경우
	        if (array[i].equals(target))
	        	return i + 1; // 현재 위치 반환(인덱스는 0부터 시작하므로 1 더하기)
	    }
	    // 찾고자 하는 원소가 없는 경우
	    return -1;
	}
}