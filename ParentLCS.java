package LongestCommonSubsequence;

import java.util.Scanner;

public class ParentLCS {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String a=sc.next();
		String b=sc.next();
		
		System.out.println("Length of the longest common subsequence is "+Lcs(a,b,a.length(),b.length()));
		
		

	}
	
	private static int Lcs(String a,String b,int n,int m) {
		if(n==0||m==0)
			return 0;
		else if(a.charAt(n-1)==b.charAt(m-1))
			return 1+Lcs(a,b,n-1,m-1);
		else
		  return Math.max(Lcs(a,b,n,m-1),Lcs(a,b,n-1,m));
		
	}

}
