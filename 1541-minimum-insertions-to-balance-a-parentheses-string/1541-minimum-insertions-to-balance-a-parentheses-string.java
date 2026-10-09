class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int ans = 0;
        for(int i = 0 ; i<n ; i++){
            char c = s.charAt(i);
            if(c=='('){
                st.push('(');
            }else{
                if(st.isEmpty()){
                    if(i==n-1)ans+=2;
                    else{
                        if(s.charAt(i+1)==')'){
                            ans+=1;
                            i++;
                        }
                        else ans+=2;
                    }
                }else{
                    if(i==n-1){
                        ans+=1;
                    }else{
                        if(s.charAt(i+1)==')'){
                            i++;
                        }else{
                            ans+=1;
                        }
                    }
                    st.pop();
                }
            }
        }
        return ans+(st.size()*2);
    }
}