import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        // numbers String 배열로 변환
        String[] strArray = Arrays.stream(numbers)
                                .mapToObj(String::valueOf)
                                .toArray(String[]::new);
        
        //내림차순 정렬
        Arrays.sort(strArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        // 답이 000이면 오류, 첫번째값이 0이면 0을 리턴
        if (strArray[0].equals("0")) return "0";
        
        //0이 아니면 문자열을 더함
        for(String str: strArray) answer += str;

        return answer;
    }
}