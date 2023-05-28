import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    // N, M을 공백으로 구분하여 입력받기
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    // 행 별로 가장 낮은 카드 뽑기
	    int[] rowCard = new int[N];
	    for(int i = 0; i < N; i++) {
	        st = new StringTokenizer(br.readLine());
	        int min = Integer.parseInt(st.nextToken());
	        for(int j = 1; j < M; j++) {
	            int card = Integer.parseInt(st.nextToken());
	            if(min > card) { 
	                min = card;
	            }
	        }
	        rowCard[i] = min;
	    }
	    
	     // 행 별로 가장 낮은 수들 정렬하기
	    Arrays.sort(rowCard);
	    
	    // 최종 답안 출력
	    bw.write(rowCard[N - 1] + "");
	    bw.close();
	}
}