import java.util.*;
class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        String path = "ICN";
        boolean[] check = new boolean[tickets.length];
        // 알파벳 순서 정렬
        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            } 
            else {
                return 0;
            }
        });
        dfs(answer, tickets, check, path, 0);
        return answer;
    }
    
    void dfs(String[] answer, String[][] tickets, boolean[] check, String path, int index) {
        // 모두 다 방문
        if(index == tickets.length) {
            answer[index] = path; 
            return;
        }
        for(int i = 0; i < tickets.length; i++) {
		    if(tickets[i][0].equals(path) && !check[i]) {
                check[i] = true;
                answer[index++] = tickets[i][0];
			    dfs(answer, tickets, check, tickets[i][1], index);
		    }
        }
    }
}