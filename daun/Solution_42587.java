package daun;

import java.util.*;

class Solution_42587 {
    public int solution(int[] priorities, int location) {

        // 큐에 우선순위와 인덱스를 저장
        Deque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++){
            q.offerLast(new int[]{priorities[i], i});
        }

        int printed = 0; // 지금까지 실행된 프로세스 수
        while(!q.isEmpty()){
            // 큐의 맨 앞 프로세스 꺼내기
            int[] cur = q.pollFirst();
            int p = cur[0];
            int index = cur[1];

            // 지금 꺼낸 프로세스보다 높은 우선순위가 있는지 확인
            boolean hasHigher = false;
            for(int[] e : q){ // 큐 전체 탐색
                if(e[0] > p){ // 더 높은 우선순위가 있으면
                    hasHigher = true;
                    break;
                }
            }
            if(hasHigher){
                // 다시 큐에 뒤로 넣음
                q.offerLast(cur);
            } else {
                printed++;
                if(index == location){
                    return printed;
                }
            }
        }
        return -1;
    }
}
