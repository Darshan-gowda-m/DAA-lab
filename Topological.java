package Darshan;

import java.util.*;

public class Topological {
    int V; // Number of vertices
    List<Integer>[] adjList; // Adjacency list

    // Constructor
    Topological(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adjList[i] = new LinkedList<>();
    }

    // Method to add an edge to the graph
    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // A utility method to perform DFS and fill the stack
    void topologicalUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        for (Integer neighbour : adjList[v]) {
            if (!visited[neighbour])
                topologicalUtil(neighbour, visited, stack);
        }
        stack.push(v); // Push current vertex to stack
    }

    // Method to perform topological sort
    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        // Call the recursive helper function for all vertices
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                topologicalUtil(i, visited, stack);
            }
        }

        // Print the contents of the stack in topological order
        System.out.println("Topological Sort:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        Topological g = new Topological(V);

        System.out.println("Enter the adjacency matrix (0 or 1):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (scanner.nextInt() == 1) {
                    g.addEdge(i, j); // Add edge from vertex i to vertex j
                }
            }
        }

        g.topologicalSort(); // Perform topological sort
        scanner.close();
    }
}
