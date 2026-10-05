class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;

        int c = 0;

        StringBuilder ans = new StringBuilder();
        while(i>=0 || j>=0 || c!=0){
            //ans+=c;
            int t = c;
            if(i>=0){
                t+=num1.charAt(i--)-'0';
            }

            if(j>=0){
                t+=num2.charAt(j--)-'0';
            }

            ans.append(t%10);
            c=t/10;

           
        }

        return ans.reverse().toString();
    }
}