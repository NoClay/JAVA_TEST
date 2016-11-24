package GoForIt;

/**
 * Created by NoClay on 2016/11/16.
 */
public class Solution5 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        if (root2 != root1.left && root2 != root1.right){
            return true;
        }
        boolean flag = false;
        if (root1.val == root2.val){
            flag = isSubTree(root1, root2);
        }
        if (!flag){
            flag = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
        return flag;
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val == root2.val){
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }
        return false;
    }

    public void Mirror(TreeNode root) {
        if (root == null){
            return;
        }else{
            TreeNode temp = null;
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
