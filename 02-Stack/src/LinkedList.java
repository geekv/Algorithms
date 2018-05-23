public class LinkedList<E> {

    //创建内部类Node
    private class Node{         

        private E e;
        private Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this.e =e;
            this.next =null;
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){          
            return e.toString();
        }
    }

//    private Node head;       
    private Node dummyhead;
    private int size;
    //构造函数
    public LinkedList(){
//        head = null;         
        dummyhead = new Node();
        size = 0;
    }
    //获取链表元素个数
    public int getSize(){
        return size;
    }
    //// 获得链表的第index(0-based)个位置的元素
    //    // 在链表中不是一个常用的操作，练习用：）
    public E get(int index){         //需要一个一个取
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur = dummyhead.next;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur.e;
    }
    //查看头元素
    public E getFirst(){
       return get(0);
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(E e ,int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");


//        Node prev = head;
        Node prev =dummyhead;
        for (int i = 0;i<index;i++){
            prev=prev.next;
        }
//        Node node = new Node(e);
//        node.next =prev.next;
//        prev.next = node;
        prev.next = new Node(e,prev.next);
        size++;

    }
    //在链表头添加元素e
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head =node;        
//        head = new Node(e,head);
//        size++;
        add(e,0);
    }
    // 在链表末尾添加新的元素e
    public void addLast(E e){
        add(e,size);
    }

    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：
    public void set(E e ,int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("failed. Illegal index.");
        Node cur = dummyhead.next;
        for(int i =0;i<index;i++)
            cur =cur.next;
        cur.e =e;
    }
    // 查找链表中是否有元素e
    public boolean contain(E e){
        Node cur = dummyhead.next;
        while (cur != null){
            if(cur.e ==e)
                return true;
        }
        return false;
    }

    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E remove(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node prev = dummyhead;         
        for(int i =0; i<index;i++){
            prev=prev.next;
        }
        Node delnode = prev.next;
        prev.next = delnode.next;
        delnode.next = null;
        size--;

        return delnode.e;
    }
    // 从链表中删除元素e
    public void reMoveEle(E e){

        Node prev = dummyhead;
        while (prev.next !=null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }
        if (prev.next !=null){
            Node delnode = prev.next;
            prev.next = delnode.next;
            delnode.next = null;
            size--;
        }

    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }
    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size);
    }
    @Override
    public String toString(){
        StringBuilder res =new StringBuilder();
        for(Node cur= dummyhead.next;cur != null;cur=cur.next)
            res.append(cur + "->");
        res.append("NUlL");
        return res.toString();
    }

}
