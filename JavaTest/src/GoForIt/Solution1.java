package GoForIt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by NoClay on 2016/11/11.
 */
public class Solution1 {
    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
     * 输入这样的一个二维数组和一个整数，判断数组中是否含
     * 有该整数。
     *
     * @param array
     * @param target
     * @return
     */
    public boolean Find(int[][] array, int target) {
        int row = array.length - 1;
        int col = 0;
        int end = 0;
        while (true) {
            if (end < array.length &&
                    array[end].length != 0 &&
                    target > array[end][array[end].length - 1]) {
                end++;
            } else {
                break;
            }
        }
        while (row >= end && col != array[end].length) {
            //首先找到合适的左下角开始点
            if (target < array[row][col]) {
                row--;
            } else if (target > array[row][col]) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp == ' ') {
                string.append("%20");
            } else {
                string.append(temp);
            }
        }
        return string.toString();
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    /**
     *    public class ListNode {
     *        int val;
     *        ListNode next = null;
     *
     *        ListNode(int val) {
     *            this.val = val;
     *        }
     *    }
     *
     */
    /**
     * 输入一个链表，从尾到头打印链表每个节点的值。
     *
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ListNode listNode = new ListNode(67);
//        listNode.next = new ListNode(0);
//        listNode.next.next = new ListNode(24);
//        listNode.next.next.next = new ListNode(56);
        ArrayList<Integer> a = new ArrayList<>();
        while (listNode != null) {
            a.add(listNode.val);
            listNode = listNode.next;

        }
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = a.size() - 1; i >= 0; i--) {
            b.add(a.get(i));
            System.out.println(a.get(i));
        }
        return b;
    }


    /**
     * Definition for binary tree
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null){
            return null;
        }
        java.util.HashMap<Integer, Integer> key = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            key.put(in[i], i);
        }

        return reConstruct(pre, 0, pre.length - 1, in, 0, in.length - 1, key);
    }

    public TreeNode reConstruct(int []pre, int si, int ei, int []in, int sj, int ej,
                                java.util.HashMap<Integer, Integer> key){
        if (si > ei){
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[si]);
        int pos = key.get(pre[si]);
        treeNode.left = reConstruct(pre, si + 1, si + pos - sj, in, sj, pos - 1, key);
        treeNode.right = reConstruct(pre, si + pos - sj + 1, ei, in, pos + 1, ej, key);
        return treeNode;
    }


    public static void main(String[] args) {


        int[][] a = {

                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
    }
}
