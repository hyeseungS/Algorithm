import java.util.*;
import java.io.*;

class Solution {
	
	// 위상 정렬 함수
	public static ArrayList<Integer> topologySort(int V, int[] indegree, ArrayList<ArrayList<Integer>> graph) {
		ArrayList<Integer> result = new ArrayList<>(); // 알고리즘 수행 결과를 담을 리스트
        Queue<Integer> q = new LinkedList<>(); // 큐 라이브러리 사용
		
        // 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
        for(int i = 1; i <= V; i++) {
        	if(indegree[i] == 0) 
        		q.offer(i);
        }
        
        // 큐가 빌 때까지 반복
        while(!q.isEmpty()) {
        	// 큐에서 원소 꺼내기
        	int now = q.poll();
        	result.add(now);
        	// 해당 원소와 연결된 노드들의 진입차수에서 1빼기
        	for(int i = 0; i < graph.get(now).size(); i++) {
        		indegree[graph.get(now).get(i)]--;
        		// 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
        		if(indegree[graph.get(now).get(i)] == 0)
        			q.offer(graph.get(now).get(i));
        	}
        }
        
        return result;
	}
    
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	    // 노드의 개수 (V)와 간선(Union 연산)의 개수(E)
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int V = Integer.parseInt(st.nextToken());
	    int E = Integer.parseInt(st.nextToken());
	    // 모든 노드에 대한 진입차수는 0으로 초기화
	    int[] indegree = new int[V + 1];
	    // 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
	    ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	    
	    // 그래프 초기화
	    for(int i = 0; i <= V; i++) {
	    	graph.add(new ArrayList<Integer>());
	    }
	    	    
	    // 방향 그래프의 모든 간선 정보를 입력 받기
	    for(int i = 0; i < E; i++) {
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        graph.get(a).add(b); // 정점 A에서 B로 이동 가능
	        // 진입 차수 1 증가
	        indegree[b] += 1;
	    }
	    
	    ArrayList<Integer> result = topologySort(V, indegree, graph);
	    
	    // 위상 정렬 수행한 결과 출력
	    for(int i = 0;  i < result.size(); i++) {
	    	bw.write(result.get(i) + " ");
	    }
	    
	    bw.close();
	}
}