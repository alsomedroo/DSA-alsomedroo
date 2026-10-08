class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = 0;
        int li = n-1;
        int lj = m-1;
        List<Integer> arr = new ArrayList<>();
        int p = 0;
        while(i<=li && j<=lj){
            for(int x = j ; x<=lj ; x++){
                arr.add(matrix[i][x]);
            }
            i++;
            for(int x = i ; x<=li ; x++){
                arr.add(matrix[x][lj]);
            }
            lj--;
            if(i<=li){
                for(int x = lj ; x>=j ; x--){
                arr.add(matrix[li][x]);
                }
                li--;
            }
            if(j<=lj){
                for(int x = li ; x>=i ; x--){
                arr.add(matrix[x][j]);
                }
                j++;
            }

        }
        return arr;
    }
}