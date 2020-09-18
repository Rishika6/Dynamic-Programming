package MatrixChainMultiplication;
import java.util.*;
public class PalindromicPartitioning {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		
		System.out.println(Solve(s,0,s.length()-1));
				

	}
	
	public static int Solve(String s,int i,int j) {
		if(i>=j)
			return 0;
		if(isPalindrome(s,i,j))
			return 0;
		int ans=Integer.MAX_VALUE;
		for(int k=i;k<j;k++) {
			int min=Solve(s,i,k)+Solve(s,k+1,j)+1;
			ans=Math.min(ans,min);
		}
		
		return ans;
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
