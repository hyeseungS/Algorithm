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
			int[][] puzzle = new int[9][9];
            int ans = 1;
            
            // 스도쿠 퍼즐 저장
            for(int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
             	for(int j = 0; j < 9; j++) {
                 	   puzzle[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            // 행 & 열 테스트
            for(int i = 0; i < 9; i++) {
             	int[] column = new int[9];
                int[] row = new int[9];
                
                for(int j = 0; j < 9; j++) {
                	column[puzzle[i][j] - 1]++;
                    row[puzzle[j][i] - 1]++;
                }
                
                for(int j = 0; j < 9; j++) {
                 	if(column[j] == 0 || row[j] == 0) {
                        ans = 0;
                        break;
                    }
                }
                
                if(ans == 0) break;
            }
            
            // 박스 테스트
            for(int i = 0; i < 9; i += 3) {
             	for(int j = 0; j < 9; j += 3) {
                	int[] box = new int[9];
                    for(int k = 0; k < 3; k++) {
                     	for(int l = 0; l < 3; l++) {
                         	box[puzzle[k][l] - 1]++;   
                        }
                    }
                 	for(int k = 0; k < 9; k++) {
                     	if(box[k] == 0) {
                         	ans = 0;
                            break;
                        }
                    }
                }
                if(ans == 0) break;
            }
			
            bw.write("#" + test_case + " " + ans + "\n");
		}
        
        bw.close();
	}
}