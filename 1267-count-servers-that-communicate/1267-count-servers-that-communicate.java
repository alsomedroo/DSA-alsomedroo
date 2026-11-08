class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0 ; i<n ; i++){
            int x = 0;
            for(int j = 0 ; j<m ; j++){
                if(grid[i][j]==1){
                    x++;
                }
            }
            if(x>1){
                ans+=x;
                for(int j = 0 ; j<m ; j++){
                    if(grid[i][j]==1)grid[i][j]=2;
                }
            }
        }
        for(int i = 0 ; i<m ; i++){
            int x = 0;
            for(int j = 0; j<n ; j++){
                x+=grid[j][i];
            }
            if(x>1){
                for(int j = 0; j<n ; j++){
                    if(grid[j][i]==1)ans++;
                }
            }
        }
        return ans;
    }
}