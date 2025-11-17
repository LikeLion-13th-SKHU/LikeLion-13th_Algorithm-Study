// 트리의 부모 찾기

package BOJ11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] parent;
    static int N;

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1); // 노드를 큐에 넣어 방문 처리
        parent[1] = 1; // 루트는 자기 자신을 부모로 설정하거나, 0이 아닌 임의의 값으로 설정하여 방문 처리 역할

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : arr[current]) {
                if (parent[next] == 0) { // 이웃 노드가 아직 방문되지 않았으면
                    parent[next] = current; // 현재 노드를 이웃 노드의 부모로 기록
                    q.offer(next); // 이웃 노드를 큐에 추가하여 다음 탐색 대상으로 예약
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new ArrayList[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 방향이 없으므로 양방향 설정
            arr[u].add(v);
            arr[v].add(u);
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }

        System.out.print(sb.toString());
    }
}