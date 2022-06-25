import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int matrix[][] = new int[n][m];
        
        // 물에 잠긴 곳
        for (int[] puddle : puddles) {
            matrix[puddle[1]-1][puddle[0]-1] = -1;
        }
        
        // 집 (1, 1)
        matrix[0][0] = 1;
        
        // 최단 경로
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] != -1) {
                    // 물에 잠긴 곳이 아니면 아래로 이동 가능
                    if (i >= 1 && matrix[i - 1][j] != -1) {
                        matrix[i][j] += matrix[i - 1][j];
                    }
                    
                    // 물에 잠긴 곳이 아니면 오른쪽으로 이동 가능
                    if (j >= 1 && matrix[i][j - 1] != -1) {
                        matrix[i][j] += matrix[i][j - 1];
                    }
                    
                    // 최단경로의 개수 / 1000000007
                    if (matrix[i][j] > 1000000007) {
                        matrix[i][j] %= 1000000007;
                    }
                }
            }
        }
        return matrix[n-1][m-1];
    }
}