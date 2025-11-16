// 유기농 배추

package BOJ1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M; // 배추밭 가로 길이
    static int N; // 배추밭 세로 길이
    static int[][] field; // 배추밭
    static boolean[][] visited; // 방문 여부 체크

    // 상하좌우 탐색을 위한 배열
    static int[] dy = {1, -1, 0, 0}; // 상, 하 방향 이동
    static int[] dx = {0, 0, 1, -1}; // 좌, 우 방향 이동

    public static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int next_r = r + dy[i]; // 다음 행
            int next_c = c + dx[i]; // 다음 열

            if (next_r >= 0 && next_r < N && next_c >= 0 && next_c < M) {

                // 다음 위치에 배추가 있고 아직 방문하지 않았으면
                if (field[next_r][next_c] == 1 && !visited[next_r][next_c]) {
                    dfs(next_r, next_c); // 재귀 호출
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수

            // 배추밭 및 방문 배열 초기화
            field = new int[N][M];
            visited = new boolean[N][M];
            int count = 0; // 필요한 지렁이 수

            // K개의 배추 위치 입력 받기
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 가로 좌표
                int y = Integer.parseInt(st.nextToken()); // 세로 좌표

                field[y][x] = 1; // 배추가 심겨진 위치 표시
            }

            // 모든 밭을 순회하며 배추 그룹 찾기
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {

                    if (field[r][c] == 1 && !visited[r][c]) { // 배추가 있고 아직 탐색하지 않은 곳이 있으면
                        dfs(r, c); // 연결된 모든 배추를 방문 처리
                        count++; // 덩어리 하나를 발견했으니 count 1 증가
                    }
                }
            }

            System.out.println(count);
        }
    }
}
