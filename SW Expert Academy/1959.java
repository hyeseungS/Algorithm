import java.util.*;
import java.io.*;

class Solution
{
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
            int[] A = new int[N];
            int[] B = new int[M];
            int ans = 0;
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
            	A[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
            	B[i] = Integer.parseInt(st.nextToken());
            }
			
            if(N < M) {
                for(int i = 0; i <= M - N; i++) {
                	int sum = 0;
                	for(int j = 0; j < N; j++) {
                    	sum += A[j] * B[i + j];
                	}
                	ans = Math.max(ans, sum);
            	}
            }
            
            else if(N > M) {
                for(int i = 0; i <= N - M; i++) {
                	int sum = 0;
                	for(int j = 0; j < M; j++) {
                    	sum += A[i + j] * B[j];
                	}
                	ans = Math.max(ans, sum);
            	}
            }
            
            else {
                int sum = 0;
                for(int i = 0; i < N; i++) {
                    sum += A[i] * B[i];
                }
                ans = Math.max(ans, sum);
            }
                       
            bw.write("#" + test_case + " " + ans + "\n");
		}
        
        bw.close();
	}
}