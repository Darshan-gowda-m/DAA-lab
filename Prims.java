
package Darshan;
import java.util.*;
public class Prims {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n,i,j,s,k=0,min=0,sum=0,u=0,v=0,flag=0;
			int [][] wt=new int[10][10];
			int[] sol = new int[10];
			System.out.println("Enter the number of vertices");
			n=sc.nextInt();
			System.out.println("Enter the weighted matrix:");
			for(i=0;i<n;i++)
				for(j=0;j<n;j++)
					wt[i][j]=sc.nextInt();
			for(i=0;i<n;i++)
				sol[i]=0;
			System.out.println("Enter the source vertex");
			s=sc.nextInt();
			sol[s]=1;
			k=1;
			while(k<=n-1) {
				min=99;
				for(i=0;i<n;i++) {
					for(j=0;j<n;j++) {
						if(sol[i]==1&&sol[j]==0)
						{
							if(i!=j&&min>wt[i][j])
							{
								min=wt[i][j];
								u=i;
								v=j;
							}
						}
					}
				}
				sol[v]=1;
				sum=sum+min;
				k++;
				System.out.println(u+"->"+v+"="+min);
			}
			for(i=0;i<n;i++)
				if(sol[i]==0) 
				flag=1;
				if(flag==1)
				System.out.println("No spanning tree");
				else 
				System.out.println("The cost of minimum spanning tree is"+sum); sc.close();

			
		}
	}
