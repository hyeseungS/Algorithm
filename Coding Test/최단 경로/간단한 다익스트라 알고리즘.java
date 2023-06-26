import java.util.*;
import java.io.*;

class Node {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }
}

class Solution {
    
    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억 설정
    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int N, M, start;
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 방문한 적이 있는지 체크하는 목적의 배열 만들기
    public static boolean[] visited = new boolean[100001];
    // 최단 거리 테이블 만들기
    public static int[] distance = new int[100001];
    
    // 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
    public static int getSmallestNode() {
        int minValue = INF;
        int index = 0; // 가장 최단 거리가 짧은 노드(인덱스)
        for(int i = 1; i <= N; i++) {
            if(distance[i] < minValue && !visited[i]) {
                minValue = distance[i];
                index = i;
            }
        }
        return index;
    }
    
    public static void dijkstra(int start) {
        // 시작 노드에 대해서 초기화
        distance[start] = 0;
        visited[start] = true;
        for(int j = 0; j < graph.get(start).size(); j++) {
            distance[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance(); 
        }
        // 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
        for(int i = 0; i < N - 1; i++) {
            // 현재 최단 거리가 가장 짧은 노드 꺼내서, 방문 처리
            int now = getSmallestNode();
            visited[now] = true;
            // 현재 노드와 연결된 다른 노드를 확인
            for(int j = 0; j < graph.get(now).size(); j++) {
                int cost = distance[now] + graph.get(now).get(j).getDistance();
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if(cost < distance[graph.get(now).get(j).getIndex()]) {
                    distance[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }
    
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    // 노드의 개수, 간선의 개수 입력 받기
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    // 시작 노드 번호 입력 받기
	    start = Integer.parseInt(br.readLine());
	    
	    // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }
	    
	    // 모든 간선 정보를 입력 받기
	    for(int i = 0; i < M; i++) {
	        st = new StringTokenizer(br.readLine());
	        int node = Integer.parseInt(st.nextToken());
	        int index = Integer.parseInt(st.nextToken());
	        int distance = Integer.parseInt(st.nextToken());
	        // node에서 index번 노드로 가는 비용이 distance라는 의미
	        graph.get(node).add(new Node(index, distance));
	    }
	    
	    // 최단 거리 테이블을 모두 무한으로 초기화
	    Arrays.fill(distance, INF);
	    
	    
	    // 다익스트라 알고리즘을 수행
	    dijkstra(start);
	    
	    // 모든 노드로 가기 위한 최단 거리를 출력
	    for(int i = 1; i <= N; i++) {
	        // 도달할 수 없는 경우, 무한(INFINITY)라고 출력
	        if(distance[i] == INF) bw.write("INFINITY\n");
	        // 도달할 수 있는 경우 거리를 출력
	        else bw.write(distance[i] + "\n");
	    }
	    
	    bw.close();
	}
}