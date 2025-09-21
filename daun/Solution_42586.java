package daun;

import java.util.*;

class Solution_42586 {
    public int[] solution(int[] progresses, int[] speeds) {

        // 일수를 계산해 큐에 담기
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int days = (int)Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            q.add(days);
        }

        // 큐에서 앞에서 꺼내면서 계산
        List<Integer> batches = new ArrayList<>();
        int pivot = q.poll(); // 가장 늦게 끝나는 날짜 (현재 배치 기준일)
        int count = 1; // 현재 포함된 작업 수

        while (!q.isEmpty()) {
            int cur = q.poll(); // 다음 작업의 소요 일수
            if (cur <= pivot) {
                count++; // 같은 배치에 포함
            } else {
                batches.add(count);
                pivot = cur; // 새 배치 기준일 갱신
                count = 1;   // 새 배치 개수 초기화
            }
        }
        batches.add(count);

        // list -> int[]
        int[] answer = new int[batches.size()];
        for (int i = 0; i < batches.size(); i++) {
            answer[i] = batches.get(i);
        }
        return answer;
    }
}
