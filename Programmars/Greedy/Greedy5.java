import java.util.*;
class Solution {
    public static class Island implements Comparable<Island>{
        int from ;
        int to;
        int weight;
        
        public Island(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Island o){
            return this.weight - o.weight;
        }        
        
    }
    
    static int[] parent;
    static PriorityQueue<Island> pq ;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for( int i=0; i<n; i++){
            parent[i] = i;
        }
        pq = new PriorityQueue<>();
        
        for( int i=0; i<costs.length; i++){
            pq.add(new Island(costs[i][0], costs[i][1], costs[i][2] ));
        }
        
        // 크루스칼 algo
        int V =0 ; // 간선 수 
        while( !pq.isEmpty()){
            Island cur = pq.poll();
            int x = cur.from;
            int y = cur.to;
            int weight = cur.weight;
            
            // from - to 연결 안되어있다면 연결 -> answer ++ 
            if ( union(x,y) ){
                answer += weight;
                V ++;
            }
            if( V == n-1) break;
            
        }
        
        return answer;
    }
    private static boolean union(int x, int y){
        int px = getParent(x);
        int py = getParent(y);
        
        if ( px == py ) return false;
        else{
            // 작은 곳에 붙이기
            if( px < py ) {
                parent[py] = px;
            }
            else {
                parent[px] = py;
            }
            return true;
        }
        
    }
    private static int getParent(int x){
        if( parent[x] == x ) return x;
        else return parent[x] = getParent( parent[x] );
    }
}