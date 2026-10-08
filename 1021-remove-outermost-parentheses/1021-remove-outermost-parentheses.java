class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int c = 0;
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<n ; i++){
            if(s.charAt(i)=='('){
                st.push('(');
                c++;
                if(c>1)sb.append('(');
                
            }
            else{
                st.pop();
                c--;
                if(c>0)sb.append(')');
            }
        }
        return sb.toString();
    }
}