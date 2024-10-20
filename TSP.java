
package Darshan;
import java.util.*;

public class TSP {
    static int n = 4;
    static int MAX = 1000000;
    static int[][] dist = { 
        { 0, 0, 0, 0, 0 }, 
        { 0, 0, 10, 15, 20 }, 
        { 0, 10, 0, 25, 25 }, 
        { 0, 15, 25, 0, 30 }, 
        { 0, 20, 25, 30, 0 }
    };
    static int[][] dp;

    
    static int tsp(int pos, boolean[] visited) {
        
        if (allVisited(visited)) {
            return dist[pos][1]; // Return distance back to city 1
        }

        if (dp[pos][getVisitedIndex(visited)] != 0) {
            return dp[pos][getVisitedIndex(visited)];
        }

        int res = MAX;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) { 
                visited[i] = true;
                res = Math.min(res, dist[pos][i] + tsp(i, visited)); 
                visited[i] = false; 
            }
        }

        return dp[pos][getVisitedIndex(visited)] = res;
    }

        static boolean allVisited(boolean[] visited) {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    static int getVisitedIndex(boolean[] visited) {
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                index |= (1 << i);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        dp = new int[n + 1][1 << (n + 1)]; 

        boolean[] visited = new boolean[n + 1]; 
        visited[1] = true; 

        int ans = tsp(1, visited);
        System.out.println("The cost of the most efficient tour = " + ans);
    }
}
