import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    // N, M을 공백으로 구분하여 입력받기
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    // 방문 위치 저장을 위한 맵 생성
	    int[][] map = new int[N][M];
	    
	    // 현재 캐릭터의 X 좌표, Y 좌표, 방향 입력받기
	    st = new StringTokenizer(br.readLine());
	    int A = Integer.parseInt(st.nextToken());
	    int B = Integer.parseInt(st.nextToken());
	    int dir = Integer.parseInt(st.nextToken());
	    // 현재 좌표 방문 처리
	    map[A][B] = 1;
	    
	    // 전체 맵 정보 입력
	    for(int i = 0; i < N; i++) {
    	    st = new StringTokenizer(br.readLine());
    	    for(int j = 0; j < M; j++) {
    	        map[i][j] = Integer.parseInt(st.nextToken());
    	    }
    	}
	    
	    // 북, 동, 남, 서 방향 정의
	    int[] dx = {-1, 0, 1, 0};
	    int[] dy = {0, 1, 0, -1};
	    
	    // 시뮬레이션 시작
    	int ans = 1;
    	int back = 0;
	    
	    while(true) {
	        
	        // 왼쪽으로 회전
	        dir = (dir + 3) % 4;
	        
	        // 회전 이후, 가보지 않은 칸 존재하는 경우 이동
	        if(map[A + dx[dir]][B + dy[dir]] == 0) {
	            A += dx[dir];
	            B += dy[dir];
	            map[A][B] = 1;
	            ans++;
	            back = 0;
	        }
	        // 회전 이후, 가보지 않은 칸이 없거나 바다인 경우
	        else back++;
	        
	        // 네 방향 모두 갈 수 없는 경우
	        if(count == 4) {
	            // 뒤로 이동하기
	            if(map[A - dx[dir]][B + dy[dir] == 0) {
	                A += dx[dir];
	                B += dy[dir];
	                map[A][B]++;
	                ans++;
	                continue;
	            }
	            // 멈춤
	            else break;
	        }
	    }
	    
	    bw.write(ans + "");
	    bw.close();
	}
}