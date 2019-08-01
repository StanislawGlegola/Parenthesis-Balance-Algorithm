package pharentisBalance;

public class Stack {
    int[] value;
    int size;
    int top;

    Stack(int aSize) {
        value = new int[aSize];
        size = aSize;
        top = size;
    }

    void push(int x) {
        if(!stackIsFull())
        value[--top] = x;
        else
            System.out.println("Stock is full");
    }

    int pop() {
        if (!stackIsEmpty())
            return value[top++];
        else
            return -1;
    }

    boolean stackIsEmpty() {
        return top == size;
    }

    boolean stackIsFull() {
        return top == 0;
    }
}
