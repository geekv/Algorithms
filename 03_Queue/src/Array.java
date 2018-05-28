
public class Array<E> {          //要在类中引入E
    private E [] data;    
    private int size;


    //构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data = (E[])new Object[capacity];          //如何对泛型实例对象
        size = 0;
    }
    //无参构造函数，默认数组容量为capacity=10
    public Array(){
        this(10);
    }
    //查询元素个数
    public int getSize(){
        return size;
    }
    //查询容量
    public int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    //在所有元素末尾添加一个元素

    public void addLast(E e){
        add(size,e);
    }
    //在所有元素之间添加一个元素

    public void addFirst(E e){
        add(0,e);
    }
    //在数组中插入一个元素
    public void add(int index,E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed,Require index >= 0");

        if (size == data.length)
            resize(2 * data.length);

        for (int i = size-1; i >= index; i--)    
            data[i + 1] = data[i];

        data[index] = e;         
        size++;
    }
    //获取某个元素
    public E get(int index){
        if(index <0 || index>=size)
            throw new IllegalArgumentException("Get failed,Index is illegal");
        return data[index];
    }

    //修改某个元素
    public void set(int index,E e){
        if(index <0 || index>=size)
            throw new IllegalArgumentException("Get failed,Index is illegal");
        data[index] = e;
    }
    //查找数组是否包含元素e
    public boolean contains(E e){
        for(int i = 0;i<size;i++){
            if (data[i] == e)
                return true;
            }
            return false;   
    }
    //查找数组中元素e所在的索引，如果不存在元素e，则返-1
    public int find(E e){
        for(int i = 0;i<size;i++){
            if (e == data[i])
                return i;
        }
        return -1;
    }
    //查看最后一个元素
    public E getLast(){
        return get(size-1);
    }

    public E getFrist(){
        return get(0);
    }

    //从数组中删除index位置的元素，返回删除的元素
    public E remove(int index){
        if(index <0 || index>=size)
            throw new IllegalArgumentException("Get failed,Index is illegal");
        E res =data[index];
        for (int i =index+1;i<size;i++)
            data[i-1] = data[i];
        size--;
        data[size]=null;             //可要可不要，size指向的空间有值，垃圾回收器无法回收，用户也永远无法访问，故手动删除
        if (size<data.length/4 && data.length/2 != 0)          //lazy方法降低复杂度震荡，所以等到元素为1/4空间时，才缩容量
            resize(data.length/2);
        return res;
    }
    //删除数组中第一个元素
    public E removeFrist(){
        return remove(0);
    }
    //删除数组中最后一个元素，返回删除元素
    public E removeLast(){
        return remove(size-1);   
    }
    //从数据中删除元素e
    public E removeElement(E e){
        int i=find(e);
        return remove(i);
    }


    //查询数组元素
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d ,capacity =%d \n",size,data.length));
        res.append('[');
        for (int i=0; i <size;i++){
            res.append(data[i]);
            if (i !=size-1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int newcapacity){
        E[] newdata = (E[])new Object[newcapacity];           

        for(int i = 0;i<size;i++)
            newdata[i]=data[i];
        data=newdata;
    }
}
