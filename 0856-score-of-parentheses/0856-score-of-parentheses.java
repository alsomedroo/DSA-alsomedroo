class Solution {
    public int fn(String s){
        if(s.length()==2)return 1;
        
        Stack<Character> st = new Stack<>();
        
        int j = 0;
        int ans = 0;
        for(int i = 0; i<s.length() ; i++){
            Character c = s.charAt(i);
            if(c=='(')st.push('(');
            else{
                if(st.size()>1)st.pop();
                else{
                    if(j==0 && i==s.length()-1)ans=2*fn(s.substring(1,i));
                    else ans+=fn(s.substring(j,i+1));
                    st.pop();
                    j=i+1;
                    
                }
            }
        }
        return ans;
    }
    public int scoreOfParentheses(String s) {
        int n = s.length();
        if(n==0)return 0;
        return fn(s);

    }
}