import java.util.*;
import java.io.*;

class Main {
	
	// 위상 정렬 함수
	public static int[] topologySort(int N, int[] indegree, int[] hour, ArrayList<ArrayList<Integer>> graph) {
		int[] result = new int[N + 1]; // 알고리즘 수행 결과를 담을 배열
		Queue<Integer> q = new LinkedList<>(); // 큐 라이브러리 사용
		
		// 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
		for(int i = 1; i <= N; i++) {
			result[i] = hour[i];
			if(indegree[i] == 0) q.offer(i);
		}
		
		// 큐가 빌 때까지 반복
		while(!q.isEmpty()) {
			// 큐에서 원소 꺼내기
			int now = q.poll();
			// 해당 원소와 연결된 노드들의 진입차수 1 빼기
			for(int i = 0; i < graph.get(now).size(); i++) {
				indegree[graph.get(now).get(i)]--;
				result[graph.get(now).get(i)] = Math.max(result[now] + hour[graph.get(now).get(i)], result[graph.get(now).get(i)]);
				// 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
				if(indegree[graph.get(now).get(i)] == 0) {
					q.offer(graph.get(now).get(i));
				}
			}
		}
		
		return result;
	}
    
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    // 노드의 개수(N)
	    int N = Integer.parseInt(br.readLine());
	    // 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
	    ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	    // 모든 노드에 대한 진입차수는 0으로 초기화
	    int[] indegree = new int[N + 1];
	    // 각 강의 시간을 0으로 초기화
	    int[] hour = new int[N + 1];
	    
	    // 그래프 초기화
	    for(int i = 0 ; i <= N; i++) {
	    	graph.add(new ArrayList<Integer>());
	    }
		
	    // 방향 그래프의 모든 간선 정보를 입력받기
	    for(int i = 1; i <= N; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	// 첫 번째 수는 시간 정보를 담고 잇음
	    	int x = Integer.parseInt(st.nextToken());
	    	hour[i] = x;
	    	// 해당 강의를 듣기 위해 먼저 들어야 하는 강의들의 번호 입력
	    	while(true) {
	    		x = Integer.parseInt(st.nextToken());
	    		if(x == -1) break;
	    		indegree[i]++;
	    		graph.get(x).add(i);
	    	}
	    }
	   
	    int[] result = topologySort(N, indegree, hour, graph);
	    
	    // 위상 정렬을 수행한 결과 출력
	    for(int i = 1; i <= N; i++) bw.write(result[i] + "\n");
	    
	    bw.close();
	}
}