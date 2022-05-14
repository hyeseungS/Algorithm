import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] matrix = new int[n+1][2];
        LinkedList<Integer>[] adjList = new LinkedList[n + 1];
        
        for (int i = 0; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
        
		for (int i = 0; i < results.length; i++) {
			adjList[results[i][0]].add(results[i][1]);
		}
        
        bfs(n, adjList, matrix);
        for(int[] rank : matrix) 
            if(rank[0] + rank[1] == n-1) answer++;
        return answer;
    }

    // BFS - 인접행렬 
	public void bfs(int n, LinkedList<Integer>[] adjList, int[][] matrix) {
        for(int i = 1; i <= n ; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n+1];
            
            visited[i] = true;
            queue.offer(i);
            
            while(!queue.isEmpty()) {
		        int winner = queue.poll();
                
                for(int loser : adjList[winner]) {
                    if(visited[loser]) continue;
                    visited[loser] = true;
                    queue.offer(loser);
                    matrix[i][0]++;
                    matrix[loser][1]++;
                }
            
	        }
        }
    }
}