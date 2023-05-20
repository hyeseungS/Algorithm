import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] matrix = new int[100][100];
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			br.readLine();
            int max = 0;
			for(int i = 0; i < 100; i++) {
                int rowMax = 0;
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++) {
             		matrix[i][j] = Integer.parseInt(st.nextToken());
                    rowMax += matrix[i][j];
                }
                max = Math.max(max, rowMax);
            }
			                       
            for(int i = 0; i < 100; i++) {
                int columnMax = 0; 
                for(int j = 0; j < 100; j++) {
                	columnMax += matrix[j][i];
                }
                max = Math.max(max, columnMax);
            }
            
            int max1 = 0, max2 = 0;
            for(int i = 0; i < 100; i++) {
                max1 += matrix[i][i];
                max2 += matrix[99 - i][99 - i];
            }
            max = Math.max(max, max1);
            max = Math.max(max, max2);
                                         
            bw.write("#" + test_case + " " + max + "\n");
		}
        bw.close();
	}
}