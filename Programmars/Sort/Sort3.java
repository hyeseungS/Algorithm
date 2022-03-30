import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = citations[citations.length-1];
        Arrays.sort(citations);
        
        for(int i = answer; i >= 0; i--) {
            int count = 0;
            for(int j = 0; j < citations.length; j++) {
                if(citations[j] >= answer) count++;
                if(count > answer) break;
            }
            if(count == answer) return answer;
            else answer--;
        }
        
        return answer;
    }
}