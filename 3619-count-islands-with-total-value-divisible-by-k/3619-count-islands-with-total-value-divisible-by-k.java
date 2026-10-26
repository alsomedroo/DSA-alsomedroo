class Solution {
    int c;
    int[][] vis;
    public long fn(int i, int j, int[][] vis, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(i>=m || j>=n || i<0 || j<0)return 0;
        if(vis[i][j]==1)return 0;
        if(grid[i][j]==0)return 0;
        vis[i][j]=1;
        long x = fn(i+1,j,vis,grid);
        long y = fn(i-1,j,vis,grid);
        long z = fn(i,j+1,vis,grid);
        long a = fn(i,j-1,vis,grid);
        return x+y+z+a+grid[i][j];
    }
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        c = 0;
        vis = new int[m][n];
        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                if(vis[i][j]==0 && grid[i][j]!=0){
                    long csum = fn(i,j,vis,grid);
                    if(csum%k==0)c++;
                }
            }
        }
        return c;
    }
}