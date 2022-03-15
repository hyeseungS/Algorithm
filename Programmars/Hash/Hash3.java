import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i = 0; i < clothes.length; i++) {
            if(hm.containsKey(clothes[i][1]))
                hm.replace(clothes[i][1], hm.get(clothes[i][1])+1);
            else
                hm.put(clothes[i][1], 1);
        }
        for(Map.Entry<String, Integer> entry : hm.entrySet()) {
            answer*=entry.getValue()+1;
        }
        return answer-1;
    }
}