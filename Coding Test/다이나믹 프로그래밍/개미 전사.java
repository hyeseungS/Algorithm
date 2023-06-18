import java.util.*;
import java.io.*;

class Main {	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 정수 N을 입력받기
		int N = Integer.parseInt(br.readLine());
		
		// 모든 식량 정보 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] storage = new int[N];
		
		for(int i = 0; i < N; i++) {
			storage[i] = Integer.parseInt(st.nextToken());
		}
		
		// 앞에 계산된 결과를 저장하기 위한 DP 테이블 초기화
		int[] d = new int[N];
		d[0] = storage[0];
		d[1] = Math.max(d[0], storage[1]);
		
		// 다이나믹 프로그래밍 진행(Bottom-up)
		for(int i = 2; i < N; i++) {
			d[i] = Math.max(d[i - 1], d[i - 2] + storage[i]);		
		}
		
		// 계산된 결과 출력
		bw.write(d[N - 1] + "");
		bw.close();
	}
}