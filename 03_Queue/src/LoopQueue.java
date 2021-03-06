﻿public class LoopQueue<E> implements Queue<E> {

    private E[] data;   
    private int front;
    private int tail;
    private int size;
    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity+1];   
        front=0;
        tail=0;
        size=0;
    }
    public LoopQueue(){
        this(10);
    }
    @Override
    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length-1;     //记得减1，1是为了多预留一个位置，当tail+1==fron时，满
    }
    @Override
    public boolean isEmpty(){
        return tail==front;
    }
    @Override
    public E getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    @Override
    public void enqueue(E e){
        if((tail+1)%data.length == front)                           
            reSize(getCapacity()*2);                       //这里空间要和用户设置一致,故不能用data.length

        data[tail]=e;
        tail=(tail+1)%data.length;                    
        size++;

    }
    @Override
    public E dequeue(){
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E res = data[front];
        data[front] = null;
        front=(front+1)%data.length;   
        size--;
        if(size < getCapacity()/4 && getCapacity()/2 !=0)    
            reSize(getCapacity()/2);

        return res;
    }

    public void reSize(int newcapacity){
        E[] newdata = (E[])new Object[newcapacity+1];    
        for (int i=0;i<size;i++){
            newdata[i] = data[(i+front)%data.length];       //两个数组中偏移(i+front)的距离，因为是循环所以要求余总的空间

        }
        data =newdata;
        front = 0;
        tail = size;            
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front[");
        for (int i=front; i !=tail;i=(i+1)%data.length){   
            res.append(data[i]);
            if ((i + 1) % data.length != tail)         
                res.append(",");
        }
        res.append("]tail");
        return res.toString();
    }

    public static void main(String[] args) {

        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
