package LongestCommonSubsequence;

import java.util.Scanner;

public class LcsWithMemoization {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String a=sc.next();
		String b=sc.next();
		int dp[][]=new int[a.length()+1][b.length()+1];
		
		for(int i=0;i<=a.length();i++)
		{
			for(int j=0;j<=b.length();j++)
			{
				dp[i][j]=-1;
			}
		}
		
		System.out.println("Length of the longest common subsequence is "+Lcs(a,b,a.length(),b.length(),dp));

	}
	
	private static int Lcs(String a,String b,int n ,int m ,int dp[][]) {
	  
		if(n==0||m==0)
			return 0;
		if(a.charAt(n-1)==b.charAt(m-1)) {
			dp[n-1][m-1]=1;
			return 1+Lcs(a,b,n-1,m-1,dp);
		}
		
		int f=0;
		int g=0;
		if(dp[n-1][m]!=-1) {
			f=dp[n-1][m];
			
		}
		else { 
			f=Lcs(a,b,n-1,m,dp);
			dp[n-1][m]=f;
		}
		if(dp[n][m-1]!=-1)
			g=dp[n][m-1];
		else {
			g=Lcs(a,b,n,m-1,dp);
			dp[n][m-1]=g;
		}
		
		
		return Math.max(f, g);
	
	}

}
