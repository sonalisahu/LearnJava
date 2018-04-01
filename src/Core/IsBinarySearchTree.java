package Core;

public class IsBinarySearchTree {
	 
    public boolean isBinarySearchTree(BstNode root) {
 
        if(root == null) return Boolean.TRUE;
        return isBstValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
 
    private boolean isBstValid(BstNode root, Integer minValue, Integer maxValue) {
 
        if(root == null) return Boolean.TRUE;
        if(root.getData() >= minValue && root.getData() < maxValue
                && isBstValid(root.getLeft(), minValue, root.getData())
                && isBstValid(root.getRight(), root.getData(), maxValue)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}