package MatrixChainMultiplication;

import java.util.Scanner;

//given n matrices calculate the minimum cost of matrix multiplication
//i/p ---> given an array of matrix dimensions
//o/p----> integer
public class MainFormat {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 int n=sc.nextInt();
		 int a[]=new int[n];
		 for(int i=0;i<n;i++) {
			 a[i]=sc.nextInt();
		 }
		 //dimension of Mat1--->a[i-1]*a[i]
		 //two choices for choosing i and j
		 System.out.println(Solve(a,1,n-1));
		 
      
	}
	
	public static int Solve(int a[],int i,int j) {
		if(i>=j)
			return 0;
		int ans=Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++) {
			int temp=Solve(a,i,k)+Solve(a,k+1,j)+a[i-1]*a[k]*a[j];//temporary answer
			ans=Math.min(temp, ans);
		}
		
		return ans;
	}

}
