import java.util.*;
class Solution {
    int answer = 0;
    int min = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        boolean[] check = new boolean[words.length];
        dfs(begin, target, words, check, 0);
        return answer;
    }
    
    void dfs(String begin, String target, String[] words, boolean[] check, int x) {

        if(begin.equals(target)) {
            min = Math.min(min, x);
            if(min > words.length)
                min = 0;
            answer = min;
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(check[i]) continue;
            if(onlyOneDifferentChar(begin, words[i])) {
                check[i] = true;
                dfs(words[i], target, words, check, x + 1);
                check[i] = false;
            }
        }
    }
    
    boolean onlyOneDifferentChar(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int differentCnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                differentCnt++;
            }
        }
        return differentCnt == 1;
    }
}