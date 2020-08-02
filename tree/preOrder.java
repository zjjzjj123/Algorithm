public class Main{
     
      //递归前序遍历
        public void preOrder(TreeNode root,List<TreeNode> list) '
       {
         if(root == null)return;
         list.add(root);
         preOrder(root.left,list);
         preOrder(root.right,list);
      }
      
      //使用迭代的方法前序遍历 其中利用到了栈
     public void preWhile(TreeNode root ,List<TreeNode> list)
     {
        if(root == null)return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while((node!=null) || (!stack.isEmpty()))
        {
            while(node!=null)
            {
                list.add(node);
                stack.push(node);
                node = node.left; //一直找到最左叶子节点
            }
            node = stack.pop(); //得到最左叶子节点 然后再去判断有没有右子树
            node = node.right;
        } 

        //知道最后遍历完右子树 结束这棵树的遍历
     }
}
     
