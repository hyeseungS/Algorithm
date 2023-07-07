import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int[] score = new int[101];
            int max = 0;
            int n = sc.nextInt();
            
            for(int i = 0; i < 1000; i++) {
             	score[sc.nextInt()]++;   
            }

            for(int i = 0; i <= 100; i++) {
            	if(score[max] <= score[i]) max = i;
            }
            
            System.out.printf("#%d %d\n", n, max);
		}
	}
}