import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main1325 {

    static int N, M;
    static ArrayList<Integer>[] graph;

    // BFS로 해킹 가능한 컴퓨터 수를 세는 함수
    static int bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        
        queue.add(startNode);
        visited[startNode] = true;
        
        int count = 0; // 해킹한 컴퓨터 수
        
        // 큐가 비어있을 때까지 반복
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            count++; // 큐에서 꺼낼 때 카운트
            
            // 현재 컴퓨터와 연결된 다음 컴퓨터들 확인
            for (int nextNode : graph[currentNode]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
        return count; // 총 해킹한 수 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[B].add(A);
        }

        int[] hackCounts = new int[N + 1];
        int maxCount = 0;

        // 1번부터 N번까지 모든 컴퓨터에서 BFS 시작
        for (int i = 1; i <= N; i++) {
            hackCounts[i] = bfs(i); // i번 컴퓨터에서 시작한 BFS 저장
            
            if (hackCounts[i] > maxCount) {
                maxCount = hackCounts[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (hackCounts[i] == maxCount) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}

