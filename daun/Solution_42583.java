package daun;

import java.util.*;

class Solution_42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Deque<Integer> q = new ArrayDeque<>();
        int time = 0; // 경과 시간
        int curWeight = 0; // 현재 다리 위 무게
        int index = 0; // 다음에 올라갈 대기 트럭 인덱스

        // 처음엔 다리가 비어있으므로 0으로 시작
        // 이걸 해야 큐와 다리 길이가 동일해서 poll과 offer를 하면서 슬라이딩 가능
        for(int j = 0; j < bridge_length; j++){
            q.offer(0);
        }

        while(index < truck_weights.length){
            time++;

            // 한 칸 전진
            curWeight -= q.poll();

            // 새 트럭을 올리거나 0 유지
            if(curWeight + truck_weights[index] <= weight){
                q.offer(truck_weights[index]);
                curWeight += truck_weights[index];
                index++;
            } else {
                q.offer(0);
            }
        }

        // 마지막 트럭이 나가는 데 다리 길이만큼 걸림
        return time + bridge_length;
    }
}
