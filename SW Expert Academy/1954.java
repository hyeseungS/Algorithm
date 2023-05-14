import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int[] dr = { 0, 1, 0, -1 }; // 우하좌상 순서
	static int[] dc = { 1, 0, -1, 0 };
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int[][] snail = new int[n][n];
            int dir = 0; 
			int x = 0, y = 0;
            for(int i = 1; i <= n * n; i++) {
			// x값 1 증가
            // y값 1 증가
            // x값 1 감소
            // y값 1 감소
            // x값 1 증가
                snail[x][y] = i;
				if (x + dr[dir] >= n || x + dr[dir] < 0 || y + dc[dir] >= n || y + dc[dir] < 0
						|| snail[x + dr[dir]][y + dc[dir]] != 0) {
					// 배열을 벗어나는지 //그 자리에 숫자 있는지 확인
					dir = (dir + 1) % 4; // 방향전환
				}
				x += dr[dir];
				y += dc[dir];
            }
            System.out.println("#" + test_case);
			for (int i = 0; i < n; i++) {
				for (int s : snail[i])
					System.out.print(s + " ");
				System.out.println();
			}
		}
	}
}