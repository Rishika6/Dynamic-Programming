package MatrixChainMultiplication;

import java.util.Scanner;

//Memoization of the recursive version
public class MainMemo {

	public static void main(String[] args) {
	   
		 Scanner sc=new Scanner(System.in);
		 int n=sc.nextInt();
		 int a[]=new int[n];
		 for(int i=0;i<n;i++) {
			 a[i]=sc.nextInt();
		 }
		 
		 int dp[][]=new int[n][n];
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<n;j++) {
				 dp[i][j]=-1;
			 }
		 }
		 System.out.println(Solve(a,1,n-1,dp));

	}
	
	public static int Solve(int a[],int i,int j,int dp[][]) {
		if(i>=j)
			return 0;
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int ans=Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++) {
			int c=0;
			int b=0;
			
		
				c=Solve(a,i,k,dp);
				
				b=Solve(a,k+1,j,dp);
				
		
			
			int f=b+c+a[i-1]*a[k]*a[j];
			ans=Math.min(ans, f);
		}
		
		dp[i][j]=ans;
		return dp[i][j];
		
	}

}
