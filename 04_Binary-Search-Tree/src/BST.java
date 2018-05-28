import java.util.Queue;
import java.util.LinkedList;
public class BST<E extends Comparable<E>> {

    private class Node{
        public Node left,right;         //在内部就不用private
        public E e;

        public Node(E e){
            this.e =e ;                                              
            left=null;
            right=null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size=0;
    }

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public void add(E e){
        if(root==null){
            root = new Node(e);
            size++;
        }
        else
            root =add(root,e);
    }
    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node,E e){
//        if(e.equals(node.e)){               //因为是compare接口，所以要用equals
//            return;
//        }
//        else if(e.compareTo(node.e)<0 && node.left == null){
//            node.left =new Node(e);
//            size++;
//            return;
//        }
//        else if(e.compareTo(node.e)>0 && node.right == null){
//            node.right=new Node(e);
//            size++;
//            return;
//        }
//
//        if(e.compareTo(node.e)<0)               
//            add(node.left,e);
//        else
//            add(node.right,e);
        //换个思维，假设我们插入的是一颗空的二叉树
        if(node == null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0)
            node.left = add(node.left,e);
        else if(e.compareTo(node.e)>0)
            node.right =add(node.right,e);
        return node;
    }

    public boolean contains(E e){
        return contains(root,e);  
    }
    private boolean contains(Node node,E e){
        if(node==null)
            return false;

        if(e.compareTo(node.e)<0)
            return contains(node.left,e);
        else if(e.compareTo(node.e)>0)
            return contains(node.right,e);
        else
            return true;
    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){            //错误写成 :queue != null.
            Node cur =queue.remove();
            System.out.println(cur.e);
            if(cur.left != null)           
                queue.add(cur.left);
            if(cur.right != null)
                queue.add(cur.right);
        }

    }
    //查找二分搜索树中最大和最小的值
    public E minmum(){
        if(size==0)                        //注意：root==null。可能树中有空的元素
            throw new IllegalArgumentException("BST is empty");
        return minmum(root).e;
    }

    private Node minmum(Node node){
        if(node.left ==null)
            return node;
        return  minmum(node.left);//值得注意，不能用node代替node.left，错误：node.left=minmun(node.left)
    }

    public E maxmum(){
        if(size==0)                        //注意：root==null。可能树中有空的元素
            throw new IllegalArgumentException("BST is empty");

        return maxmum(root).e;
    }
    private Node maxmum(Node node){
        if(node.left ==null)
            return node;

        return  maxmum(node.left);        //值得注意，不能用node代替node.left
    }




    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){

        root = remove(root,e);
    }

    private Node remove(Node node,E e){
        if( node == null )
            return null;

        if(e.compareTo(node.e)<0){
            node.left = remove(node.left,e);
            return node;                            //如果要返回根的话，就node.left=remove（..），如果不用就直接return
        }
        else if(e.compareTo(node.e)>0){
            node.right =remove(node.right,e);
            return node;
        }
        else{
            if(node.left ==null){
               Node rightNode = node.right;
               node.right=null;
               size--;
               return rightNode;
            }
            if(node.right==null){          
                Node leftnode = node.left;
                node.right=null;
                size--;
                return leftnode;
            }                               
            Node newnode = minmum(node.right);
            newnode.right= removeMin(node.right);       
            newnode.left=node.left;
            node.right=node.left=null;
            return newnode;


        }

    }
    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    public E removeMin(){
        E ret = minmum();
        root = removeMin(root);
        return ret;
    }
    // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根

    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right=null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;

    }
    public E removeMax(){
        E ret = maxmum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            Node leftnode = node.left;
            node.right=null;
            size--;
            return leftnode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }
    private void generateBSTString(Node node,int depth,StringBuilder res){
        if(node ==null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e +"\n");       //如何打印每个节点元素？
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }
    private String generateDepthString(int depth){
        StringBuilder res =new StringBuilder();
        for (int i =0;i<depth;i++)
            res.append("--");
        return res.toString();
    }
}
