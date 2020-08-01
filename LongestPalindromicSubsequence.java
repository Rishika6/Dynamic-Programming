package LongestCommonSubsequence;

import java.util.Scanner;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		String v="";
		for(int i=s.length()-1;i>=0;i--)
		{
			v+=s.charAt(i);
		}
		
		//now the problem becomes same as lcs between two strings
		
		int dp[][]=new int[s.length()+1][v.length()+1];
		for(int i=0;i<s.length()+1;i++)
		{
			for(int j=0;j<v.length()+1;j++)
			{
				if(i==0||j==0)
					dp[i][j]=0;
			}
		}
		
		
		for(int i=1;i<=s.length();i++)
		{
			for(int j=1;j<=v.length();j++)
			{
					if(s.charAt(i-1)==v.charAt(j-1))
						dp[i][j]=1+dp[i-1][j-1];
					
					else
						dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		
		int i=s.length();
		int j=v.length();
		String res="";
		while(i>0&&j>0)
		{
			if(s.charAt(i-1)==v.charAt(j-1))
			{
				res=s.charAt(i-1)+res;
				i--;
				j--;
			}
			else
			{
				if(dp[i-1][j]>dp[i][j-1])
					i--;
				else
					j--;
			}
		}
		
		System.out.println(res);
		

	}

}
