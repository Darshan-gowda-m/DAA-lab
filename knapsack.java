package Darshan;
import java.util.*;
public class knapsack {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number of items");
		int n=sc.nextInt();
	
		int wt[]=new int[n];
		int profit[]=new int[n];
		for(int i=0;i<n;i++) {
			
			System.out.println("enter the weights of item "+i);
			wt[i]=sc.nextInt();
			System.out.println("enter the profits of item "+i);
		profit[i]=sc.nextInt();
		}
		
		
			
		System.out.println("enter knapsack weight");
		int W=sc.nextInt();
		System.out.println("Knapsack weight="+knapsack(W,wt,profit,wt.length));
		sc.close();
		
			
	}
	static int max(int a,int b) {
		return a>b?a:b;
		
	}
	static int knapsack(int W,int[] wt,int[] profit,int n)
	{
		 if(n==0||W==0)
			 return 0;
		 else if(wt[n-1]>W)
			 return knapsack(W,wt,profit,n-1);
		 else
			 return max(knapsack(W,wt,profit,n-1),(profit[n-1]+knapsack(W-wt[n-1],wt,profit,n-1)));
			
		 
		
	}
	

}
