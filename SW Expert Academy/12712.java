import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] dp = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int[][] dx = {{-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[][] area = new int[N][N];
            int ans = 0;
            
            for(int i = 0; i < N; i ++) {
                st = new StringTokenizer(br.readLine());
             	for(int j = 0; j < N; j++) {
                	area[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for(int i = 0; i < N; i ++) {
             	for(int j = 0; j < N; j++) {
                    int sump = 0, sumx = 0;
                    
                    for(int k = 0; k < 4; k++) {
                        for(int l = 1; l < M; l++) {
                            int xp = i + dp[k][0] * l, yp = j + dp[k][1] * l;
                            int xx = i + dx[k][0] * l, yx = j + dx[k][1] * l; 
                            if(xp >= 0 && yp >= 0 && xp < N && yp < N) sump += area[xp][yp];
                            if(xx >= 0 && yx >= 0 && xx < N && yx < N) sumx += area[xx][yx];   
                        }
                    }
                    
                    ans = Math.max(ans, area[i][j] + Math.max(sump, sumx));
                }
            }
            
            bw.write("#" + test_case + " " + ans + "\n");

		}
        
        bw.close();
	}
}