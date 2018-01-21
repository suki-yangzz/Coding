package algorithms;

import basics.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class ZigZagBFS {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        LinkedList<TreeNode> nodelist = new LinkedList<TreeNode>();
        boolean order = true;
        nodelist.offer(root);
        while(!nodelist.isEmpty()){
            int size = nodelist.size();
            ArrayList<Integer> al = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode node = nodelist.poll();
                if(order) al.add(node.val);
                else al.add(0,node.val);
                if(node.left != null) nodelist.offer(node.left);
                if(node.right != null) nodelist.offer(node.right);
            }
            order = !order;
            result.add(al);
        }
        return result;
    }

}
