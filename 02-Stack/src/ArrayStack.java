public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;   

    //构造函数
    public ArrayStack(int capacity){     
        array =  new Array<>(capacity);
    }
    public ArrayStack(){                 
        array =new Array<>();
    }
    //获得Size
    @Override
    public int getSize(){
        return array.getSize();
    }
    //栈是否为空
    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }
    //查看栈容量
    public int getCapacity(){
        return array.getCapacity();
    }
    //入栈
    @Override
    public void push(E e){
        array.addLast(e);
    }
    //出栈
    @Override
    public E pop(){
        return array.removeLast();
    }
    //查看栈顶元素
    @Override
    public E peek(){
        return array.getLast();
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack:");
        res.append("[");
        for (int i =0 ; i<array.getSize();i++){
            res.append(array.get(i));
            if (i !=array.getSize()-1)
                res.append(',');
        }
        res.append("] top");
        return res.toString();  
    }

}
