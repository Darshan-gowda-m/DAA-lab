package Darshan;
import java.util.*;
public class MergeSort {
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
	mergesort(a,0,n-1);
	long end=System.nanoTime();
	long time=end-start;
	System.out.println("time="+time);
	for(int value:a)
		System.out.print(value+" ");
	sc.close();
}
public static void mergesort(int[] a,int low,int high)
{
	if(low<high)
	{
		int mid=(low+high)/2;
		mergesort(a,low,mid);
		mergesort(a,mid+1,high);
		merge(a,low,mid,high);
	}
}
public static void merge(int[] a,int low,int mid,int high)
{
	int n1=mid-low+1;
	int n2=high-mid;
	int left[]=new int[n1];
	int right[]=new int[n2];
	int i=0,j=0,k=low;
	for(i=0;i<n1;i++)
		left[i]=a[low+i];
	for(i=0;i<n2;i++)
		right[i]=a[mid+i+1];
	i=0;
	while(i<n1&&j<n2)
	{
		if(left[i]<right[j])
		{
			a[k++]=left[i++];
		}
		else
			a[k++]=right[j++];
	}
	while(i<n1)
		a[k++]=left[i++];
	while(j<n2)
		a[k++]=right[j++];
		
	}

}
