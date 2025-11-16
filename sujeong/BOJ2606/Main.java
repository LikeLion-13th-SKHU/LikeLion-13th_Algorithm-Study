// 바이러스

package BOJ2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] network;
    static boolean[] visited; // 방문 여부
    static int N; // 컴퓨터의 수
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());    // 연결된 쌍의 수

        // 0번 노드는 사용하지 않기 때문에 N + 1
        network = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 연결 정보를 인접 행렬에 표시
            network[u][v] = 1;
            network[v][u] = 1;
        }

        // 1번 컴퓨터부터 DFS 탐색 시작
        DFS(1);

        // 1번 컴퓨터 빼고 출력
        System.out.println(count - 1);
    }

    public static void DFS(int node) {
        visited[node] = true;   // 현재 노드를 방문 처리
        count++;

        // 현재 노드와 연결된 모든 노드를 순회
        for (int i = 1; i <= N; i++) {
            if (network[node][i] == 1 && !visited[i]) {
                DFS(i);    // 연결된 노드로 이동하여 재귀 호출
            }
        }
    }
}