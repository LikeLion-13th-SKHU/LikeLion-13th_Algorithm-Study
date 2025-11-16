package swea1226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 10;

        for (int t = 0; t < n; t++) {
            int num = Integer.parseInt(br.readLine());
            int[][] maze = new int[16][16];
            int sx = 0, sy = 0;

            for (int i = 0; i < 16; i++) {
                String line = br.readLine();
                for (int j = 0; j < 16; j++) {
                    maze[i][j] = line.charAt(j) - '0';
                    if (maze[i][j] == 2) {
                        sx = i;
                        sy = j;
                    }
                }
            }
            int result = bfs(maze, sx, sy);
            System.out.printf("#%d %d\n", num, result);
        }
    }

    public static int bfs(int[][] maze, int sx, int sy) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[16][16];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= 16 || ny >= 16) continue;
                if (visited[nx][ny]) continue;
                if (maze[nx][ny] == 1) continue;

                if (maze[nx][ny] == 3) return 1;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        return 0;
    }
}
