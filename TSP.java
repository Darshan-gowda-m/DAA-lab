import java.util.*;

public class TravelingSalesman {

    private static int[][] dist;  // Distance matrix
    private static int n;         // Number of cities

    // Memoization table, dp[mask][i] is the minimum cost to visit all cities in 'mask' and end at city 'i'
    private static int[][] dp;
    // To store the path (order of cities visited)
    private static int[][] path;

    // TSP using dynamic programming with bitmasking
    public static int tsp(int mask, int pos) {
        // Base case: if all cities have been visited, return the distance to the starting city (0)
        if (mask == (1 << n) - 1) {
            return dist[pos][0]; // Return to the starting city
        }

        if (dp[mask][pos] != -1) {
            return dp[mask][pos]; // Return memoized result if already computed
        }

        int ans = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) { // If city is not visited yet
                int newAns = dist[pos][city] + tsp(mask | (1 << city), city);
                if (newAns < ans) {
                    ans = newAns;
                    path[mask][pos] = city; // Store the path (next city to visit)
                }
            }
        }

        return dp[mask][pos] = ans; // Memoize the result
    }

    // Print the cities visited in the optimal order
    public static void printPath() {
        int mask = 1;  // Start at city 0
        int lastCity = 0;

        System.out.print("Optimal path: ");
        for (int i = 0; i < n; i++) {
            System.out.print(lastCity + " -> ");
            int nextCity = path[mask][lastCity];
            mask |= (1 << nextCity);  // Mark the next city as visited
            lastCity = nextCity;
        }
        System.out.println("0"); // Return to the starting city
    }

    public static void main(String[] args) {
        // Example distance matrix (symmetric matrix)
        dist = new int[][]{
            {0, 10, 15, 20, 25},
            {10, 0, 35, 25, 30},
            {15, 35, 0, 30, 5},
            {20, 25, 30, 0, 15},
            {25, 30, 5, 15, 0}
        };

        n = dist.length;  // Number of cities

        // Initialize dp and path arrays
        dp = new int[1 << n][n];
        path = new int[1 << n][n];

        // Fill dp array with -1 (indicating unvisited states)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Find the minimum cost of visiting all cities starting from city 0
        int minCost = tsp(1, 0);  // Start with city 0 visited (mask = 1) and at city 0
        System.out.println("Minimum cost: " + minCost);

        // Print the optimal path
        printPath();
    }
}
