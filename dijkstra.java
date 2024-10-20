
package Darshan;
import java.util.Scanner;

public class dijkstra {
    int d[] = new int[10]; 
    int p[] = new int[10]; 
    int visited[] = new int[10]; 

    public void dijk(int[][] a, int s, int n) {
        int u = -1, v, i, j, min;

        
        for (i = 0; i < n; i++) {
            d[i] = Integer.MAX_VALUE; 
            visited[i] = 0; 
            p[i] = -1; 
        }
        d[s] = 0; 

        
        for (i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            u = -1;

            
            for (j = 0; j < n; j++) {
                if (visited[j] == 0 && d[j] < min) {
                    min = d[j];
                    u = j;
                }
            }

            
            if (u == -1) break;

            visited[u] = 1; 

            
            for (v = 0; v < n; v++) {
                if (a[u][v] > 0 && visited[v] == 0 && d[u] + a[u][v] < d[v]) {
                    d[v] = d[u] + a[u][v]; 
                    p[v] = u; 
                }
            }
        }
    }

    
    void path(int v, int s) {
        if (p[v] != -1)
            path(p[v], s); 
        if (v != s)
            System.out.print("->" + v + " ");
    }

    void display(int s, int n) {
        for (int i = 0; i < n; i++) {
            if (i != s) {
                System.out.print(s);
                path(i, s); 
                System.out.print(" = " + d[i]); 
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int a[][] = new int[10][10]; 
        int i, j, n, s;

        System.out.println("Enter the number of vertices:");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); 

        System.out.println("Enter the weighted matrix:");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = sc.nextInt(); 
            }
        }

        System.out.println("Enter the source vertex:");
        s = sc.nextInt(); 

        dijkstra tr = new dijkstra(); 
        tr.dijk(a, s, n); 

        System.out.println("The shortest path from source " + s + " to the remaining vertices are:");
        tr.display(s, n); 

        sc.close(); 
    }
}
