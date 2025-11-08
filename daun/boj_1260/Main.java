package daun.boj_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        // BFS
        visited = new boolean[N + 1];
        bfs(V);

    }

    static void dfs(int v) {
        visited[v] = true; // v 방문 표시
        System.out.print(v + " "); // 방문 순서 출력
        for (int next : graph[v]) { // v의 이웃들을 작은 번호부터 확인
            if (!visited[next]) { // 아직 미방문이면
                dfs(next); // 그 이웃으로 깊게 들어감
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start); // 시작 정점을 큐에 넣음
        visited[start] = true; // 방문 표시

        while (!q.isEmpty()) { // 큐가 빌 때까지
            int v = q.poll(); // 큐 앞에서 꺼내서 출력
            System.out.print(v + " ");

            for (int next : graph[v]) { // v의 이웃들을 작은 번호부터 확인
                if (!visited[next]) { // 미방문이면
                    visited[next] = true; // 방문 표시
                    q.add(next); // 큐에 넣음
                }
            }
        }
    }
}
