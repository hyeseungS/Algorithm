import java.util.*;
import java.io.*;

class Solution {
    
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
	    // 노드의 개수, 간선의 개수 입력 받기
	    int N = Integer.parseInt(br.readLine());
	    int M = Integer.parseInt(br.readLine());
	    
	    // 2차원 리스트(그래프 표현)를 만들고, 모든 값을 무한으로 초기화
	    int[][] graph = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], INF);
        }
        
        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for(int i = 0; i <= N; i++) {
        	for(int j = 0; j <= N; j++) {
        		if(i == j) graph[i][j] = 0;
        	}
        }
	    
	    // 모든 간선 정보를 입력 받기
	    for(int i = 0; i < M; i++) {
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int distance = Integer.parseInt(st.nextToken());
	        // a번 노드에서 b번 노드로 가는 비용이 distance라는 의미
	        graph[a][b] = distance;
	    }
	    
	    // 점화식에 따라 플로이드 워셜 알고리즘을 수행
	    for(int k = 1; k <= N; k++) {
	    	for(int a = 1; a <= N; a++) {
	    		for(int b = 1; b <= N; b++) {
	    			graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
	    		}
	    	}
	    }
	    
	    // 모든 노드로 가기 위한 최단 거리를 출력
	    for(int i = 1; i <= N; i++) {
	    	for(int j = 1; j <= N; j++) {
	    		// 도달할 수 없는 경우, 무한(INFINITY)라고 출력
	    		if(graph[i][j] == INF) bw.write("INFINITY\n");
	    		// 도달할 수 있는 경우 거리를 출력
	    		else bw.write(graph[i][j] + " ");
	    	}
	    	bw.write("\n");
	    }
	    
	    bw.close();
	}
}