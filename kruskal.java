package Darshan;

import java.util.Scanner;

public class kruskal {
    int parent[] = new int[10];
    int adjacency_matrix[][] = new int[10][10]; 
    int sum = 0; 
    int k = 0; 
    int n;

    int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); 
        }
        return parent[node]; // Return the root parent
    }
    
    void union(int i, int j) {
        parent[i] = j; // Connect node i to node j
    }

    void kruskal_algorithm(int adjacency_matrix[][], int n) {
        int u = 0, v = 0, min;

        // Initialize parent for each vertex
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        while (k < n - 1) {
            min = Integer.MAX_VALUE;

            // Find the minimum edge
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adjacency_matrix[i][j] < min && adjacency_matrix[i][j] != 0) {
                        min = adjacency_matrix[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            int parent_u = find(u);
            int parent_v = find(v);

            // If they are not in the same set, include this edge in the result
            if (parent_u != parent_v) {
                union(parent_u, parent_v);
                System.out.println("(" + u + "," + v + ") = " + adjacency_matrix[u][v]);
                sum += adjacency_matrix[u][v];
                k++;
            }

            // Mark this edge as checked
            adjacency_matrix[u][v] = adjacency_matrix[v][u] = Integer.MAX_VALUE;
        }

        System.out.println("The cost of the minimum spanning tree = " + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        kruskal k = new kruskal(); 

        System.out.println("Enter the number of vertices of the graph:");
        k.n = sc.nextInt(); 

        System.out.println("Enter the weighted adjacency matrix:");
        for (int i = 0; i < k.n; i++) { // Adjusted for zero-based index
            for (int j = 0; j < k.n; j++) {
                k.adjacency_matrix[i][j] = sc.nextInt(); 
            }
        }
        k.kruskal_algorithm(k.adjacency_matrix, k.n);

        sc.close(); 
    }
}
