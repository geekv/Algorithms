public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;
    public LinkedListStack(){
        list = new LinkedList<>();
    }
    //在链表栈中查看元素大小
    @Override
    public int getSize(){
        return list.getSize();
    }
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }
    //在链表栈中增加一个元素
    @Override
    public void push(E e){
        list.addFirst(e);
    }
    //查看头元素
    @Override
    public E peek(){
        return list.getFirst();
    }
    //删除一个元素
    @Override
    public E pop(){
        return list.removeFirst();
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {

        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
