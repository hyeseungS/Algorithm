class Solution {
    public String solution(String number, int k) {
        StringBuilder a = new StringBuilder(number);
        int i = 0;
        int j = 0;
        int idx;
        int l;

        for (i = 0; i < k; i++) {
            l=a.length();
            idx = l - 1;
            for (j = 0; j < l - 1; j++) {
                if (a.charAt(j) < a.charAt(j + 1)) {
                    idx = j;
                    break;
                }
            }

            a.deleteCharAt(idx);
        }

        return a.toString();
    }
}