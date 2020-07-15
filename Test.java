给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

class Solution {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}

给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。

 
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n<1){
            return new ArrayList<TreeNode>();
        }
        return generate(1,n);
    }

    private List<TreeNode> generate(int left,int right){
        List<TreeNode> res=new ArrayList<>();
        if(left>right){
            res.add(null);
            return res;
        }
        for(int i=left;i<=right;i++){
            List<TreeNode> leftList=generate(left,i-1);
            List<TreeNode> rightList=generate(i+1,right);

            for(TreeNode leftChild:leftList){
                for(TreeNode rightChild:rightList){
                    TreeNode root=new TreeNode(i);
                    root.left=leftChild;
                    root.right=rightChild;
                    res.add(root);
                }
            }
        }
        return res;
    }
}