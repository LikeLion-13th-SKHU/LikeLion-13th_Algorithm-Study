import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class main1012 {

    static int M, N, K;
    static int[][] field;
    static boolean[][] visited;
    
    // 상하좌우 이동을 위한 배열
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 (열)
            N = Integer.parseInt(st.nextToken()); // 세로 (행)
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            field = new int[N][M];
            visited = new boolean[N][M];
            
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); // 열
                int Y = Integer.parseInt(st.nextToken()); // 행
                field[Y][X] = 1;
            }

            int wormCount = 0; // 필요한 지렁이 수
            
            // 밭 전체 스캔
            for (int i = 0; i < N; i++) { // 행 (Y)
                for (int j = 0; j < M; j++) { // 열 (X)
                    // 배추가 있고, 아직 방문하지 않았다면
                    if (field[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j); // 연결된 배추 그룹 탐색
                        wormCount++; // 새 그룹 발견, 지렁이 +1
                    }
                }
            }
            sb.append(wormCount).append('\n');
        }
        System.out.print(sb.toString());
    }

    public static void bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 1. 밭 경계 체크
                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    // 2. 배추가 있고, 방문하지 않았다면
                    if (field[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}