import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int r, c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main1926 {

    static int n, m;
    static int[][] paper;
    static boolean[][] visited;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int bfs(int startR, int startC) {
        Queue<Point> queue = new LinkedList<>();
        
        queue.add(new Point(startR, startC));
        visited[startR][startC] = true;
        
        int area = 1;
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                
                if (paper[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new Point(nr, nc));
                    area++;
                }
            }
        }
        
        return area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int paintingCount = 0;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1 && !visited[i][j]) {
                    paintingCount++;
                    int currentArea = bfs(i, j); 
                    
                    if (currentArea > maxArea) {
                        maxArea = currentArea;
                    }
                }
            }
        }

        System.out.println(paintingCount);
        System.out.println(maxArea);
    }
}[BOJ] 1926 그림 / 골드 1 /  40분