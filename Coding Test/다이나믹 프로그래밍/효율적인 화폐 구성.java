import java.util.*;
import java.io.*;

class Main {	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 정수 N과 M을 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] value = new int[N];
		for(int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		
		// 앞에 계산된 결과를 저장하기 위한 DP 테이블 초기화
		int[] d = new int[M + 1];
		Arrays.fill(d, 10001);
		d[0] = 0;
		
		// 다이나믹 프로그래밍 진행(Bottom-up)
		for(int i = 0; i < N; i++) {
			for(int j = value[i]; j <= M; j++) {
				// (i - k)원을 만드는 방법이 존재하는 경우
				if(d[j - value[i]] != 10001)
					d[j] = Math.min(d[j], d[j - value[i]] + 1);
			}
		}
		
		// 계산된 결과 출력
		if(d[M] == 10001) // 최종적으로 M원을 만드는 방법이 없는 경우
			bw.write(-1 + "");
		else
			bw.write(d[M] + "");
		bw.close();
	}
}