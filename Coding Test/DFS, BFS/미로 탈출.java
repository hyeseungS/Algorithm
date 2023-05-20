import java.util.*;
import java.io.*;
import java.awt.Point;

class Main {
    
    static int N = 0;
    static int M = 0;
    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    // N, M을 공백으로 구분하여 입력 받기
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	
	    // 2차원 배열의 맵 정보 입력 받기
	    int[][] graph = new int[N][M];
	    for(int i = 0; i < N; i++) {
	        String s = br.readLine();
	        for(int j = 0; j < M; j++) {
	            graph[i][j] = s.charAt(j) - '0';
	        }
	    }
	    
	    // BFS 수행한 결과 출력
	    bfs(graph, 0, 0);
	    bw.write(graph[N-1][M-1] + "");
	    bw.close();
	}
	
	public static void bfs(int[][] graph, int x, int y) {
	    
	    // 큐(queue) 구현 위해 사용
	    Queue<Point> q = new LinkedList<>();
	    q.add(new Point(x, y));
	    
	    // 큐가 빌 때까지 반복
	    while(!q.isEmpty()) {
	        Point p = q.poll();
	        x = p.x;
	        y = p.y;
	        
	        // 현재 노드에서 네 방향으로의 노드 확인
	        for(int i = 0; i < 4; i++) {
	            int tmpx = x + dx[i];
	            int tmpy = y + dy[i];
	            // 미로 찾기 공간을 벗어난 경우 무시
	            if(tmpx < 0 || tmpx >= N || tmpy < 0 || tmpy >= M) continue;
	            // 벽인 경우 무시
	            if(graph[tmpx][tmpy] == 0) continue;
	            // 해당 노드 처음 방문하는 경우에만 최단 거리 기록
	            if(graph[tmpx][tmpy] == 1) {
	                graph[tmpx][tmpy] += graph[x][y];
	                q.add(new Point(tmpx, tmpy));
	            }
	        }
	    }
	    
	}
}