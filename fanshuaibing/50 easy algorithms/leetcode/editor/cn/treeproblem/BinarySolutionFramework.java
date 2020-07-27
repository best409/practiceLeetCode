/**
 * 二叉树解题框架
 * 解题技巧：把当前节点要做的事做好，其他的交给递归框架，不用当前节点操心
 */

/**
 * 基本框架
 */
void traverse(TreeNode root){
        /**
         * 此处写逻辑处理，其余的进行递归
         */
        traverse(root.left);
        traverse(root.right);
}

/**
 * eg:把二叉树所有的节点中的值加1
 */

void traverse(TreeNode root){
        if(root==null)return;
        root.val++;

        traverse(root.left);
        traverse(root.right);
}


/**
 * BST:二叉搜索树的基本框架
 * 判断 BST 的合法性、增、删、查。
 */

/**
 * BST的合法性
 * 需给出树的最小值和最大值，作为入参
 */
boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {

   if (root == null) return true;
   if (min != null && root.val <= min.val) return false;
   if (max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root)//root此时为左子树的最大值
            && isValidBST(root.right, root, max);//root此时为右子树的最小值
}


/**
 * 在 BST 中查找一个数是否存在
 */

boolean isInBST(TreeNode root,int target){
    //节点null
    if(root==null)return false;
    //找到目标节点
    if(root.val==target)
         return true;
    //搜索右子树
    if(root.val<target)
         return isInBST(root.right,target);
    //搜索左子树
    if(root.val>target)
         return isInBST(root.left,target);
}


/**
 * 在 BST 中插入一个数
 */

TreeNode insertIntoBST(TreeNode root, int val) {
   // 找到空位置插入新节点
   if (root == null) return new TreeNode(val);
   //val值应放到右子树的位置
   if (root.val < val)
       root.right = insertIntoBST(root.right, val);
   //val应放到左子树的位置
   if (root.val > val)
       root.left = insertIntoBST(root.left, val);
   return root;
}

/**
 * 在 BST 中删除一个数
 */

TreeNode deleteNode(TreeNode root, int key) {
   if (root == null) return null;
   //找到了，判断左孩子和右孩子是否存在
        /**
         * 1:存在左孩子不存在右孩子
         * 2：存在右孩子，不存在左孩子
         * 3：左右孩子都存在
         */
   if (root.val == key) {
   // 这两个 if 把情况 1 和 2 都正确处理了
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
   // 处理情况 3
        TreeNode minNode = getMin(root.right);
        root.val = minNode.val;
        root.right = deleteNode(root.right, minNode.val);
   } else if (root.val > key) {
        root.left = deleteNode(root.left, key);
   } else if (root.val < key) {
        root.right = deleteNode(root.right, key);
   }
   return root;
}

TreeNode getMin(TreeNode node) {
        // BST 最左边的就是最小的
        while (node.left != null) node = node.left;
        return node;
}
