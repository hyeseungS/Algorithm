import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    
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
    
    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node other) {
        if(this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

class Main {
    
    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int M, N, start;
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 최단 거리 테이블 만들기
    public static int[] distance = new int[100001];
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        while(!pq.isEmpty()) { // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            int now = node.getIndex(); // 현재 노드
            int dist = node.getDistance(); // 현재 노드까지의 비용
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if(distance[now] < dist) continue;
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = distance[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if(cost < distance[graph.get(now).get(i).getIndex()]) {
                    distance[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
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