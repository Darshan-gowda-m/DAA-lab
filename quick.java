package Darshan;
import java.util.*;
public class quick {
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
	qsort(a,0,n-1);
	long end=System.nanoTime();
	long time=end-start;
	System.out.println("time="+time);
	for(int value:a)
		System.out.print(value+" ");
	sc.close();
}
public static void qsort(int[] a,int low,int high)
{
	if(low<high)
	{
		int p=partitionindex(a,low,high);
		qsort(a,low,p-1);
		qsort(a,p+1,high);
	}
}
public static int partitionindex(int[] a,int low,int high)
{
	int pivot=a[high];
	int i=low-1;
	for(int j=low;j<high;j++)
	{
		if(a[j]<=pivot)
		
		{
			i++;
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
	}
	int temp=a[i+1];
	a[i+1]=a[high];
	a[high]=temp;
	return i+1;
	
}

}
