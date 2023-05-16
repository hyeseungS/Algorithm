import java.io.*;
import java.util.StringTokenizer;

class Solution
{
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] fly = new int[n][n];
            int max = 0;
            int dir = 0;
            
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    fly[i][j] = Integer.parseInt(st.nextToken());
            	}
            }
            
            for(int i = 0; i < n - m + 1; i++) {
             	for(int j = 0; j < n - m + 1; j++) {
                    int tmp = 0;
                 	for(int k = 0; k < m; k++) {
                     	   for(int l = 0; l < m; l++) {
                            	tmp += fly[i+k][j+l];   
                           }
                    }
                    if(max < tmp) max =tmp;
                }
            }
            
            bw.write("#" + test_case + " " + max + "\n");
		}
        bw.close();        
	}
}