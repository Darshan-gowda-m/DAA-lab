package Darshan;
import java.util.*;
public class heap {
	public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	Random rand=new Random();
	System.out.println("enter the number of elements");
	int n=sc.nextInt();
	int a[]=new int[n];
	for(int i=0;i<n;i++)
		a[i]=rand.nextInt(100);
	for(int value:a)
		System.out.print(value+" ");
	
	long start=System.nanoTime();
	heapsort(a,0,n-1);
	long end=System.nanoTime();
	long time=end-start;
	System.out.println("time="+time);
	for(int value:a)
		System.out.print(value+" ");
	sc.close();
}
	public static void heapsort(int []a,int low,int high)
	{
		int n=a.length;
		for(int i=n/2-1;i>=0;i--)
		{
			heapif(a,n,i);
		}
		for(int i=n-1;i>=0;i--)
		{
			int temp=a[i];
			a[i]=a[0];
			a[0]=temp;
			heapif(a,i,0);
		}
	}
	public static void heapif(int []a,int n,int i)
	{
		int largest=i;
		int left=2*i+1;
		int right=2*i+2;
		while(left<n&&a[left]>a[largest])
			largest=left;
		while(right<n&&a[right]>a[largest])
			largest=right;
		if(i!=largest)
		{
			int temp=a[i];
			a[i]=a[largest];
			a[largest]=temp;
			heapif(a,n,largest);
		}
	}
}