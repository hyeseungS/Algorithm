import java.io.*;
import java.util.*;

class Point {
 	int x, y, cnt;
    public Point(int x, int y, int cnt) {
     	this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

class Solution
{
    public static int ans, N;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static int[][] pool;
    public static boolean[][] visited;
    public static Point startPoint, endPoint;
    
    public static boolean bfs() {
        // 큐(queue) 구현 위해 사용
	    Queue<Point> q = new LinkedList<>();
	    q.add(startPoint);
        visited[startPoint.x][startPoint.y] = true;
	    
	    // 큐가 빌 때까지 반복
	    while(!q.isEmpty()) {
	        Point p = q.poll();
            
            // 도착. 결과 출력
            if(p.x == endPoint.x && p.y == endPoint.y) {
            	ans = p.cnt;
            	return true;   
            }
	                           
	        // 현재 노드에서 네 방향으로의 노드 확인
	        for(int i = 0; i < 4; i++) {
	            int tmpx = p.x + dx[i];
	            int tmpy = p.y + dy[i];
                
	            // 미로 찾기 공간을 벗어난 경우 무시
	            if(tmpx < 0 || tmpx >= N || tmpy < 0 || tmpy >= N) continue;
                // 방문 OR 1인경우 무시
                if(visited[tmpx][tmpy] || pool[tmpx][tmpy] == 1) continue;                
                // 소용돌이인 경우
                if(pool[tmpx][tmpy] == 2) {
                    if(p.cnt % 3 != 2) {
                        visited[p.x][p.y] = true;
                        q.add(new Point(p.x, p.y, p.cnt + 1));
                    }
                    else {
                        visited[tmpx][tmpy] = true;
                        q.add(new Point(tmpx, tmpy, p.cnt + 1));
                    }
                }
                else {
                	visited[tmpx][tmpy] = true;
                	q.add(new Point(tmpx, tmpy, p.cnt + 1));
                }
	        }
	    }
        return false;
    }
    
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
            pool = new int[N][N];
            visited = new boolean[N][N];
            ans = 0;
            
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
             	for(int j = 0; j < N; j++) {
                	pool[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            startPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);  
            
            st = new StringTokenizer(br.readLine());
            endPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);            
            
            ans = bfs() ? ans : -1;
            bw.write("#" + test_case + " " + ans + "\n");
		}
        
        bw.close();
	}
}