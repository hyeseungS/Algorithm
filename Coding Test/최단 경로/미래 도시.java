import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
	    // 노드의 개수, 간선의 개수 입력 받기
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
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
	        graph[a][b] = 1;
	        graph[b][a] = 1;
	    }
	    
	    // 점화식에 따라 플로이드 워셜 알고리즘을 수행
	    for(int k = 1; k <= N; k++) {
	    	for(int a = 1; a <= N; a++) {
	    		for(int b = 1; b <= N; b++) {
	    			graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
	    		}
	    	}
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    int X = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    // 방문 판매원 A가 K번 회사를 거쳐 X번 회사로 가는 최소 이동 시간 출력
	    int distance = graph[1][K] + graph[K][X];
	    if(distance >= INF) {
	    	bw.write("-1");
	    }
	    else bw.write(distance + "");
	    
	    bw.close();
	}
}