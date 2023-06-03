import java.util.*;
import java.io.*;

public class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    // N을 입력받기
	    int N = Integer.parseInt(br.readLine());
	    
	    // N개의 정수를 입력받아 리스트에 저장
	    Integer[] arr = new Integer[N];
	   
	    for(int i = 0; i < N; i++) {
	        arr[i] = Integer.parseInt(br.readLine());
	    }
	    
	    // 기본 정렬 라이브러리를 이용하여 내림차순 정렬 수행
	    Arrays.sort(arr, Collections.reverseOrder());
	    
	    for(int i = 0; i < N; i++) {
	        bw.write(arr[i] + " ");    
	    }
	    
	    bw.close();
	    
	}
	
}