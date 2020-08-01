package LongestCommonSubsequence;
// only insertions and deletions are allowed in string a to make it string b 
import java.util.Scanner;

public class StringAtoB {

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
				if(i==0||j==0)
					dp[i][j]=0;
			}
		}
		
		for(int i=1;i<=a.length();i++)
		{
			for(int j=1;j<=b.length();j++)
			{
				if(a.charAt(i-1)==b.charAt(j-1))
					dp[i][j]=1+dp[i-1][j-1];
				else
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		
		int i=a.length();
		int j=b.length();
		String lcs="";
		while(i>0&&j>0)
		{
			if(a.charAt(i-1)==b.charAt(j-1)) {
				lcs=a.charAt(i-1)+lcs;
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
		
		int count=0;
		
		//deletions count
		for(int k=0;k<a.length();k++)
		{
			if(!lcs.contains(a.subSequence(k,k+1)))
				count++;
		}
		
		//insertions
		for(int k=0;k<b.length();k++)
		{
			if(!lcs.contains(b.subSequence(k,k+1)))
				count++;
		}
		
       System.out.println("Total number of insertions and deletions needed :"+count);
	}

}
