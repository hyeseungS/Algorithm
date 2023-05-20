import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int N = 0, value = 0, tmp = 0;
        String s = "";

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			N = Integer.parseInt(br.readLine());
            value = 0;
            for(int i = 0; i < N; i++) {
            	s = br.readLine();
                tmp = i;
                if(i > N / 2) tmp = N - 1 - i;
                for(int j = N / 2 - tmp; j <= N / 2 + tmp; j++) {
                	value += s.charAt(j) - '0';
                }
            }
       
            bw.write("#" + test_case + " " + value + "\n");

		}
        bw.close();
	}
}