import java.util.*;
import java.io.*;

class Main {	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 정수 N을 입력받기
		int N = Integer.parseInt(br.readLine());
		
		// 앞에 계산된 결과를 저장하기 위한 DP 테이블 초기화
		int[] d = new int[N + 1];
		d[1] = 1;
		d[2] = 3;
		
		// 다이나믹 프로그래밍 진행(Bottom-up)
		for(int i = 3; i <= N; i++) {
			d[i] = (d[i - 1] + d[i - 2] * 2) % 796796;		
		}
		
		// 계산된 결과 출력
		bw.write(d[N] + "");
		bw.close();
	}
}