import java.io.*;
import java.util.StringTokenizer;

class Solution
{
    static String[] board;
    static int max, change;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
            board = st.nextToken().split("");
            change = Integer.parseInt(st.nextToken());
            max = 0;
            
            if(change > board.length) change = board.length;
            
            dfs(0, 0);
            
            bw.write("#" + test_case + " " + max + "\n");
		}
        
        bw.close();
	}
    
    public static void dfs(int start, int count) {
        
        if(count == change) {
            String ans = "";
         	for(String num : board) {
            	ans += num;
            }    
            max = Math.max(max, Integer.parseInt(ans));
            return;
            
        }
    	
        for(int i = start; i < board.length; i++) {
         	for(int j = i + 1;  j < board.length; j++) {
             	String tmp = board[i];
                board[i] = board[j];
                board[j] = tmp;
                
                dfs(i, count + 1);
                
                tmp = board[i];
                board[i] = board[j];
                board[j] = tmp;
            }
        }
    	
    }
}