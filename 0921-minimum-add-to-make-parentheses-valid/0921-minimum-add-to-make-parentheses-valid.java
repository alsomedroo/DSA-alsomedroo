class Solution {
    public int minAddToMakeValid(String s) {
        //Stack<Integer> st = new Stack<>();
        int ans = 0;
        int c = 0;
        for(int i = 0; i<s.length() ; i++){
            if(s.charAt(i)=='('){
                //st.push('(');
                c++;
            }
            else{
                //st.pop();
                c--;
            }
            if(c<0){
                ans+=(-c);
                c = 0;
            }
        }
        
        return ans + c;
    }
}