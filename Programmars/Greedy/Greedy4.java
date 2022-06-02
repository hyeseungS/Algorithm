class Solution {
    public int solution(int[] peoples, int limit) {
        List<Integer> list = new ArrayList<>();
        for(int x : peoples) list.add(x);
        Collections.sort(list);

                                          // 꼭 사이즈 지정 필요
        ArrayDeque<Integer> dq = new ArrayDeque<>(50505);
        for(int x : list) dq.add(x);

        int ans = 0;
        while(dq.isEmpty() == false) {
            int weight = dq.pollLast();
            if(dq.isEmpty() == false && weight + dq.peekFirst() <= limit) { dq.pollFirst(); }
            ans++;
        }

        return ans;
    }
}