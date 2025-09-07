package prgm문자열내마음대로;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] result = sol.solution(new String[]{"sun", "bed", "car"}, 1);

        System.out.println(Arrays.toString(result));
    }

    static class Solution {
        public String[] solution(String[] strings, int n) {
            Arrays.sort(strings, (s1, s2) -> {
                if (s1.charAt(n) == s2.charAt(n)) {
                    return s1.compareTo(s2);
                } else {
                    return Character.compare(s1.charAt(n), s2.charAt(n));
                }
            });

            return strings;
        }
    }
}
