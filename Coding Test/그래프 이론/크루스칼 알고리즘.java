import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
	private int distance;
	private int nodeA;
	private int nodeB;
	
	public Edge(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA  = nodeA;
		this.nodeB = nodeB;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	public int getNodeA() {
		return this.nodeA;
	}
	
	public int getNodeB() {
		return this.nodeB;
	}
	
	// 거리 (비용)가 짧은 것이 높은 우선순위를 가지도록 설정
	@Override
	public int compareTo(Edge other) {
		if(this.distance < other.distance)
			return -1;
		return 1;
	}
}

class Main {
	
	// 특정 원소가 속한 집합을 찾기
	public static int findParent(int[] parent, int x) {
		// 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
		if(parent[x] != x) parent[x] = findParent(parent, parent[x]);
		return parent[x];
	}
	
	// 두 원소가 속한 집합을 합치기
	public static void unionParent(int[] parent, int a, int b) {
		a = findParent(parent, a);
		b = findParent(parent, b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
    
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    // 노드의 개수 (V)와 간선(Union 연산)의 개수(E)
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int V = Integer.parseInt(st.nextToken());
	    int E = Integer.parseInt(st.nextToken());
	    int[] parent = new int[V + 1]; // 부모 테이블 초기화하기
	    // 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
	    ArrayList<Edge> edges = new ArrayList<>();
	    int result = 0;
	    
	    // 부모 테이블 상에서, 부모를 자기 자신으로 초기화
	    for(int i = 1; i <= V; i++) {
	    	parent[i] = i;
	    }
	    
	    // 모든 간선에 대한 정보를 입력 받기
	    for(int i = 0; i < E; i++) {
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int distance = Integer.parseInt(st.nextToken());
	        edges.add(new Edge(distance, a, b));
	    }
	    
	    // 간선을 비용순으로 정렬
        Collections.sort(edges);
        
        // 간선을 하나씩 확인하며
        for(int i = 0; i < edges.size(); i++) {
        	Edge edge = edges.get(i);
        	int a = edge.getNodeA();
        	int b = edge.getNodeB();
        	int distance = edge.getDistance();
        	// 사이클이 발생하지 않는 경우에만 집합에 포함
        	if(findParent(parent, a) != findParent(parent, b)) {
        		unionParent(parent, a, b);
        		result += distance;
        	}
        }
        
	    bw.write(result + "");
	    bw.close();
	}
}