package Darshan;

import java.util.*;

public class Knapsack {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of items:");
        int n = sc.nextInt();
        
        int[] wt = new int[n];
        int[] profit = new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the weight of item " + i);
            wt[i] = sc.nextInt();
            System.out.println("Enter the profit of item " + i);
            profit[i] = sc.nextInt();
        }
        
        System.out.println("Enter the knapsack weight:");
        int W = sc.nextInt();
        
        // Call the knapsack method to find the maximum profit
        int[] selectedItems = knapsack(W, wt, profit, n);
        
        System.out.println("Knapsack maximum profit = " + selectedItems[0]);
        System.out.println("Even-indexed items selected:");
        for (int i = 1; i < selectedItems.length; i++) {
            if (selectedItems[i] == 1) {
                System.out.println("Item " + (i - 1) + " (Weight: " + wt[i - 1] + ", Profit: " + profit[i - 1] + ")");
            }
        }
        
        sc.close();
    }
    
    static int max(int a, int b) {
        return a > b ? a : b;
    }
    
    static int[] knapsack(int W, int[] wt, int[] profit, int n) {
        // Create DP table where dp[i][j] is the maximum profit for the first i items and j weight
        int[][] dp = new int[n + 1][W + 1];
        
        // Build the dp table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w) {
                    dp[i][w] = max(dp[i - 1][w], profit[i - 1] + dp[i - 1][w - wt[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        // Array to track the selected items
        int[] selectedItems = new int[n + 1];
        int w = W;
        
        // Track the selected items based on the dp table
        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) { // If the item was included
                selectedItems[i] = 1; // Mark this item as selected
                w -= wt[i - 1]; // Reduce the weight by the weight of the selected item
            } else {
                selectedItems[i] = 0; // If the item was not selected, mark it as not selected
            }
        }
        
        // The first element in the array will hold the maximum profit
        selectedItems[0] = dp[n][W];
        
        return selectedItems;
    }
}
