package darshan;
import java.util.*;

public class DFS {
    int vertices;
    LinkedList<Integer>[] adjList;

    public DFS(int vertices) {
        this.vertices = vertices;  // Fix here
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int n = sc.nextInt();
        boolean[] visited = new boolean[n];  // Fix size to n
        DFS g = new DFS(n);
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sc.nextInt() == 1) {
                    g.addEdge(i, j);
                }
            }
        }

        // Perform DFS starting from vertex 0
        g.d(2, visited);
    }

    public void d(int start, boolean[] visited) {
        LinkedList<Integer> stack = new LinkedList<>();
        visited[start] = true;
        stack.push(start);

        while (!stack.isEmpty()) {
            start = stack.pop();  // Fix order: pop after visiting neighbors
            System.out.print(start + "->");

            Iterator<Integer> iterator = adjList[start].listIterator();  // Fix here
            while (iterator.hasNext()) {
                int next = iterator.next();
                if (!visited[next]) {
                    stack.push(next);  // Use push here for stack
                    visited[next] = true;
                }
            }
        }
    }
}
