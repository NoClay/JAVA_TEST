package GoForIt;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by NoClay on 2016/12/11.
 */
public class Solution6 {
    /**
     * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��
     * ÿһ�����֣����磬����������¾���
     * 1 2 3 4
     * 5 6 7 8
     * 9 10 11 12
     * 13 14 15 16 �����δ�ӡ������
     * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        printMatrixClockWisely(matrix, 0, 0,
                matrix.length - 1,
                matrix[0].length - 1, result);
        return result;
    }

    public void printMatrixClockWisely(int[][] matrix, int startRow, int startCol, int endRow, int endCol, ArrayList<Integer> result) {
        if (startRow < endRow && startCol < endCol) {
            for (int j = startCol; j <= endCol; j++) {
                result.add(matrix[startRow][j]);
            }   //Right
            for (int i = startRow + 1; i <= endRow - 1; i++) {
                result.add(matrix[i][endCol]);
            }     //Down
            for (int j = endCol; j >= startCol; j--) {
                result.add(matrix[endRow][j]);
            }     //Left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                result.add(matrix[i][startCol]);
            }   //Up
            printMatrixClockWisely(matrix, startRow + 1, startCol + 1, endRow - 1, endCol - 1, result);
        } else if (startRow == endRow && startCol < endCol) {
            for (int j = startCol; j <= endCol; j++) {
                result.add(matrix[startRow][j]);
            }
        } else if (startRow < endRow && startCol == endCol) {
            for (int i = startRow; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }
        } else if (startRow == endRow && startCol == endCol) {
            result.add(matrix[startRow][startCol]);
        } else {
            return;
        }
    }

//    ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
//    Stack<Integer> real;
//    Stack<Integer> min;
//    public void push(int node) {
//        if (real == null){
//            real = new Stack<>();
//        }
//        if (min == null){
//            min = new Stack<>();
//        }
//        real.push(node);
//        if (min.isEmpty()){
//            min.push(node);
//        }else if (min.peek() > node){
//            min.push(node);
//        }
//        real.push(node);
//    }
//
//    public void pop() {
//        if (real == null || real.isEmpty()){
//            return;
//        }
//        int num = real.pop();
//        if (!min.isEmpty() && min.peek() == num){
//            min.pop();
//        }
//    }
//
//    public int top() {
//        return real.peek();
//    }
//
//    public int min() {
//        return min.peek();
//    }

    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    Integer temp = null;

    public void push(int node) {
        if (temp != null) {
            if (node <= temp) {
                temp = node;
                min.push(node);
            }
            data.push(node);
        } else {
            temp = node;
            data.push(node);
            min.push(node);
        }
    }

    public void pop() {
        int num = data.pop();
        int num2 = min.pop();
        if (num != num2) {
            min.push(num2);
        }
    }

    public int top() {
        int num = data.pop();
        data.push(num);
        return num;
    }

    public int min() {
        int num = min.pop();
        min.push(num);
        return num;
    }

    //    ���������������У���һ�����б�ʾջ��ѹ��˳�����ж�
//    �ڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ����������
//    ������ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4��
//    5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2��
//    �������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�
//    ������ȵģ�
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length != popA.length) {
            return false;
        } else if (pushA.length == 0 && popA.length == 0) {
            return true;
        }
        Stack<Integer> real = new Stack<>();
        int temp = 0;
        for (int i = 0; i < pushA.length; i++) {
            real.push(pushA[i]);
            while (!real.empty() && real.peek() == popA[temp]) {
                real.pop();
                temp++;
            }
        }
        return real.empty();
    }

//    �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {


        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            result.add(treeNode.val);
            if (treeNode.left != null) queue.add(treeNode.left);
            if (treeNode.right != null) queue.add(treeNode.right);
        }
        return result;
    }

    /**
     * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
     * ����������Yes,�������No���������������������������ֶ�������ͬ��
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return judge(sequence, 0, sequence.length - 1);
    }

    private boolean judge(int[] sequence, int left, int right) {
        int pos = right - 1;
        if (left >= right) {
            return true;
        }
        while (pos >= 0 && sequence[pos] > sequence[right]) {
            pos--;
        }
        for (int j = pos; j >= left; j--) {
            if (sequence[j] > sequence[right]) {
                return false;
            }
        }
        return judge(sequence, left, pos) && judge(sequence, pos + 1, right - 1);
    }

    /*    ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ
        ��������������·����·������Ϊ�����ĸ���㿪ʼ����һֱ
        ��Ҷ����������Ľ���γ�һ��·����*/
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> flag = new ArrayList<>();
        int count = 0;
        findTreeNode(result, target, root, flag, count);
        return result;
    }

    private void findTreeNode(ArrayList<ArrayList<Integer>> result,
                              int target, TreeNode root, ArrayList<Integer> flag, int count) {
        if (root == null) {
            return;
        }
        count += root.val;
        if (root.left == null && root.right == null) {
            //Ҷ�ӽڵ�
            if (count == target) {
                flag.add(root.val);
                result.add(new ArrayList<Integer>(flag));
                flag.remove(flag.size() - 1);
            }
            return;
        }
        flag.add(root.val);
        findTreeNode(result, target, root.left, flag, count);
        findTreeNode(result, target, root.right, flag, count);
        flag.remove(flag.size() - 1);
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int[][] martix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] test = {{1}};
        int[][] test1 = {{1}, {2}, {3}, {4}, {5}};
        int[][] test2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
//        ArrayList<Integer> list = solution6.PrintFromTopToBottom(root);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(" " + list.get(i));
//        }
//        System.out.println(solution6.VerifySquenceOfBST(new int[]{4, 6, 8, 12, 16, 14, 10}));
//        solution6.IsPopOrder(push, pop);
//        solution6.printMatrix(test2);
        solution6.FindPath(root, 8);
    }
}
