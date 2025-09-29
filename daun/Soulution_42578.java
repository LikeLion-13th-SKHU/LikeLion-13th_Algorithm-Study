package daun;

import java.util.HashMap;
import java.util.Map;

class Solution_42578 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> count = new HashMap<>();

        // 종류별 개수 세기
        for(String[] c : clothes){
            String type = c[1]; // 의상 종류(2차원 배열에서 꺼냄)
            count.put(type, count.getOrDefault(type, 0) + 1);
        }

        long result = 1;
        for(int i : count.values()){
            result *= (i + 1);
        }

        return (int)(result -1); // 전부 안 입는 경우 제외
    }
}
