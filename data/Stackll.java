package data;

import java.util.LinkedList;

public class Stackll {
    LinkedList<Integer> lst = new LinkedList<>();
    public int push (int i){
        lst.add(i);
        return i;
    }
    public int pop(){
       return lst.removeLast();
    }
    public int peek(){
        return lst.peekLast();
    }
    public int size(){
        return lst.size();
    }

    @Override
    public String toString() {
        return "Stackll{" +
                 lst +
                '}';
    }

    public static void main(String[] args) {
        Stackll stack = new Stackll();
        for (int i = 0; i < 10; i ++)stack.push(i);
        System.out.println(stack.peek());
        System.out.println(stack);


    }
}
