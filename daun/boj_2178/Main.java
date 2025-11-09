package daun.boj_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M; // 미로의 행, 열
    static int[][] map; // 미로 정보 (1은 이동 0은 벽)
    static boolean[][] visited; // 방문한 칸인지

    // 상하좌우로 이동하기 위한 배열 생성
    static int[] dx = {-1, 1, 0, 0}; // x 방향 (위:-1, 아래:+1, 왼:0, 오:0)
    static int[] dy = {0, 0, -1, 1}; // y 방향 (위:0, 아래:0, 왼:-1, 오:+1)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        // 미로 만들기
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                // 문자를 숫자로 바꿈
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>(); // 탐색할 칸을 담은 큐
        q.add(new int[]{startX, startY}); // 시작 위치를 큐에 담음
        visited[startX][startY] = true; // 방문 표시

        while (!q.isEmpty()) { // 큐가 빌 때까지
            int[] now = q.poll(); // 큐에서 하나 꺼내기
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; // 이동한 새 x좌표
                int ny = y + dy[i]; // 이동한 새 y좌표

                // 미로 범위를 벗어나면 건너뜀
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                // 벽이거나 이미 방문했으면 건너뜀
                if (map[nx][ny] == 0 || visited[nx][ny]) continue;
                // 이동할 수 있으면
                visited[nx][ny] = true; // 방문 표시
                map[nx][ny] = map[x][y] + 1; // 이전 거리 +1
                q.add(new int[]{nx, ny}); // 다음 탐색할 칸으로 추가
            }
        }
        // 가장 먼저 도착한 경로가 최단거리
        return map[N - 1][M - 1];
    }
}
