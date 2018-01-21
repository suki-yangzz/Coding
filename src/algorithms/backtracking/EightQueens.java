package algorithms.backtracking;

public class EightQueens {
    /**下标i表示第几行，chess[i]表示第i行皇后的位置,注意此处0行不用*/
    public int[] chess;
    /**皇后的数目*/
    public int queenNum;
    /**解的数目*/
    public int methodNum;

    EightQueens(int queenNum) {
        this.queenNum = queenNum;
        this.chess = new int[queenNum+1];//注意，这里我们从第1行开始算起，第0行不用
        backtrack(1);//从第一个皇后开始递归
    }

    /**
     * 一行一行的确定该行的皇后位置
     * @param row
     */
    public void backtrack(int row)
    {
        if( row > queenNum) //如果当前行大于皇后数目，表示找到解了
        {
            methodNum++;//sum为所有的可行的解
            //依次打印本次解皇后的位置
            for(int m = 1; m <= queenNum; m++){
                //System.out.println(chess[m]);//这一行用输出当递归到叶节点的时候，一个可行解
                //这里只是为了好看才写成下面的
                for(int k =1; k <= queenNum;k++){
                    if(k == chess[m]){
                        System.out.print(chess[m]+" ");
                    }else {
                        System.out.print("* ");//用*表示没有被用到的位置
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
        else{
            for(int i = 1;i <= queenNum;i++)
            {
                chess[row] = i;//第t行上皇后的位置只能是1-queenNum
                if(place(row)) {//此处的place函数用来进行我们上面所说的条件的判断，如果成立，进入下一级递归,即放置下一个皇后
                    backtrack(row + 1);
                }
            }
        }
    }



    /**
     * 判断第k行皇后可以放置的位置
     * @param row chess[row]表示第row行上皇后的位置
     * @return boolean false表示此处不能放置皇后
     */
    public boolean place(int row) {
        for (int j = 1; j < row; j++)
            // 如果当前传入的第K行上的皇后放置的位置和其它皇后一个对角线(abs(chess[row]- chess[j])==abs(row-j)或一个直线上(chess[j] == chess[row])
            if (Math.abs(chess[row] - chess[j]) == Math.abs(row - j) || (chess[j] == chess[row])){
                return false;
            }
        return true;
    }

    public static void main(String[] args) {
        EightQueens queenTest = new EightQueens(8);
        System.out.println("总共解数为："+ queenTest.methodNum);

    }
}