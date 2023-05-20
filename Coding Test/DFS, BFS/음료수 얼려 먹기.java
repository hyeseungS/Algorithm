import java.util.*;
import java.io.*;

class Main {
    
    static int N = 0;
    static int M = 0;
    
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
	    
	    // 모든 노드에 대하여 음료수 채우기
	    int ans = 0;
	    
	    for(int i = 0; i < N; i++) {
	        for(int j = 0; j < M; j++) {
	            // 현재 노드에서 DFS 수행
	            if(dfs(graph, i, j) == true) ans++;
	        }
	    }
	    
	    bw.write(ans + "");
	    bw.close();
	}
	
	public static boolean dfs(int[][] graph, int x, int y) {
	    
	    // 얼음틀 범위 벗어나면 종료 조건
	    if(x <= -1 || x >= N || y <= -1 || y >= M) {
	        return false;
	    }
	    
	    // 현재 노드 아직 방문하지 않았다면
	    if(graph[x][y] == 0) {
	        // 현재 노드 방문 처리
	        graph[x][y] = 1;
	        
	        // 상, 하, 좌, 우 방문 여부 확인 후, 방문하지 않았을 경우 방문 처리
	        dfs(graph, x - 1, y);
	        dfs(graph, x + 1, y);
	        dfs(graph, x, y - 1);
	        dfs(graph, x, y + 1);
	        
	        return true;
	    }
	    return false;
	    
	}
}