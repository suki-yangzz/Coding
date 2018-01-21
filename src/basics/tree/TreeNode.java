package basics.tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int x) {
        this.val = x;
        this.left = null;
        this.right = null;
    }

    TreeNode getTree() {

        TreeNode T0 = null;
        TreeNode T1 = new TreeNode(1);
        TreeNode T2 = new TreeNode(2);
        TreeNode T3 = new TreeNode(3);
        TreeNode T4 = new TreeNode(4);
        TreeNode T5 = new TreeNode(5);
        TreeNode T6 = new TreeNode(6);
        TreeNode T7 = new TreeNode(7);

        T1.left = T2;
        T1.right = T3;
        T2.left = T4;
        T2.right = T5;
        T3.right = T6;
        T6.left = T7;

        return T1;

    }
}
