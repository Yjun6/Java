package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}


class Solution {
    public int sumNumbers(TreeNode root) {
        func(root);
        return count;
    }

    int count = 0;
    int count1 = 0;
    public void func(TreeNode root){
        if(root == null) return;
        count1 = count1*10+root.val;
        if(root.left == null && root.right == null){
            count += count1;
            count1 /= 10;
            return;
        }
        func(root.left);
        func(root.right);
        count1 /= 10;
    }
}
