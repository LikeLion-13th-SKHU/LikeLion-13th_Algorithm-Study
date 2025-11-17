import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class main2606 {

    static int computerCount;
    static int connectionCount;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int infectedCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computerCount = Integer.parseInt(br.readLine());
        connectionCount = Integer.parseInt(br.readLine());

        graph = new ArrayList[computerCount + 1];
        visited = new boolean[computerCount + 1];
        for (int i = 1; i <= computerCount; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < connectionCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        bfs(1);

        System.out.println(infectedCount);
    }

    public static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int neighbor : graph[currentNode]) {
                
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    infectedCount++;
                }
            }
        }
    }
}