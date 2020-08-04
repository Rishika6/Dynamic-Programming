package LongestCommonSubsequence;

import java.util.Scanner;

public class LongestRepeatingSubsequence {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		String w=s;
		
		int dp[][]=new int[s.length()+1][w.length()+1];
		
		for(int i=0;i<=s.length();i++)
		{
			for(int j=0;j<=w.length();j++)
			{
				if(i==0||j==0)
					dp[i][j]=0;
			}
		}
		
		
		for(int i=1;i<=s.length();i++)
		{
			for(int j=1;j<=s.length();j++)
			{
				if((s.charAt(i-1)==w.charAt(j-1))&&i!=j)
					dp[i][j]=1+dp[i-1][j-1];
				else
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		
	    System.out.println("The length of the longest repeating subsequence is "+dp[s.length()][w.length()]);
	    
	    
	    int i=s.length();
	    int j=w.length();
	    
	    String res="";
	    while(i>0&&j>0)
	    {
	    	if((s.charAt(i-1)==w.charAt(j-1))&&i!=j) {
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
