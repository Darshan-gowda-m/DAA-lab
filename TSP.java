public class TSP {
    static final int INF = Integer.MAX_VALUE; // Infinite distance to represent unreachable cities
    
    // Function to find the minimum cost of visiting all cities
    public static int tsp(int[][] dist, int n) {
        // DP table where dp[mask][i] represents the minimum cost of visiting all cities in 'mask' and ending at city 'i'
        int[][] dp = new int[1 << n][n];
        
        // Initialize dp array with infinity
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        
        // Base case: starting city is 0 and the cost of starting at city 0 is 0
        dp[1][0] = 0;  // Only city 0 is visited (represented by the mask 1)
        
        // Iterate over all subsets of cities (from 1 to 2^n - 1)
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) != 0) {  // If city 'u' is included in the subset 'mask'
                    // Try to extend the tour to city 'v'
                    for (int v = 0; v < n; v++) {
                        if ((mask & (1 << v)) == 0) {  // If city 'v' is not yet visited
                            dp[mask | (1 << v)][v] = Math.min(dp[mask | (1 << v)][v], dp[mask][u] + dist[u][v]);
                        }
                    }
                }
            }
        }
        
        // Find the minimum cost to visit all cities and return to the starting city (0)
        int minCost = INF;
        for (int i = 1; i < n; i++) {
            minCost = Math.min(minCost, dp[(1 << n) - 1][i] + dist[i][0]);
        }
        
        return minCost;
    }
    
    public static void main(String[] args) {
        // Example input: distance matrix
        int[][] dist = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        
        int n = dist.length;  // Number of cities
        
        // Calculate the minimum cost of visiting all cities
        int result = tsp(dist, n);
        
        // Output the result
        System.out.println("Minimum cost to visit all cities: " + result);
    }
}
