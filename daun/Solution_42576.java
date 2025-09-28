package daun;

import java.util.HashMap;

class Solution_42576 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        // 참가자 이름 개수 추가
        for(String player : participant){
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        // 완주자 이름 개수 제거
        for(String player : completion){
            map.put(player, map.get(player) - 1);
        }

        // 값이 1인 선수가 완주하지 못한 선수
        for(String key : map.keySet()){
            if(map.get(key) != 0){
                return key;
            }
        }
        return "";
    }
}
