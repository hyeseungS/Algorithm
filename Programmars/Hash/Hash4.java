import java.util.*;
class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        List<Integer> answer = new ArrayList<>();
        int count = 0;
        
        // 장르별 재생 횟수 저장
        for(int i=0; i<genres.length; i++) {
            if(!hm.containsKey(genres[i]))
                hm.put(genres[i], plays[i]);
            else
                hm.replace(genres[i], hm.get(genres[i])+plays[i]);
         }
        
         // 장르별 재생횟수 오름차순 정렬
         List<Map.Entry<String, Integer>> entryList = new LinkedList<>(hm.entrySet());
         entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int result = o2.getValue() - o1.getValue();
                return result;
            }
         });
        
         // 장르 내 
         for(int i=0; i<entryList.size(); i++) {
             
             // 장르 내 재생 횟수 저장
             HashMap<Integer, Integer> hg = new HashMap<Integer, Integer>();
             count = 0;
             for(int j=0; j < genres.length; j++) {
                 if(entryList.get(i).getKey().equals(genres[j])) {
                     hg.put(j, plays[j]);
                 }
             }
             
             // 장르 내 재생횟수 오름차순 정렬
             List<Map.Entry<Integer, Integer>> genreEntry = new LinkedList<>(hg.entrySet());
             genreEntry.sort(new Comparator<Map.Entry<Integer, Integer>>() {
                 @Override
                 public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                     int result = o2.getValue() - o1.getValue();
                     return result;
                 }
             });
             
             // 장르 내 가장 많이 재생된 노래 최대 두 개씩 저장 
             for(int j=0; j<genreEntry.size(); j++) {
                 if(count == 2) break;
                 answer.add(genreEntry.get(j).getKey());
                 count++;
             }
        }
        return answer;
    }
}