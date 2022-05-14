import java.util.*;
class Solution {
    int min = 0;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean visited[] = new boolean[n + 1]; // 방문 여부를 검사할 배열 
        int[] distance = new int[n + 1]; // 1번 노드 사이와의 거리
        LinkedList<Integer>[] adjList = new LinkedList[n + 1];

		for (int i = 0; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

		// 두 정점 사이에 여러 개의 간선이 있을 수 있다.
		// 입력으로 주어지는 간선은 양방향이다.
		for (int i = 0; i < edge.length; i++) {
			adjList[edge[i][0]].add(edge[i][1]);
			adjList[edge[i][1]].add(edge[i][0]);
		}

		for (int i = 1; i <= n; i++) { 
			Collections.sort(adjList[i]); // 방문 순서를 위해 오름차순 정렬 
		}
        
		bfs_list(1, adjList, visited, distance);
        Arrays.sort(distance);
        int max = distance[distance.length-1];
        for(int i = distance.length-1; distance[i] == max; i--)
            answer++;
        
        return answer;
    }
    
    // BFS - 인접리스트 
	public static void bfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited, int[] distance) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[v] = true; 
		queue.add(v);

		while(queue.size() != 0) { // 2~n까지 도착하는 경로 구하기
			v = queue.poll(); 

			Iterator<Integer> iter = adjList[v].listIterator();
			while(iter.hasNext()) { 
				int w = iter.next(); 
				if(!visited[w]) { 
					visited[w] = true; 
                    distance[w] = distance[v] + 1;
					queue.add(w); 
				} 
			}
		}
	}

}