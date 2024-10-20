package Darshan;
import java.util.*;
public class warshall {
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter number of vertices");
	int n=sc.nextInt();
	int [][] a=new int[n][n];
	System.out.println("enetr the adjacency matrix");
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			a[i][j]=sc.nextInt();
	System.out.println("the transistive closure is");
	for(int k=0;k<n;k++)
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j]=a[i][j]|(a[i][k]&a[k][j]);
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			System.out.print(a[i][j]+" ");
			
			
		}
		System.out.println();
		sc.close();
	}
	
			
	
}
}
