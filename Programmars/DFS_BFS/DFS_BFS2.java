import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int n, int[][] computers) {
        boolean[] check = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(check[i] == false) {
                bfs(n, computers, check, i);
                answer++;
            }
        }
        return answer;
    }
    
    void bfs(int n, int[][] computers, boolean[] check, int x) {

        Queue<Integer> q = new LinkedList<>();
    
        check[x] = true;
        q.add(x);
    
        while(!q.isEmpty()) {
    	    int now = q.poll();        
            for(int i = 0; i < n; i++) {
        	    if(computers[now][i] == 1 && !check[i]) { // 연결되어 있고 방문 안한 곳
            	    check[i] = true;
                    q.add(i); // 방문 예정
                }
            }
        }
    }
}