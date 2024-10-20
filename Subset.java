package Darshan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subset {
    
    public static void findAllSubsets(int[] arr, int n, int sum, List<Integer> subset, List<List<Integer>> result) {
        // Base case: if the sum is zero, add the current subset to the result
        if (sum == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }
        
        // Base case: if we have exhausted the elements or the sum becomes negative
        if (n == 0 || sum < 0) {
            return;
        }

        // Include the current element
        subset.add(arr[n - 1]);
        findAllSubsets(arr, n - 1, sum - arr[n - 1], subset, result);
        
        // Exclude the current element
        subset.remove(subset.size() - 1);
        findAllSubsets(arr, n - 1, sum, subset, result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter the target sum: ");
        int sum = scanner.nextInt();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        long startTime = System.nanoTime();
        findAllSubsets(arr, n, sum, subset, result);
        long endTime = System.nanoTime();

        System.out.println("All subsets contributing to the sum:");
        if (result.isEmpty()) {
            System.out.println("No subset found.");
        } else {
            for (List<Integer> s : result) {
                System.out.println(s);
            }
        }

        double timeElapsed = (endTime - startTime) / 1e6; // convert nanoseconds to milliseconds
        System.out.println("Time elapsed: " + timeElapsed + " milliseconds");
        
        scanner.close();
    }
}
