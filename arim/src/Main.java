import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 좌표(row, col)를 저장하기 위한 간단한 클래스
class Point {
    int r, c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {

    static int n, m;
    static int[][] paper; // 도화지 (0 또는 1)
    static boolean[][] visited; // 방문(물감) 여부 체크

    // 상, 하, 좌, 우 네 방향을 쉽게 탐색하기 위한 배열
    static int[] dr = {-1, 1, 0, 0}; // 행(row) 이동
    static int[] dc = {0, 0, -1, 1}; // 열(col) 이동

    /**
     * BFS 함수 (물감 채우기)
     * @param startR : 시작점의 행
     * @param startC : 시작점의 열
     * @return : 발견한 그림의 넓이
     */
    static int bfs(int startR, int startC) {
        Queue<Point> queue = new LinkedList<>();
        
        // 1. 시작점(새 그림)을 큐에 넣고 방문 처리
        queue.add(new Point(startR, startC));
        visited[startR][startC] = true;
        
        int area = 1; // 넓이는 1부터 시작
        
        // 2. 큐가 빌 때까지 (물감이 다 번질 때까지) 반복
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            
            // 3. 4방향(상하좌우) 탐색
            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];
                
                // 4. 도화지 범위 체크
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue; // 도화지 밖이면 무시
                }
                
                // 5. 그림(1)이고 아직 방문 안 한 곳인지 체크
                if (paper[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true; // 방문(물감) 처리
                    queue.add(new Point(nr, nc)); // 큐에 추가 (물감 번짐)
                    area++; // 넓이 1 증가
                }
            }
        }
        
        return area; // 이 그림의 총 넓이 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        visited = new boolean[n][m];

        // 도화지 정보 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int paintingCount = 0; // 총 그림 개수
        int maxArea = 0;         // 가장 큰 그림 넓이

        // 1. 도화지 전체 스캔 (0, 0)부터 (n-1, m-1)까지
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                // 2. 그림(1)이고 아직 방문 안 한 곳(새 그림) 발견
                if (paper[i][j] == 1 && !visited[i][j]) {
                    paintingCount++; // 그림 개수 +1
                    
                    // 3. BFS(물감 채우기)로 넓이 계산
                    int currentArea = bfs(i, j); 
                    
                    // 4. 최대 넓이 갱신
                    if (currentArea > maxArea) {
                        maxArea = currentArea;
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(paintingCount);
        System.out.println(maxArea);
    }
}