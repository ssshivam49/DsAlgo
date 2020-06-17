import java.io.*;
import java.util.*;
import java.lang.*;

/*
  @developer Shivam Kumar dated at 18/06/2020
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
	
	public static void findLcs(int dp[][], String s1, String s2,int m, int n){
		if(m>0 && n>0 && (s1.charAt(m-1)==s2.charAt(n-1))){
			findLcs(dp,s1,s2,m-1,n-1);
			System.out.print("  "+s1.charAt(m-1));
		}else if(m>0 && (n==0 || dp[m-1][n] >= dp[m][n-1])){
			findLcs(dp,s1,s2,m-1,n);
			System.out.print(" -"+s1.charAt(m-1));
		}else if(n>0 && (m==0 || dp[m][n-1]> dp[m-1][n])){
			findLcs(dp,s1,s2,m,n-1);
			System.out.print(" +"+s2.charAt(n-1));
		}
	}
	
	public static void lcs(String s1, String s2){
		int m = s1.length();
		int n= s2.length();
		int dp[][] = new int [m+1][n+1];
		lcsUtil(dp,s1,s2);
		System.out.println("matrix after calculation");
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		findLcs(dp,s1,s2,m,n);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		lcs(str1,str2);
	}
}
