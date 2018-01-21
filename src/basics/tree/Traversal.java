package basics.tree;

import java.util.*;

public class Traversal {

    /* Recursive Traversal */
    private static void preOrderByRecur(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preOrderByRecur(node.left);
        preOrderByRecur(node.right);
    }

    private static void inOrderByRecur(TreeNode node) {
        if (node == null) return;
        inOrderByRecur(node.left);
        System.out.print(node.val + " ");
        inOrderByRecur(node.right);
    }

    private static void postOrderByRecur(TreeNode node) {
        if (node == null) return;
        postOrderByRecur(node.left);
        postOrderByRecur(node.right);
        System.out.print(node.val + " ");
    }

    /* Iterative Traversal */

    /*
     * 利用栈实现循环先序遍历二叉树
     * 这种实现类似于图的深度优先遍历（DFS）
     * 维护一个栈，将根节点入栈，然后只要栈不为空，出栈并访问，接着依次将访问节点的右节点、左节点入栈。
     * 这种方式应该是对先序遍历的一种特殊实现（看上去简单明了），但是不具备很好的扩展性，在中序和后序方式中不适用
     */
    private static void preOrderByItera_1(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            System.out.print(temp.val + " ");
            if (temp.right != null) s.push(temp.right);
            if (temp.left != null) s.push(temp.left);
        }
    }

    /*
     * 利用栈模拟递归过程实现循环先序遍历二叉树
     * 这种方式具备扩展性，它模拟递归的过程，将左子树点不断的压入栈，直到null，然后处理栈顶节点的右子树
     */
    private static void preOrderByItera_2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                System.out.print(root.val + " ");
                s.push(root);//先访问再入栈
                root = root.left;
            }
            root = s.pop();
            root = root.right;//如果是null，出栈并处理右子树
        }
    }

    /*
     * 利用栈模拟递归过程实现循环中序遍历二叉树
     * 思想和上面的preOrderStack_2相同，只是访问的时间是在左子树都处理完直到null的时候出栈并访问。
     */
    private static void inOrderByItera(TreeNode root) {

        if (root == null) return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            System.out.print(root.val + " ");
            root = root.right;//如果是null，出栈并处理右子树
        }

    }

    /* the best post order Traversal */
    private static List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) return null;

        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode temp = stack.peek();

            if (temp.left == null && temp.right == null) {
                result.add(stack.pop().val);
            } else {
                if (temp.right != null) {
                    stack.push(temp.right);
                    temp.right = null;
                }

                if (temp.left != null) {
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }

        return result;
    }


    private static List<Integer> preTraversal(TreeNode root) {

        if (root == null) return null;

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode temp = stack.pop();
            result.add(temp.val);

            if (temp.right != null) {
                stack.push(temp.right);
                temp.right = null;
            }

            if (temp.left != null) {
                stack.push(temp.left);
                temp.left = null;
            }

        }

        return result;
    }


    /* Traversal by Level */
    private static void levelTravel(TreeNode root) {

        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);

        System.out.println("\n PreOrder Traversal of binary tree is ");
        preOrderByRecur(root);
        System.out.print("\n");
        preOrderByItera_1(root);
        System.out.print("\n");
        preOrderByItera_2(root);

        System.out.println("\n InOrder Traversal of binary tree is ");
        inOrderByRecur(root);
        System.out.print("\n");
        inOrderByItera(root);

        System.out.println("\n PostOrder Traversal of binary tree is ");
        postOrderByRecur(root);
        postorderTraversal(root);

        System.out.println("\n Level Traversal of binary tree is ");
        levelTravel(root);

        System.out.print("\n");

    }
}
