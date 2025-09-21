package daun;

import java.util.*;

public class Solution_12906 {
    public int[] solution(int []arr) {
        // 입력 배열이 null이거나 길이가 0이면 바로 빈 배열 반환
        if(arr == null || arr.length == 0) return new int[0];

        // 최대 arr 길이만큼 저장 공간
        int[] buf = new int[arr.length];

        // 현재까지 넣은 결과 개수 카운트
        int count = 0;

        // 첫 값은 비교 대상이 없으므로 그냥 집어넣기
        buf[count++] = arr[0];

        // 배열의 직전 값과 다르면 buf에 추가
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != buf[count - 1]){
                buf[count++] = arr[i];
            }
        }

        // buf는 항상 arr.length크기라 남는 공간이 있어
        // Arrays.copyOf로 실제 크기 만큼 자름 (가변리스트)
        return Arrays.copyOf(buf, count);
    }
}
