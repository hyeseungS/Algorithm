import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12480KB, 120ms
public class 1091 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		int[] S = new int[N];
		int[] card = new int[N]; // 카드 순서대로 카드를 줄 플레이어 번호가 담긴 배열 0, 1, 2, 0, 1, 2, ...
		int[] beforeMix = new int[N]; // 섞기 전 (모든 카드를 섞기 위해 섞기 전 카드를 저장해놓음)
		int[] afterMix = new int[N]; // 섞은 후
		StringTokenizer stP = new StringTokenizer(br.readLine());
		StringTokenizer stS = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(stP.nextToken());
			S[i] = Integer.parseInt(stS.nextToken());
			beforeMix[i] = P[i];
			card[i] = i % 3;
		}
		
		int ans = 0;
		while(!same(card, beforeMix, N)) { // P를 여러번 섞어 0, 1, 2, 0, 1, 2, ... 순서가 되는 경우의 반복문 멈춤 결과 출력
			mix(S, beforeMix, afterMix, N); // 카드 섞기
			ans++;
			if(same(P, beforeMix, N)) { // P를 여러번 섞으면 다시 처음 P로 같게 되는 경우 -1
				ans = -1;
				break;
			}
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 2개의 배열 같은지 확인하는 메소드
	public static boolean same(int[] a, int[] b, int n) {
		for (int i = 0; i < n; i++) {
			if(a[i] != b[i]) return false;
		}
		return true;
	}
	
	// 카드 1번 섞는 메소드
	public static void mix(int[] S, int[] beforeMix, int[] afterMix, int n) {
		for (int i = 0; i < n; i++) {
			afterMix[S[i]] = beforeMix[i];
		}
		for (int i = 0; i < n; i++) {
			beforeMix[i] = afterMix[i];
		}
	}

}
/*
 처음에 문제가 잘 이해 안됐던 문제 -> 그냥 구현 문제였다.
 P 섞는 방법 : i번째 카드는 S[i]번째 위치로 이동
 1. P를 여러번 섞으면 다시 처음 P로 같게 되는 경우가 존재한다. -> 이경우는 -1
 2. P를 여러번 섞어 0, 1, 2, 0, 1, 2, ... 순서가 되는 경우의 횟수를 출력한다.
 */
