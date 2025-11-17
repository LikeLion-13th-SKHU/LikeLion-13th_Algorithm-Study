        // 점프왕 쪨리

        package BOJ16173;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

        public class Main {

            static int N;
            static int[][] map;
            static boolean visited = false;

            static void dfs(int r, int c) {
                if (map[r][c] == -1) { // 승리 지점에 도달했을 때
                    visited = true;
                    return;
                }
                if (visited) {
                    return;
                }

                int move = map[r][c];

                if (move == 0) { // 현재 칸의 값이 0이라면
                    return;
                }
    
                // 오른쪽으로 이동
                int next_c = c + move;
                if (next_c < N) { // 게임판 내부이고, 아직 방문하지 않았으면

                    dfs(r, next_c);
                }

                // 아래쪽으로 이동
                int next_r = r + move;
                if (next_r < N) { // 게임판 내부라면

                    dfs(next_r, c);
                }
            }

            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                N = Integer.parseInt(br.readLine());

                map = new int[N][N];
                for (int i = 0; i < N; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < N; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                dfs(0, 0);

                if (visited) {
                    System.out.println("HaruHaru");
                } else {
                    System.out.println("Hing");
                }
            }
        }