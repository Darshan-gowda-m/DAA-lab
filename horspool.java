package Darshan;
import java.util.*;
public class horspool {
 static int no=256;
 static int max(int a, int b)
 {
	 return (a>b)?a:b;
 }
 public static void badCharHeuristic(char str[], int n, int badchar[]) {
	 for(int i=0;i<no;i++)
		 badchar[i]=-1;
	 for(int i=0;i<n;i++)
		 badchar[(int)str[i]]=1;
 }
 public static void search(char txt[], char pat[]) {
	 int m=pat.length;
	 int n=txt.length;
	 int[] badchar = new int[no];
	 badCharHeuristic(pat,m,badchar);
	 int s=0;
	 while(s<=(n-m)) {
		 int j=m-1;
		 while(j>=0&&pat[j]==txt[s+j])
			 j--;
		 if(j<0)
		 {
			 System.out.println("Pattern occurs at shift "+(s+1));
			 s+=(s+m<n)?m-badchar[txt[s+m]]:1;
		 }
		 else
			 s+=max(1,badchar[txt[s+j]]);
	 }
 }
 public static void main(String []args) {
	 char txt[] = "DarDarhsuABCD".toCharArray();
	
	 char pat[] = "Dar".toCharArray();
	 search(txt, pat);
	 }

}