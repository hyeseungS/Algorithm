import java.util.*;
import java.io.*;

class Main {	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 정수 X를 입력 받기
		int X = Integer.parseInt(br.readLine());
		
		// 앞에 계산된 결과를 저장하기 위한 DP 테이블 초기화
		long[] d = new long[X + 1];
		
		// 다이나믹 프로그래밍 진행(Bottom-up)
		for(int i = 2; i <= X; i++) {
			// 현재의 수에서 1을 빼는 경우
			d[i] = d[i - 1];
			// 현재의 수가 5로 나누어 떨어지는 경우
			if(i % 5 == 0) {
				d[i] = Math.min(d[i],  d[i / 5]);
			}
			// 현재의 수가 3으로 나누어 떨어지는 경우
			if(i % 3 == 0) {
				d[i] = Math.min(d[i],  d[i / 3]);
			}
			// 현재의 수가 2로 나누어 떨어지는 경우
			if(i % 2 == 0) {
				d[i] = Math.min(d[i],  d[i / 2]);
			}
			d[i]++;
		}
		
		bw.write(d[X] + "");
		bw.close();
	}
}