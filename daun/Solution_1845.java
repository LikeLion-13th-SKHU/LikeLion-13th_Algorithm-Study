package daun;

import java.util.HashMap;

class Solution_1845 {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();

        // 종류별 갯수 세기
        for(int n : nums){
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        int kinds = count.size(); // 서로 다른 포켓몬 종류 수
        int canPick = nums.length / 2; // 가져갈 수 있는 수

        return Math.min(kinds, canPick);
    }
}
