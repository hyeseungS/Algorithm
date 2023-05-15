import java.io.*;

class Solution
{
    
    // y 1만큼 증가, x 1만큼 증가, y 1만큼 감소, x 1만큼 감소 순서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
        
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = Integer.parseInt(br.readLine());
            int[][] snail = new int[n][n];
            int x = 0, y = 0;
            int d = 0;
            
            for(int i = 1; i <= n * n; i++) {
                snail[x][y] = i;
            	if(x + dx[d] < 0 || x + dx[d] >= n || y + dy[d] < 0 || y + dy[d] >= n 
                   || snail[x + dx[d]][y + dy[d]] != 0) {
                	d = (d + 1) % 4; // 방향 전환
                }
               	x += dx[d];
                y += dy[d];
            }
            
            bw.write("#" + test_case + "\n");
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                	bw.write(snail[i][j] + " ");
                }
                bw.write("\n");
            }
		}
        
        bw.close();
	}
}