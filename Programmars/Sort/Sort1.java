import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            int k = 0;

            int [] temp = new int[commands[i][1] - commands[i][0] + 1];

            for(int j = commands[i][0] -1; j <= commands[i][1] -1 ; ++j){
                temp[k] = array[j];
                k++;
            }

            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] -1];
        }
        return answer;
    }
}