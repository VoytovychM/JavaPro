package lessonalgorithm20240430;

public class MyTree {

    private class TreeNode{
    int value;
    MyTree left = null;
    MyTree right = null;
    private int balance = 0;

    public TreeNode(int value, MyTree left, MyTree right){
        this.value = value;
        this.left = left;
        this.right = right;
    }


        public void setLeft(MyTree left) {
            this.left = left;
        }

    public void setRight(MyTree right) {
        this.right = right;

    }

    }
}