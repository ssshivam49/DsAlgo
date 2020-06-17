import java.io.*;
import java.util.*;
import java.lang.*;

/*
  @developer Shivam Kumar
*/

public class Main {
	
	public static void lcsUtil(int dp[][], String str1, String str2){
		int m =str1.length();
		int n = str2.length();
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(str1.charAt(i-1)==str2.charAt(j-1)){
					dp[i][j] = 1+ dp[i-1][j-1];
				}else{
					dp[i][j] = Integer.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
	}
	
	public static String findLcs(int dp[][], String s1, String s2,int m, int n, String ans){
		if(m==0||n==0){
			return ans; 
		}
		if(s1.charAt(m-1)==s2.charAt(n-1)){
			return findLcs(dp,s1,s2,m-1,n-1,s1.charAt(m-1)+ans);
		}else if(dp[m-1][n]>dp[m][n-1]){
			return findLcs(dp,s1,s2,m-1,n,ans);
		}else{
			return findLcs(dp,s1,s2,m,n-1,ans);
		}
	}
	
	public static String lcs(String s1, String s2){
		int m = s1.length();
		int n= s2.length();
		int dp[][] = new int [m+1][n+1];
		lcsUtil(dp,s1,s2);
		return findLcs(dp,s1,s2,m,n,"");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		System.out.println("LCS is "+lcs(str1,str2));
	}
}
