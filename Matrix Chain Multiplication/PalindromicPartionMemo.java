package MatrixChainMultiplication;
import java.util.*;
public class PalindromicPartionMemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		
		int dp[][]=new int[s.length()][s.length()];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp.length;j++) {
				dp[i][j]=-1;
			}
		}
		
	}
	
	public static int Solve(String s,int i,int j,int dp[][]) {
		
		if(i>=j)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];
		if(isPalindrome(s,i,j)) {
			dp[i][j]=0;
			return dp[i][j];
		}
		int ans=Integer.MAX_VALUE;
		for(int k=i;k<j;k++) {
			int min=Solve(s,i,k,dp)+Solve(s,k+1,j,dp)+1;
			ans=Math.min(ans,min);
		}
					
		dp[i][j]=ans;
		return dp[i][j];
		
	}
	
	
public static boolean isPalindrome(String s,int i,int j) {
		
		while(i<=j) {
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
		
		return true;
	}


}
