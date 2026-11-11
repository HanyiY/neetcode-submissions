class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] answer=new int[m][n];for(int[] row:answer)Arrays.fill(row,-1);int r=0,c=0,direction=0;int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};while(head!=null){answer[r][c]=head.val;head=head.next;if(head==null)break;int a=r+dirs[direction][0],b=c+dirs[direction][1];if(a<0||a>=m||b<0||b>=n||answer[a][b]!=-1)direction=(direction+1)%4;r+=dirs[direction][0];c+=dirs[direction][1];}return answer;
    }
}
