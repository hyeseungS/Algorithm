import java.util.*;
import java.io.*;

class Solution
{
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> neighbor;

    // DFS 함수 정의
    public static void dfs(int x) {
        // 현재 노드를 방문 처리
        visited[x] = true;
        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for(int y : neighbor.get(x)) {
            if(!visited[y]) {
            	dfs(y);
            }
        }
    }
    
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            
			st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            visited = new boolean[N + 1];
            neighbor = new ArrayList<ArrayList<Integer>>();
            int ans = 0;
            
            // 그래프 초기화
        	for (int i = 0; i <= N; i++) {
            	neighbor.add(new ArrayList<Integer>());
        	}
            
            for(int i = 0; i < M; i++) {
             	st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                neighbor.get(a).add(b);
                neighbor.get(b).add(a);
            }
            
            for(int i = 1; i <= N; i++) {
                if(!visited[i]) {
                    dfs(i);
                	ans++;
                }
            }
			
            bw.write("#" + test_case + " " + ans + "\n");
		}
        
        bw.close();
	}
}