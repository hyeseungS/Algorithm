import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(String number : phone_book) {
            hm.put(number, 1);
        }
        for(String number : phone_book) {
            for(int j=1; j<number.length(); j++) {
                if(hm.containsKey(number.substring(0, j))) {
                    answer = false;
                    break;
                }
            }                   
        }      
        return answer;
    }
}