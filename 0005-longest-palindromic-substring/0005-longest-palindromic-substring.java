class Solution {
    String[][] dp;
    public boolean check(int i, int j, String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    public String fn(int i, int j, String s){
        if(i>j)return "";
        if(i==j)return dp[i][j] = s.substring(i,i+1);

        if(dp[i][j]!=null)return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            if(check(i+1,j-1,s)==true)return dp[i][j] = s.substring(i,j+1);
        }
        String a = fn(i+1,j,s);
        String b = fn(i,j-1,s);
        return dp[i][j] = a.length()>=b.length()?a:b;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new String[n+1][n+1];
        return fn(0,n-1,s);
    }
}