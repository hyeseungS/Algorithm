import java.util.*;
import java.io.*;

class Solution
{
    // 90도씩 회전
    public static int[][] rotate(int[][] matrix, int N) {
    	int[][] ans = new int[N][N];
        
        // 90도 회전
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
                ans[i][j] = matrix[N - 1 - j][i];
            }
        }
        
        return ans;
    }
    
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];
            for(int i = 0; i < N; i++) {
            	st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                 	matrix[i][j] = Integer.parseInt(st.nextToken());   
                }
            }
            
            bw.write("#" + test_case + "\n"); 
            
            // 90도, 180도, 270도 회전
            int[][] rotate90 = rotate(matrix, N);
            int[][] rotate180 = rotate(rotate90, N);
            int[][] rotate270 = rotate(rotate180, N);
            
            // 출력
            for(int i = 0; i < N; i++) {
           		for(int j = 0; j < N; j++) {
                     bw.write(rotate90[i][j] + "");   
                }
                bw.write(" ");
                for(int j = 0; j < N; j++) {
                     bw.write(rotate180[i][j] + "");   
                }
                bw.write(" ");
                for(int j = 0; j < N; j++) {
                     bw.write(rotate270[i][j] + "");   
                }
                bw.write("\n");
            }           
		}
        
        bw.close();
	}
}