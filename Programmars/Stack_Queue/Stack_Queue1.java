import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap();
        for(String name : participant) {
            if(hm.containsKey(name))
                hm.put(name, hm.get(name)+1);
            else
                hm.put(name, 1);
        }
        for(String name : completion) {
            if(hm.get(name) == 1)
                hm.remove(name);
            else if(hm.get(name) > 1)
                hm.replace(name, hm.get(name)-1);
        }
        for (String name : participant) { 
            if(hm.containsKey(name))
                answer = name;
        }
        return answer;
    }
}